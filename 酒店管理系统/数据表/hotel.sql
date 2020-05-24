# Host: localhost  (Version 5.5.62)
# Date: 2019-12-04 15:55:24
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "checkout_customer"
#

CREATE TABLE `checkout_customer` (
  `name` varchar(25) NOT NULL DEFAULT '',
  `phone` varchar(25) DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  `id_card` varchar(25) NOT NULL DEFAULT '',
  `in_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `in_day` int(2) NOT NULL DEFAULT '1',
  `room_num` varchar(25) DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`name`,`id_card`,`in_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "checkout_customer"
#

INSERT INTO `checkout_customer` VALUES ('133','213','男','13','2019-11-22 19:17:53',3,'302 ','2019-11-22 19:18:09',888),('4567','3456','男','3456','2019-11-23 18:01:21',1,'405','2019-11-23 18:02:18',320),('dfdfd','23123','男','23123','2019-11-23 17:11:39',4,'501 ','2019-11-23 17:12:39',1680),('ds','11','女','111','2019-12-04 15:02:41',1,'301','2019-12-04 15:44:07',220),('sendRedirect','132221212','女','122221','2019-11-22 10:29:24',10,'301 ','2019-11-23 16:18:40',3),('去微软','12345','女','1234','2019-11-23 16:07:09',3,'302 ','2019-11-23 16:18:05',3),('弟赖弟','1121','男','231231','2019-11-21 21:16:17',6,'206 ','2019-11-23 17:58:08',1200),('而我却','11','女','11','2019-12-04 15:01:49',1,'302','2019-12-04 15:02:36',220);

#
# Structure for table "customer"
#

CREATE TABLE `customer` (
  `name` varchar(25) NOT NULL DEFAULT '',
  `phone` varchar(25) DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  `id_card` varchar(25) NOT NULL DEFAULT '',
  `in_time` datetime DEFAULT NULL,
  `in_day` int(2) NOT NULL DEFAULT '1',
  `room_num` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`name`,`id_card`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "customer"
#

INSERT INTO `customer` VALUES ('2345','435','男','345','2019-11-23 18:01:38',3,'304'),('678','45678','男','5678','2019-11-23 18:53:27',1,'206 ');

#
# Structure for table "room"
#

CREATE TABLE `room` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `is_empty` varchar(5) NOT NULL DEFAULT '1',
  `room_num` varchar(50) DEFAULT NULL,
  `price` double(20,2) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

#
# Data for table "room"
#

INSERT INTO `room` VALUES (1,'单人间','1','201',200.00,'/hotel/img/dan.jpg'),(2,'单人间','1','202',200.00,'/hotel/img/dan.jpg'),(3,'单人间','1','203',200.00,'/hotel/img/dan.jpg'),(4,'单人间','1','204',200.00,'/hotel/img/dan.jpg'),(5,'单人间','1','205',200.00,'/hotel/img/dan.jpg'),(6,'单人间','0','206',200.00,'/hotel/img/dan.jpg'),(7,'双人间','1','301',220.00,'/hotel/img/shuang.jpg'),(8,'双人间','1','302',220.00,'/hotel/img/shuang.jpg'),(9,'双人间','1','303',220.00,'/hotel/img/shuang.jpg'),(10,'双人间','0','304',220.00,'/hotel/img/shuang.jpg'),(11,'双人间','1','305',220.00,'/hotel/img/shuang.jpg'),(12,'双人间','1','306',220.00,'/hotel/img/shuang.jpg'),(13,'商务间','1','401',320.00,'\t/hotel/img/shangwu.jpg'),(14,'商务间','1','402',320.00,'\t/hotel/img/shangwu.jpg'),(15,'商务间','1','403',320.00,'\t/hotel/img/shangwu.jpg'),(16,'商务间','1','404',320.00,'\t/hotel/img/shangwu.jpg'),(17,'商务间','1','405',320.00,'\t/hotel/img/shangwu.jpg'),(18,'商务间','1','406',320.00,'\t/hotel/img/shangwu.jpg'),(19,'高级间','1','501',420.00,'/hotel/img/gaoji.jpg'),(20,'高级间','1','502',420.00,'/hotel/img/gaoji.jpg'),(21,'高级间','1','503',420.00,'/hotel/img/gaoji.jpg'),(22,'高级间','1','504',420.00,'/hotel/img/gaoji.jpg'),(23,'高级间','1','505',420.00,'/hotel/img/gaoji.jpg'),(24,'高级间','1','506',420.00,'/hotel/img/gaoji.jpg');

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `phone` varchar(111) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'赖幸儿','141414','123','女','10086');
