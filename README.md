# mywiki
## Overview
  It's a project enable user browsing the ebooks online
## Preparation
  * Vue3 <br>
  * Mybatis-plus <br>
  * Spring-boot <br>
## Start
### Get the project
1.git clone
```
 git clone https://github.com/wholvecoding/mywiki.git
```
2. download the local
### Resolve the Dependencies in pom.xml
### Connect the Database
1. application.properties
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.url=jdbc:mysql://localhost:3306/wiki?useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai
```
2. mysql
```
/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : wiki

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 04/09/2024 20:28:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES (1, 'Fiction', 'Fictional books', '2024-08-31 10:48:16');
INSERT INTO `categories` VALUES (2, 'Non-Fiction', 'Non-fictional books', '2024-08-31 10:48:16');
INSERT INTO `categories` VALUES (3, 'Science', 'Books related to science', '2024-08-31 10:48:16');
INSERT INTO `categories` VALUES (4, 'History', 'Books related to history', '2024-08-31 10:48:16');

-- ----------------------------
-- Table structure for chapters
-- ----------------------------
DROP TABLE IF EXISTS `chapters`;
CREATE TABLE `chapters`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `ebook_id` int NULL DEFAULT NULL,
  `chapter_number` int NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ebook_id`(`ebook_id` ASC, `chapter_number` ASC) USING BTREE,
  CONSTRAINT `chapters_ibfk_1` FOREIGN KEY (`ebook_id`) REFERENCES `ebooks` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chapters
-- ----------------------------
INSERT INTO `chapters` VALUES (1, 1, 1, 'Chapter 1:this ist he sdas', 'This is the content of Chapter 1 of The Great Gatsby.', '2024-08-31 10:48:16', '2024-09-02 19:14:45');
INSERT INTO `chapters` VALUES (2, 1, 2, 'Chapter 2', 'This is the content of Chapter 2 of The Great Gatsby.', '2024-08-31 10:48:16', '2024-08-31 10:48:16');
INSERT INTO `chapters` VALUES (3, 2, 1, 'Chapter 1', 'This is the content of Chapter 1 of A Brief History of Time.', '2024-08-31 10:48:16', '2024-08-31 10:48:16');
INSERT INTO `chapters` VALUES (4, 3, 1, 'Chapter 1', 'This is the content of Chapter 1 of The Art of War.', '2024-08-31 10:48:16', '2024-08-31 10:48:16');

-- ----------------------------
-- Table structure for ebooks
-- ----------------------------
DROP TABLE IF EXISTS `ebooks`;
CREATE TABLE `ebooks`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `author` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `category_id` int NULL DEFAULT NULL,
  `published_date` date NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `book_cover` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `book_outline` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `author_outline` varchar(2550) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE,
  CONSTRAINT `ebooks_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ebooks
-- ----------------------------
INSERT INTO `ebooks` VALUES (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 1, '1925-04-10', '2024-08-31 10:48:16', 'gasbi.png', '在人类共同的精神世界，《了不起的盖茨比》，解剖了永恒的迷惘与孤独。艾略特将它视为美国小说的先驱，叶芝认为它是美国社会的注解，一座文学史上的里程碑。\r\n\r\n在人类共同的精神世界，《了不起的盖茨比》，解剖了永恒的迷惘与孤独。艾略特将它视为美国小说的先驱，叶芝认为它是美国社会的注解，一座文学史上的里程碑', '斯科特·菲茨杰拉德，是一位美国长篇小说、短篇小说作家，他的作品展示了爵士时代。虽然他一生只获得了少量的成功，但他现在被广泛看成是20世纪最伟大的美国作家之一。菲茨杰拉德被认为是1920年代“迷惘的一代”的人，他最著名的小说为《了不起的盖茨比》，此书堪称美国社会缩影的经典代表，描述1920年代美国人在歌舞升平中空虚、享乐、矛盾的精神与思想。费滋杰罗一生为两样东西所困：一是才华，一是金钱，他都曾一度拥有，最后又全部失去。他死的时候，评论家都批评他生活腐化、自暴自弃，所以短寿，浪费了自己的才华。但或许就是因为他如此腐化的生活才能够写出那样属于美国那个年代的作品。他一生总共完成了4本长篇小说：《尘世乐园》、《美丽与毁灭》、《了不起的盖茨比》和《夜色温柔》，第五本未完成的小说《最后的大亨》则在他去世后才出版。他也在杂志中创作过164篇短篇小说。');
INSERT INTO `ebooks` VALUES (2, 'A Brief History of Time', 'Stephen Hawking', 3, '1988-03-01', '2024-08-31 10:48:16', 'time.png', '史蒂芬·霍金生于1942年，他的生日恰好与伽利略去世的纪念日是同一天。他现任剑桥大学卢卡斯数学系教授教席(这一职位曾由艾萨克·牛顿担任)。他被誉为继爱因斯坦后*杰出的理论物理学家。他于1993年出版了《霍金讲演录——黑洞、婴儿宇宙及其他》。这本书是理论物理学方面的经典著作，其中的内容已被许多科学论文和书籍引用。\r\n\r\n史蒂芬·霍金的《时间简史》自1988年首版以来的岁月里，已成为全球科学著作的里程碑。它被翻译成40种文字，销售了近1000万册，成为国际出版史上的奇观。该书内容是关于宇宙本性的*前沿知识，但是从那以后无论在微观还是宏观宇宙世界的观测技术方面都有了非凡的进展。这些观测证实了霍金教授在该书*版中的许多理论预言，其中包括宇宙背景探险者卫星(COBE)的*近发现，它在时间上回溯探测到离宇宙创生的30万年之内，并显露了他所计算的在时空结构中的涟漪', '斯蒂芬·威廉·霍金，1942年1月8日—2018年3月14日[2]），英国理论物理学家、宇宙学家及科普作家，生前任职剑桥大学理论宇宙学中心研究主任[3][4]。他在科学上有许多贡献，包括与罗杰·彭罗斯共同合作提出在广义相对论框架内的彭罗斯-霍金奇点定理，以及他对关于黑洞会发放辐射的理论性预测（现称为霍金辐射）。霍金是第一个提出由广义相对论和量子力学联合解释的宇宙论理论之人。他是量子力学的多世界诠释的积极支持者');
INSERT INTO `ebooks` VALUES (3, 'The Art of War', 'Sun Tzu', 4, '0500-01-01', '2024-08-31 10:48:16', 'artwar.jpg', '《孙子兵法》是世界上最早的兵书之一[2]，被奉为中国兵家经典[3]，是中国最高的战争哲学，也是作战原理的经典[4]。后世的兵书大多受到它的影响，对中国的军事学发展影响非常深远。它也被翻译成多种语言，是在世界军事史上具有重要地位的著作', '孙武（前545年—前470年或前496年）妫姓，孙氏，名武，字长卿，春秋时期齐国人，陈胡公的直系后代，著名军事家、政治家，兵家代表人物。兵书《孙子兵法》的作者，后人尊称为孙子、兵圣、东方兵圣，山东、苏州等地尚有祀奉孙武的庙宇兵圣庙。其族人为乐安孙氏始祖，次子孙明为富春孙氏始祖。');

