-- ----------------------------
-- category table structure
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
                             `id` bigint(0) NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                             `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                             `created_datetime` bigint(0) NULL DEFAULT NULL,
                             `created_by` bigint(0) NULL DEFAULT NULL,
                             `updated_datetime` bigint(0) NULL DEFAULT NULL,
                             `updated_by` bigint(0) NULL DEFAULT NULL,
                             `status` bit(1) NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO category(id, name, description, created_datetime, created_by, updated_datetime, updated_by, status)
values (1, 'Car', 'Vehicle', 2022080110103, 1, NULL, NULL, 1);
INSERT INTO category(id, name, description, created_datetime, created_by, updated_datetime, updated_by, status)
values (2, 'Motobike', 'Transportation', 2022080110104, 1, NULL, NULL, 1);

-- ----------------------------
-- branch table structure
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch`  (
                             `id` bigint(0) NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                             `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                             `status` bit(1) NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO branch(id, name, description, status) VALUES (1, 'Toyota', 'Japanese branch', 1);
INSERT INTO branch(id, name, description, status) VALUES (2, 'BMW', 'German branch', 1);
INSERT INTO branch(id, name, description, status) VALUES (3, 'Ducati', 'Italian branch', 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
                            `id` bigint(0) NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                            `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                            `created_datetime` bigint(0) NULL DEFAULT NULL,
                            `created_by` bigint(0) NULL DEFAULT NULL,
                            `updated_datetime` bigint(0) NULL DEFAULT NULL,
                            `updated_by` bigint(0) NULL DEFAULT NULL,
                            `price` decimal(19, 2) NULL DEFAULT NULL,
                            `color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                            `quantity` smallint(0) NOT NULL DEFAULT 0,
                            `status` bit(1) NULL DEFAULT NULL,
                            `category_id` bigint(0) NOT NULL,
                            `branch_id` bigint(0) NOT NULL,
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `product_idx`(`category_id`) USING BTREE,
                            CONSTRAINT `product_idx` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                            FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO product(id, name, description, created_datetime, created_by, updated_datetime, updated_by,
                    price, color, quantity, status, category_id, branch_id)
values(1, 'Vios', 'segment B', 2022080110103, 1, NULL, NULL, 100, 'Red', 10, 1, 1, 1);
INSERT INTO product(id, name, description, created_datetime, created_by, updated_datetime, updated_by,
                    price, color, quantity, status, category_id, branch_id)
values(2, 'Camry', 'segment D', 2022080110104, 1, NULL, NULL, 102, 'Black', 10, 1, 1, 1);
INSERT INTO product(id, name, description, created_datetime, created_by, updated_datetime, updated_by,
                    price, color, quantity, status, category_id, branch_id)
values(3, '530i', 'petrol car', 2022080110105, 1, NULL, NULL, 10, 'Black', 10, 1, 1, 2);
INSERT INTO product(id, name, description, created_datetime, created_by, updated_datetime, updated_by,
                    price, color, quantity, status, category_id, branch_id)
values(4, '530e', 'electric car', 2022080110107, 1, NULL, NULL, 10, 'Black', 10, 1, 1, 2);
INSERT INTO product(id, name, description, created_datetime, created_by, updated_datetime, updated_by,
                    price, color, quantity, status, category_id, branch_id)
values(5, '750Li', 'luxury car', 2022080110110, 1, NULL, NULL, 10, 'Black', 10, 1, 1, 2);
INSERT INTO product(id, name, description, created_datetime, created_by, updated_datetime, updated_by,
                    price, color, quantity, status, category_id, branch_id)
values(6, 'Scrambler', 'scarmbler', 2022080110110, 1, NULL, NULL, 10, 'Red', 12, 1, 2, 3);
INSERT INTO product(id, name, description, created_datetime, created_by, updated_datetime, updated_by,
                    price, color, quantity, status, category_id, branch_id)
values(7, 'Monster', 'monster', 2022080110110, 1, NULL, NULL, 15, 'Red', 12, 1, 2, 3);
INSERT INTO product(id, name, description, created_datetime, created_by, updated_datetime, updated_by,
                    price, color, quantity, status, category_id, branch_id)
values(8, 'Hypermotard', 'hypermotard', 2022080110110, 1, NULL, NULL, 25, 'Red', 12, 1, 2, 3);


-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
                            `id` bigint(0) NOT NULL AUTO_INCREMENT,
                            `product_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                            `created_datetime` bigint(0) NULL DEFAULT NULL,
                            `created_by` bigint(0) NULL DEFAULT NULL,
                            `updated_datetime` bigint(0) NULL DEFAULT NULL,
                            `updated_by` bigint(0) NULL DEFAULT NULL,
                            `total_price` decimal(19, 2) NULL DEFAULT NULL,
                            `product_quantity` int(0) NOT NULL DEFAULT 0,
                            `status` bit(1) NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
