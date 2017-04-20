-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2017 at 12:38 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kol2015`
--

-- --------------------------------------------------------

--
-- Table structure for table `tpredmet`
--

CREATE TABLE `tpredmet` (
  `sifraPredmeta` int(11) NOT NULL,
  `naziv` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tpredmet`
--

INSERT INTO `tpredmet` (`sifraPredmeta`, `naziv`) VALUES
(1, 'Kvalitet'),
(2, 'Projektovanje softvera'),
(3, 'UIS'),
(4, 'MLJR');

-- --------------------------------------------------------

--
-- Table structure for table `tprijava`
--

CREATE TABLE `tprijava` (
  `sifraPredmeta` int(11) NOT NULL,
  `brojIndeksa` varchar(255) NOT NULL,
  `datum` date NOT NULL,
  `ocena` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tprijava`
--

INSERT INTO `tprijava` (`sifraPredmeta`, `brojIndeksa`, `datum`, `ocena`) VALUES
(1, '59/10/I', '1221-12-12', 10),
(2, '200/11/M', '1221-12-12', 10),
(3, '200/11/M', '2017-04-02', 8),
(4, '11/12/I', '1221-12-12', 7);

-- --------------------------------------------------------

--
-- Table structure for table `tstudent`
--

CREATE TABLE `tstudent` (
  `brojIndeksa` varchar(255) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tstudent`
--

INSERT INTO `tstudent` (`brojIndeksa`, `ime`, `prezime`) VALUES
('11/12/I', 'Mirko', 'Miric'),
('200/11/M', 'Filip', 'Filipovic'),
('59/10/I', 'Miroslav', 'Jovanovic - Cule');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tpredmet`
--
ALTER TABLE `tpredmet`
  ADD PRIMARY KEY (`sifraPredmeta`);

--
-- Indexes for table `tprijava`
--
ALTER TABLE `tprijava`
  ADD PRIMARY KEY (`sifraPredmeta`,`brojIndeksa`),
  ADD KEY `brojIndeksa` (`brojIndeksa`);

--
-- Indexes for table `tstudent`
--
ALTER TABLE `tstudent`
  ADD PRIMARY KEY (`brojIndeksa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tpredmet`
--
ALTER TABLE `tpredmet`
  MODIFY `sifraPredmeta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tprijava`
--
ALTER TABLE `tprijava`
  ADD CONSTRAINT `tprijava_ibfk_1` FOREIGN KEY (`sifraPredmeta`) REFERENCES `tpredmet` (`sifraPredmeta`),
  ADD CONSTRAINT `tprijava_ibfk_2` FOREIGN KEY (`brojIndeksa`) REFERENCES `tstudent` (`brojIndeksa`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