-- ----------------------------
-- Table structure for pages
-- ----------------------------
DROP TABLE IF EXISTS `pages`;
CREATE TABLE `pages`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `chapter_id` int NULL DEFAULT NULL,
  `ebook_id` int NULL DEFAULT NULL,
  `page_number` int NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `chapter_id`(`chapter_id` ASC) USING BTREE,
  INDEX `ebook_id`(`ebook_id` ASC) USING BTREE,
  CONSTRAINT `pages_ibfk_1` FOREIGN KEY (`chapter_id`) REFERENCES `chapters` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pages_ibfk_2` FOREIGN KEY (`ebook_id`) REFERENCES `ebooks` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pages
-- ----------------------------
INSERT INTO `pages` VALUES (1, 1, 1, 1, '这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页这是第一页', '2024-09-01 17:18:15', '2024-09-02 19:09:00');
INSERT INTO `pages` VALUES (2, 1, 1, 2, '这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页这是第二页', '2024-09-01 17:19:12', '2024-09-02 19:09:22');
INSERT INTO `pages` VALUES (3, 1, 1, 3, '这是第三页', '2024-09-01 17:19:24', '2024-09-02 12:04:25');
INSERT INTO `pages` VALUES (4, 2, 1, 4, '这是第四页', '2024-09-01 17:19:28', '2024-09-02 12:07:07');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'password_hash_here', 'admin@example.com', '2024-08-31 10:48:16');
INSERT INTO `users` VALUES (2, 'user1', 'password_hash_here', 'user1@example.com', '2024-08-31 10:48:16');

SET FOREIGN_KEY_CHECKS = 1;

```
### Start the backend
  
### Start the frontend
```
npm run serve
```
## Exhibition
### HomePage: Outline of the book
![Raw GitHub Image](https://github.com/user-attachments/assets/415443a3-525e-4fd7-88a9-6b2bc2f81e4b)
exp: here show some books, you can click the title or "展开全文" to get a full introduction of the book
### AsideTool :navigate to the corresponding Category
![Raw GitHub Image](https://github.com/user-attachments/assets/4faa2f11-4052-4eb5-9696-1287b84aeca4)
### Choose a specefic book
once you click the "展开全文",you get the page like 
![Raw GitHub Image](https://github.com/user-attachments/assets/0d51b1fe-e9b4-4e18-ba05-0f1fb4e3bdb3)
exp: It's give the full introduction of the book, include the title,the author,the outline of the book and the chapters.<br>
### Start Reading:choose the Chapter 
After you click the "阅读全文",the page is like 
![Raw GitHub Image](https://github.com/user-attachments/assets/f1b88ca1-50a7-47f5-8bfa-122831b3c29f)
you can click the chapter to futher reading the book
### Reading
![Raw GitHub Image](https://github.com/user-attachments/assets/635d19bc-99ce-44bb-9423-86fb13387392) <br>
you can click the botton at the bottom to choose next page or previous page.<br>
the top selection help you back to the **Chapter selection**





