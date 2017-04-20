-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2017 at 11:41 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kataialek`
--

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje`
--

CREATE TABLE `angazovanje` (
  `angazovanjeID` int(11) NOT NULL,
  `brojSati` int(11) NOT NULL,
  `datum` date NOT NULL,
  `radnikID` int(11) NOT NULL,
  `gradilisteID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `angazovanje`
--

INSERT INTO `angazovanje` (`angazovanjeID`, `brojSati`, `datum`, `radnikID`, `gradilisteID`) VALUES
(1, 2, '1212-12-12', 3, 3),
(2, 5, '1212-12-12', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `gradiliste`
--

CREATE TABLE `gradiliste` (
  `gradilisteID` int(11) NOT NULL,
  `naziv` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `mesto` varchar(1000) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `gradiliste`
--

INSERT INTO `gradiliste` (`gradilisteID`, `naziv`, `mesto`) VALUES
(1, 'Novo gradiliste', 'Novi Beograd'),
(2, 'Makis', 'Makis'),
(3, 'Djokovic plaza', 'SavaMala'),
(4, 'Hajat', 'Novi Beograd');

-- --------------------------------------------------------

--
-- Table structure for table `radnik`
--

CREATE TABLE `radnik` (
  `radnikID` int(11) NOT NULL,
  `ime` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `specijalizacija` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `radnik`
--

INSERT INTO `radnik` (`radnikID`, `ime`, `prezime`, `specijalizacija`) VALUES
(1, 'Mika', 'Mikic', 'Sef'),
(2, 'Zoka', 'Zokic', 'Mesalica'),
(3, 'Kika', 'Kikic', 'Crevo'),
(4, 'Vlada', 'Vladic', 'Malter'),
(5, 'Alek', 'Vucic', 'finansije');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD PRIMARY KEY (`angazovanjeID`),
  ADD KEY `radnikID` (`radnikID`),
  ADD KEY `gradilisteID` (`gradilisteID`);

--
-- Indexes for table `gradiliste`
--
ALTER TABLE `gradiliste`
  ADD PRIMARY KEY (`gradilisteID`);

--
-- Indexes for table `radnik`
--
ALTER TABLE `radnik`
  ADD PRIMARY KEY (`radnikID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `angazovanje`
--
ALTER TABLE `angazovanje`
  MODIFY `angazovanjeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `gradiliste`
--
ALTER TABLE `gradiliste`
  MODIFY `gradilisteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `radnik`
--
ALTER TABLE `radnik`
  MODIFY `radnikID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD CONSTRAINT `angazovanje_ibfk_1` FOREIGN KEY (`radnikID`) REFERENCES `radnik` (`radnikID`),
  ADD CONSTRAINT `angazovanje_ibfk_2` FOREIGN KEY (`gradilisteID`) REFERENCES `gradiliste` (`gradilisteID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
