-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.5-m8


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema campus
--

CREATE DATABASE IF NOT EXISTS campus;
USE campus;

--
-- Definition of table `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `log_date` varchar(50) NOT NULL,
  `log_level` varchar(8) NOT NULL,
  `location` varchar(100) NOT NULL,
  `message` varchar(500) NOT NULL,
  PRIMARY KEY (`log_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `log`
--

/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键：自增',
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL COMMENT 'user：普通用户、admin：管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`username`,`password`,`role`) VALUES 
 (1,'admin','123456','admin'),
 (2,'user1','user1','user'),
 (3,'user2','user2','user'),
 (4,'zzb','zzb123','user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_certificate`
--

DROP TABLE IF EXISTS `user_certificate`;
CREATE TABLE `user_certificate` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `cetificate` varchar(45) NOT NULL COMMENT '证书',
  `level` varchar(45) NOT NULL COMMENT '级别：高级、中级、初级',
  `state` smallint(5) unsigned NOT NULL COMMENT '状态：0-通过、1-末通过、2-报名、3-重考',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_certificate`
--

/*!40000 ALTER TABLE `user_certificate` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_certificate` ENABLE KEYS */;


--
-- Definition of table `user_courese`
--

DROP TABLE IF EXISTS `user_courese`;
CREATE TABLE `user_courese` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL COMMENT '课程归属用户',
  `course` varchar(45) NOT NULL COMMENT '课程',
  `credit` smallint(5) unsigned NOT NULL COMMENT '学分',
  `state` smallint(5) unsigned NOT NULL COMMENT '状态：0-在读、1-重修、2-合格、3-不合格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_courese`
--

/*!40000 ALTER TABLE `user_courese` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_courese` ENABLE KEYS */;


--
-- Definition of table `user_order`
--

DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL COMMENT '订阅的用户',
  `order_business` varchar(45) NOT NULL COMMENT '订阅的业务',
  `order time` datetime NOT NULL COMMENT '订阅时间表',
  `order state` smallint(5) unsigned NOT NULL COMMENT '订阅状态：0-退订、1-生效',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_order`
--

/*!40000 ALTER TABLE `user_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_order` ENABLE KEYS */;


--
-- Definition of table `user_relation`
--

DROP TABLE IF EXISTS `user_relation`;
CREATE TABLE `user_relation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `my_id` int(10) unsigned NOT NULL COMMENT '本人ID',
  `other_id` int(10) unsigned NOT NULL COMMENT '对方ID',
  `relateion` varchar(45) NOT NULL COMMENT '关系：朋友、同学、同乡、队友、师生',
  `state` smallint(5) unsigned NOT NULL COMMENT '关系状态：0-关系已建立、1-关系已解除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_relation`
--

/*!40000 ALTER TABLE `user_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_relation` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
