/*
SQLyog Community v12.08 (32 bit)
MySQL - 5.6.12-log : Database - poslovnipartneri
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`poslovnipartneri` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `poslovnipartneri`;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `ptt` int(11) NOT NULL,
  `naziv` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mesto` */

insert  into `mesto`(`ptt`,`naziv`) values (11000,'Beograd'),(18000,'Nis'),(34000,'Kragujevac');

/*Table structure for table `poslovnipartner` */

DROP TABLE IF EXISTS `poslovnipartner`;

CREATE TABLE `poslovnipartner` (
  `partnerID` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `maticniBroj` varchar(8) DEFAULT NULL,
  `pib` varchar(9) DEFAULT NULL,
  `ulica` varchar(255) DEFAULT NULL,
  `broj` varchar(50) DEFAULT NULL,
  `ptt` int(11) DEFAULT NULL,
  PRIMARY KEY (`partnerID`),
  KEY `ptt` (`ptt`),
  CONSTRAINT `poslovnipartner_ibfk_1` FOREIGN KEY (`ptt`) REFERENCES `mesto` (`ptt`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `poslovnipartner` */

insert  into `poslovnipartner`(`partnerID`,`naziv`,`maticniBroj`,`pib`,`ulica`,`broj`,`ptt`) values (1,'Soko Stark','1','1','Kumodraska','bb',11000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
