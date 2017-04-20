/*
SQLyog Ultimate v9.50 
MySQL - 5.6.20 : Database - prosoftg3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftg3` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prosoftg3`;

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `RadnikID` int(11) NOT NULL,
  `Ime` varchar(50) DEFAULT NULL,
  `Prezime` varchar(50) DEFAULT NULL,
  `Specijalizacija` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`RadnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `radnik` */

insert  into `radnik`(`RadnikID`,`Ime`,`Prezime`,`Specijalizacija`) values (1,'Ivana','Ivanovic','arhitekta'),(2,'Marko','Markovic','gradjevinski inzenjer'),(3,'Marija','Markovic','administrativni radnik'),(4,'Jovan','Jovanovic','keramicar'),(5,'Ivan','Ivkovic','zidar'),(6,'Dragan','Mitrovic','stolar'),(7,'Pavle','Pavlovic','moler');

/*Table structure for table `ucinak` */

DROP TABLE IF EXISTS `ucinak`;

CREATE TABLE `ucinak` (
  `UcinakID` int(11) NOT NULL,
  `BrojSati` int(11) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `VrstaPoslaID` int(11) DEFAULT NULL,
  `RadnikID` int(11) DEFAULT NULL,
  PRIMARY KEY (`UcinakID`),
  KEY `VrstaPoslaID` (`VrstaPoslaID`),
  KEY `RadnikID` (`RadnikID`),
  CONSTRAINT `ucinak_ibfk_1` FOREIGN KEY (`VrstaPoslaID`) REFERENCES `vrstaposla` (`VrstaPoslaID`),
  CONSTRAINT `ucinak_ibfk_2` FOREIGN KEY (`RadnikID`) REFERENCES `radnik` (`RadnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ucinak` */

/*Table structure for table `vrstaposla` */

DROP TABLE IF EXISTS `vrstaposla`;

CREATE TABLE `vrstaposla` (
  `VrstaPoslaID` int(11) NOT NULL,
  `Naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`VrstaPoslaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vrstaposla` */

insert  into `vrstaposla`(`VrstaPoslaID`,`Naziv`) values (1,'Projektovanje'),(2,'Administracija'),(3,'Keramika'),(4,'Stolarija'),(5,'Zidanje'),(6,'Moleraj');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
