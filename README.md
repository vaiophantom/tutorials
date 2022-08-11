# iCommerce

##Prerequisite
| Env            | Description                |
|----------------|----------------------------|
| MacOS          | version Monterey 12.2.1    |
| JDK            | version 11                 |
| docker         | version 20.10.12 or higher |
| docker-compose | version 1.29.2 or higher   |

## List of components

###Microservices

- gateway
- shopping-product
- shopping-cart

###User Interface

- my-app

###Deployment

- Contain docker-compose.yml and related Dockerfile for correspondent services. 

##Build docker images

- Change mode for script file: `sudo chmod -R 777 build-images.sh`
- Run script file to build whole project, as well as building docker images: `./build-images.sh`
- After building, the deployment folder structure will be as following:

![img_1.png](img_1.png)

## Run Services

###Docker Compose
is used to run Microservices, Consul and MySQL as multicontainer Docker applications.

- To add the services, run
    - `$ docker-compose up`, or
    - `$ docker-compose up -d [service1, service2, ...]`
- To start the services, run
    - `$ docker-compose start`, or
    - `$ docker-compose start -d [service1, service2, ...]`
- To stop the services _(without deleting states)_, run
    - `$ docker-compose stop`, or
    - `$ docker-compose stop [service1, service2, ...]`
- To remove containers and delete saved states, run
    - `$ docker-compose down -v`

After everything is up,

- Open http://localhost:8500/ui/dc1/services to see the list of running services.

![img.png](img.png)

- Open docker application to see list of services being run by docker-compose

![img_5.png](img_5.png)

###ReactJS

- cd to application folder: `cd ui/my-app`
- To build the application: `npm install`
- To run the application: `npm run`
- List product screen:

![img_2.png](img_2.png)

- Cart details screen:

![img_3.png](img_3.png)

- Checkout screen:

![img_4.png](img_4.png)

## Things to Note

- **MySQL**
  - Create table structure and insert data before starting `shopping-cart` & `shopping product` services.
    - init.sql file will be located in `deployment/mysql/sql/init.sql`
    - Run it using your preferable MySQL Tool (example: MySQLWorkbench).

- **Just In Case**
    - If something goes wrong, you might need to bring down the services, rebuild the images and restart the containers. Just run
      ```
      $ docker-compose down -v
      $ docker-compose build --no-cache
      $ docker-compose up
      ```

## Basic Configurations

- Specify MySQL version in `.env`
- MySQL:
    - `mysql/config/mysql.cnf`
    - Save the config file as _read-only_ or else configurations will fail.
- Refer to `docker-compose.yml` for configurations like username, password, ports, etc.
