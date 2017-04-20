-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2017 at 03:08 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `anax2`
--

-- --------------------------------------------------------

--
-- Table structure for table `tzadatak`
--

CREATE TABLE `tzadatak` (
  `sifraZadatka` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datum` date NOT NULL,
  `naziv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `opis` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `zaposleni` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tzadatak`
--

INSERT INTO `tzadatak` (`sifraZadatka`, `datum`, `naziv`, `opis`, `zaposleni`) VALUES
('SIF-1', '2017-04-02', 'Alekov veliki dan', 'izbori', '3'),
('SIF-2', '2017-04-03', 'Sta god', 'gpa', '4');

-- --------------------------------------------------------

--
-- Table structure for table `tzaposleni`
--

CREATE TABLE `tzaposleni` (
  `sifra` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tzaposleni`
--

INSERT INTO `tzaposleni` (`sifra`, `ime`, `prezime`) VALUES
('1', 'Mika', 'Mikic'),
('2', 'Tanja', 'Ljubav'),
('3', 'Mali', 'Alek'),
('4', 'Baka', 'Ajkula');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tzadatak`
--
ALTER TABLE `tzadatak`
  ADD PRIMARY KEY (`sifraZadatka`),
  ADD KEY `zaposleni` (`zaposleni`);

--
-- Indexes for table `tzaposleni`
--
ALTER TABLE `tzaposleni`
  ADD PRIMARY KEY (`sifra`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tzadatak`
--
ALTER TABLE `tzadatak`
  ADD CONSTRAINT `tzadatak_ibfk_1` FOREIGN KEY (`zaposleni`) REFERENCES `tzaposleni` (`sifra`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
