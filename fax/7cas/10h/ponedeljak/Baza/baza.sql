/*
SQLyog Community v12.08 (32 bit)
MySQL - 5.6.12-log : Database - partneri
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`partneri` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `partneri`;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `ptt` int(11) NOT NULL,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mesto` */

insert  into `mesto`(`ptt`,`naziv`) values (11000,'Beograd'),(21000,'Novi Sad'),(85330,'Kotor');

/*Table structure for table `poslovnipartner` */

DROP TABLE IF EXISTS `poslovnipartner`;

CREATE TABLE `poslovnipartner` (
  `pib` varchar(9) NOT NULL,
  `maticniBroj` varchar(8) DEFAULT NULL,
  `naziv` varchar(100) DEFAULT NULL,
  `ulica` varchar(100) DEFAULT NULL,
  `broj` varchar(10) DEFAULT NULL,
  `ptt` int(11) DEFAULT NULL,
  PRIMARY KEY (`pib`),
  KEY `ptt` (`ptt`),
  CONSTRAINT `poslovnipartner_ibfk_1` FOREIGN KEY (`ptt`) REFERENCES `mesto` (`ptt`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `poslovnipartner` */

insert  into `poslovnipartner`(`pib`,`maticniBroj`,`naziv`,`ulica`,`broj`,`ptt`) values ('123','223','BIP','Oblakovska','bb',11000),('123456789','12345678','Soko Stark','Kumodraska','bb',11000),('55555','55555','Neki naziv','123','123',85330),('666','999','Delta','Jurija Gagarija','123',11000),('eee','eee','eee','eee','eee',11000),('fff','fff','fff','fff','fff',21000),('ggg','ggg','ggg','ggg','ggg',85330),('qqq','qqq','qqq','qqq','qqq',85330),('rrr','qqq','qqq','qqq','qqq',85330),('www','www','www','www','www',11000),('yyy','yyy','yyy','yyy','yyy',85330);

/*Table structure for table `proizvod` */

DROP TABLE IF EXISTS `proizvod`;

CREATE TABLE `proizvod` (
  `idProizvod` int(11) NOT NULL,
  `naziv` varchar(50) DEFAULT NULL,
  `cena` double DEFAULT NULL,
  PRIMARY KEY (`idProizvod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `proizvod` */

insert  into `proizvod`(`idProizvod`,`naziv`,`cena`) values (1,'Cokoladna bananica',13),(2,'Ruski kvas',58),(3,'Bonzita',25);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `idracun` int(11) NOT NULL,
  `datum` datetime DEFAULT NULL,
  `pib` varchar(9) DEFAULT NULL,
  `ukupanIznos` double DEFAULT NULL,
  PRIMARY KEY (`idracun`),
  KEY `pib` (`pib`),
  CONSTRAINT `racun_ibfk_1` FOREIGN KEY (`pib`) REFERENCES `poslovnipartner` (`pib`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `racun` */

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `idRacun` int(11) NOT NULL,
  `rb` int(11) NOT NULL,
  `kolicina` int(11) DEFAULT NULL,
  `idProizvod` int(11) DEFAULT NULL,
  `iznos` double DEFAULT NULL,
  PRIMARY KEY (`idRacun`,`rb`),
  KEY `idProizvod` (`idProizvod`),
  CONSTRAINT `stavkaracuna_ibfk_1` FOREIGN KEY (`idRacun`) REFERENCES `racun` (`idracun`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stavkaracuna_ibfk_2` FOREIGN KEY (`idProizvod`) REFERENCES `proizvod` (`idProizvod`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stavkaracuna` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
