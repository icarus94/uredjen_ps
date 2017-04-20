/*
SQLyog Ultimate v9.50 
MySQL - 5.6.20 : Database - prosoftg1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftg1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prosoftg1`;

/*Table structure for table `angazovanje` */

DROP TABLE IF EXISTS `angazovanje`;

CREATE TABLE `angazovanje` (
  `AngazovanjeID` int(11) NOT NULL,
  `BrojSati` int(11) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `GradilisteID` int(11) DEFAULT NULL,
  `RadnikID` int(11) DEFAULT NULL,
  PRIMARY KEY (`AngazovanjeID`),
  KEY `GradilisteID` (`GradilisteID`),
  KEY `RadnikID` (`RadnikID`),
  CONSTRAINT `angazovanje_ibfk_1` FOREIGN KEY (`GradilisteID`) REFERENCES `gradiliste` (`GradilisteID`),
  CONSTRAINT `angazovanje_ibfk_2` FOREIGN KEY (`RadnikID`) REFERENCES `radnik` (`RadnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `angazovanje` */

/*Table structure for table `gradiliste` */

DROP TABLE IF EXISTS `gradiliste`;

CREATE TABLE `gradiliste` (
  `GradilisteID` int(11) NOT NULL,
  `Naziv` varchar(50) DEFAULT NULL,
  `Mesto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`GradilisteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gradiliste` */

insert  into `gradiliste`(`GradilisteID`,`Naziv`,`Mesto`) values (1,'Naselje Stepa Stepanovic','Vozdovac'),(2,'Naselje Stadion','Vozdovac'),(3,'Univerzitetsko naselje','Novi Beograd'),(4,'Centar','Stari Grad');

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
