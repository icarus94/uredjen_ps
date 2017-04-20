-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2017 at 05:37 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pskol2013`
--

-- --------------------------------------------------------

--
-- Table structure for table `tasistent`
--

CREATE TABLE `tasistent` (
  `sifra` int(11) NOT NULL,
  `ime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `titula` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `predmetID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tasistent`
--

INSERT INTO `tasistent` (`sifra`, `ime`, `prezime`, `titula`, `predmetID`) VALUES
(1, 'Andjela', 'Ic', 'mladji konsultant', 4),
(4, 'Djurdja', 'asfjs', 'asfdsfj', 1),
(12, 'Djole', 'Raska', 'Jos mladji', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tpredmet`
--

CREATE TABLE `tpredmet` (
  `sifra` int(11) NOT NULL,
  `nazivPredmeta` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `semestar` int(11) NOT NULL,
  `brojBodova` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tpredmet`
--

INSERT INTO `tpredmet` (`sifra`, `nazivPredmeta`, `semestar`, `brojBodova`) VALUES
(1, 'Projektovanje softvera', 8, 6),
(2, 'Upravljanje kvalitetom', 8, 6),
(3, 'MLJR', 5, 5),
(4, 'UIS', 2, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tasistent`
--
ALTER TABLE `tasistent`
  ADD PRIMARY KEY (`sifra`),
  ADD KEY `predmetID` (`predmetID`);

--
-- Indexes for table `tpredmet`
--
ALTER TABLE `tpredmet`
  ADD PRIMARY KEY (`sifra`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tpredmet`
--
ALTER TABLE `tpredmet`
  MODIFY `sifra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tasistent`
--
ALTER TABLE `tasistent`
  ADD CONSTRAINT `tasistent_ibfk_1` FOREIGN KEY (`predmetID`) REFERENCES `tpredmet` (`sifra`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
