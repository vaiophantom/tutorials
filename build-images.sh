#echo in green color
function greenEcho() {
    local GREEN NC
    GREEN='\033[0;32m'
    NC='\033[0m'
    printf "\n${GREEN}$@  ${NC}\n" >&2
}

set -e

greenEcho "start building gateway jar"
cd api/gateway/
./gradlew build -x test
greenEcho "DONE"

greenEcho "start building  shopping-cart jar"
cd ../shopping-cart
./gradlew build -x test
greenEcho "DONE"

greenEcho "start building  shopping-product jar"
cd ../shopping-product
./gradlew build -x test
greenEcho "DONE"


cd ../..

greenEcho "start copying all built jars to deployment folder"
cp -p ./api/gateway/build/libs/gateway-0.0.1-SNAPSHOT.jar ./deployment/gateway
cp -p ./api/shopping-cart/build/libs/shopping-cart-0.0.1-SNAPSHOT.jar ./deployment/cart
cp -p ./api/shopping-product/build/libs/shopping-product-0.0.1-SNAPSHOT.jar ./deployment/product
greenEcho "DONE"

greenEcho "start building docker images"
cd deployment
docker-compose build --no-cache
greenEcho "DONE"
