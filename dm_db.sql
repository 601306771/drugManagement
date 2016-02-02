/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.19 : Database - dm_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dm_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `dm_db`;

/*Table structure for table `detaildrugtype` */

DROP TABLE IF EXISTS `detaildrugtype`;

CREATE TABLE `detaildrugtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DCODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DDISCRIBE` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TCODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='药品细分类';

/*Data for the table `detaildrugtype` */

insert  into `detaildrugtype`(`id`,`DCODE`,`DNAME`,`DDISCRIBE`,`TCODE`) values (1,'AAA','AAA','AAA','333'),(2,'BBB','BBB','BBB','111'),(3,'CCC','CCC','CCC','111'),(4,'DDD','DDD','DDD','222'),(5,'EEE','EEE','EEE','222'),(6,'FFF','FFF','FFF','333'),(8,'GGG','GGG','GGG','222'),(9,'HHH','HHH','HHH','111'),(10,'LLL','LLL','LLL','222'),(11,'JJJ','JJJ','JJJ','333'),(12,'KKK','KKK','KKK','222'),(16,'SDF','SDF','SDF','99999999999'),(17,'uuu','uuuuuuu','uuuuuuu','SEL');

/*Table structure for table `druginformation` */

DROP TABLE IF EXISTS `druginformation`;

CREATE TABLE `druginformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TCODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DCODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DUSAGE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DEXPIRATIONDATE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DINDICATIONS` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DSUITABLE` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DDISCRIBE` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='药品信息';

/*Data for the table `druginformation` */

insert  into `druginformation`(`id`,`DNAME`,`TCODE`,`DCODE`,`DUSAGE`,`DEXPIRATIONDATE`,`DINDICATIONS`,`DSUITABLE`,`DDISCRIBE`) values (1,'AAA','99999999999','SDF','AAA','AAA','AAA','AAA','AAA'),(2,'BBB','111','BBB','BBB','BBB','BBB','BBB','BBB'),(3,'CCC','222','CCC','CCC','CCC','CCC','CCC','CCC'),(4,'DDD','222','DDD','DDD','DDD','DDD','DDD','DDD'),(6,'EEE','333','JJJ','EEE','EEE','EEE','EEE','EEE'),(8,'DELTTTTTT','ghh','hh','DELTTTTTT','DELTTTTTT','DELTTTTTT','DELTTTTTT','DELTTTTTT');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SCODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SPHONE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SADDRESS` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SDISCRIBE` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='供应商表';

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`SCODE`,`SNAME`,`SPHONE`,`SADDRESS`,`SDISCRIBE`) values (1,'gg','gy1','13633552988','ppppp','okkokoko'),(2,'AA','AAA','AAA','AAAAAA','AAAAA'),(3,'BB','BBB','BBB','BBBBBB','BBBBBB'),(4,'CC','CCCC','CCCC','CCCC','C'),(5,'ttt','ttt','ttt','tttttttt','tttttt');

/*Table structure for table `totaldrugtype` */

DROP TABLE IF EXISTS `totaldrugtype`;

CREATE TABLE `totaldrugtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TCODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TDISCRIBE` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='药品总分类';

/*Data for the table `totaldrugtype` */

insert  into `totaldrugtype`(`id`,`TCODE`,`TNAME`,`TDISCRIBE`) values (7,'AAA','AAA','AAA'),(8,'BBB','BBB','BBB'),(9,'CCC','CCC','CCC'),(10,'DDD','DDD','DDD'),(11,'EEE','EEE','EEE'),(13,'FFF','FFF','FFF'),(14,'GGG','GGG','GGG'),(17,'SEL','SELECTOOO','SSSSSS'),(18,'99999999999','99999999999','99999999999999');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `UNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UPASSWORD` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UTYPE` int(11) DEFAULT NULL,
  `UNICKNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DISCRIBE` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户列表';

/*Data for the table `users` */

insert  into `users`(`id`,`UNAME`,`UPASSWORD`,`UTYPE`,`UNICKNAME`,`DISCRIBE`) values (1,'admin','admin',1,'管理员阿花','这是系统的管理员啊'),(3,'name3','123456',3,'nicktest','discribeyyxx'),(4,'AAA','AAA',2,'AAA','AAA'),(5,'BBB','BBBeee',2,'BBB','BBB'),(6,'CCC','CCC',2,'CCCee','CCCee'),(7,'DDD','DDD11',2,'DDDedit','DDDedit'),(11,'EEE','EEE',2,'EEE','EEEy'),(12,'222','222',3,'222','222');

/* Procedure structure for procedure `split_time` */

/*!50003 DROP PROCEDURE IF EXISTS  `split_time` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `split_time`(in pi_begin_time datetime,in pi_end_time datetime)
begin
DECLARE l_start_dt datetime;
DECLARE l_end_dt datetime;
DECLARE l_date datetime;
DECLARE l_str varchar(30);
 
set l_start_dt = pi_begin_time;
loop_label: LOOP
 
set l_str = concat(date_format(l_start_dt,'%Y-%m-%d %H'),':','59');
set l_end_dt = str_to_date(l_str,'%Y-%m-%d %H:%i');
if l_end_dt>=pi_end_time then
select l_start_dt,pi_end_time;
leave loop_label;
end if;
select l_start_dt,l_end_dt;
set l_start_dt = DATE_ADD(l_end_dt,INTERVAL 1 MINUTE);
END LOOP;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
