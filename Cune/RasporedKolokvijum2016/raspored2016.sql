-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2017 at 06:02 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `raspored2016`
--

-- --------------------------------------------------------

--
-- Table structure for table `lokacija`
--

CREATE TABLE `lokacija` (
  `lokacijaID` int(11) NOT NULL,
  `naziv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `pocetakGradnje` date NOT NULL,
  `zavrsetakGradnje` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lokacija`
--

INSERT INTO `lokacija` (`lokacijaID`, `naziv`, `pocetakGradnje`, `zavrsetakGradnje`) VALUES
(1, 'Beograd - Makis', '2016-12-07', '2017-10-18'),
(2, 'Beograd - Novi Beograd', '2017-02-06', '2017-07-14'),
(3, 'Zemun most', '2017-02-15', '2017-07-07');

-- --------------------------------------------------------

--
-- Table structure for table `radnik`
--

CREATE TABLE `radnik` (
  `radnikID` int(11) NOT NULL,
  `ime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `specijalizacija` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `radnik`
--

INSERT INTO `radnik` (`radnikID`, `ime`, `prezime`, `specijalizacija`) VALUES
(1, 'Mile', 'Kitic', 'Parking majstor'),
(2, 'Mitar', 'Miric', 'Mesalica'),
(3, 'Srga', 'Moric', 'Gospodar vremena'),
(4, 'Duca', 'Dukic', 'Tapetar');

-- --------------------------------------------------------

--
-- Table structure for table `raspored`
--

CREATE TABLE `raspored` (
  `rasporedID` int(11) NOT NULL,
  `datum` date NOT NULL,
  `brojSati` int(11) NOT NULL,
  `lokacijaID` int(11) NOT NULL,
  `radnikID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `raspored`
--

INSERT INTO `raspored` (`rasporedID`, `datum`, `brojSati`, `lokacijaID`, `radnikID`) VALUES
(1, '2017-07-12', 3, 1, 4),
(2, '2017-07-12', 3, 2, 4),
(3, '2017-07-12', 7, 1, 2),
(4, '2017-07-05', 8, 3, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lokacija`
--
ALTER TABLE `lokacija`
  ADD PRIMARY KEY (`lokacijaID`);

--
-- Indexes for table `radnik`
--
ALTER TABLE `radnik`
  ADD PRIMARY KEY (`radnikID`);

--
-- Indexes for table `raspored`
--
ALTER TABLE `raspored`
  ADD PRIMARY KEY (`rasporedID`),
  ADD KEY `lokacijaID` (`lokacijaID`),
  ADD KEY `radnikID` (`radnikID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lokacija`
--
ALTER TABLE `lokacija`
  MODIFY `lokacijaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `radnik`
--
ALTER TABLE `radnik`
  MODIFY `radnikID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `raspored`
--
ALTER TABLE `raspored`
  MODIFY `rasporedID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `raspored`
--
ALTER TABLE `raspored`
  ADD CONSTRAINT `raspored_ibfk_1` FOREIGN KEY (`lokacijaID`) REFERENCES `lokacija` (`lokacijaID`),
  ADD CONSTRAINT `raspored_ibfk_2` FOREIGN KEY (`radnikID`) REFERENCES `radnik` (`radnikID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
