-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 05, 2016 at 07:19 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `kolokvijum2015g1`
--
CREATE DATABASE IF NOT EXISTS `kolokvijum2015g1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `kolokvijum2015g1`;

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE IF NOT EXISTS `predmet` (
  `sifraPredmeta` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  PRIMARY KEY (`sifraPredmeta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`sifraPredmeta`, `naziv`) VALUES
(1, 'PS'),
(2, 'PJ'),
(3, 'UIS'),
(4, 'OI'),
(5, 'PIS'),
(6, 'POIS');

-- --------------------------------------------------------

--
-- Table structure for table `prijava`
--

CREATE TABLE IF NOT EXISTS `prijava` (
  `brojIndeksa` varchar(255) NOT NULL,
  `sifraPredmeta` int(11) NOT NULL,
  `datum` date NOT NULL,
  `ocena` int(11) NOT NULL,
  PRIMARY KEY (`brojIndeksa`,`sifraPredmeta`),
  KEY `brojIndeksa` (`brojIndeksa`),
  KEY `sifraPredmeta` (`sifraPredmeta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prijava`
--

INSERT INTO `prijava` (`brojIndeksa`, `sifraPredmeta`, `datum`, `ocena`) VALUES
('100/12', 1, '2016-03-01', 10),
('100/12', 4, '2016-03-17', 10),
('101/12', 5, '1213-12-12', 8),
('101/12', 6, '1214-12-12', 10),
('200/12', 1, '1212-12-12', 10),
('200/12', 2, '2016-04-11', 10),
('200/12', 3, '1212-12-12', 9),
('200/12', 4, '2016-04-12', 9),
('200/12', 5, '2016-04-01', 10),
('59/10/I', 2, '2016-04-01', 9),
('59/10/I', 3, '2016-04-11', 8),
('59/10/I', 6, '2016-04-19', 7);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `brojIndeksa` varchar(255) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  PRIMARY KEY (`brojIndeksa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`brojIndeksa`, `ime`, `prezime`) VALUES
('100/12', 'Mika', 'Mikic'),
('101/12', 'Pera', 'Peric'),
('200/12', 'Gile', 'Gilic'),
('59/10/I', 'Cule', 'Culic');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `prijava`
--
ALTER TABLE `prijava`
  ADD CONSTRAINT `sss` FOREIGN KEY (`sifraPredmeta`) REFERENCES `predmet` (`sifraPredmeta`),
  ADD CONSTRAINT `ggg` FOREIGN KEY (`brojIndeksa`) REFERENCES `student` (`brojIndeksa`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
