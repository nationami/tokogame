-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 25, 2013 at 03:42 
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tokogame`
--

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `pk_item` int(11) NOT NULL AUTO_INCREMENT,
  `fk_koleksi` int(11) NOT NULL,
  `fk_kategori` int(11) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `jenis_item` varchar(50) NOT NULL,
  `file_size` varchar(50) DEFAULT NULL,
  `harga` int(12) NOT NULL,
  `updated_date` datetime NOT NULL,
  `rating` int(12) NOT NULL,
  PRIMARY KEY (`pk_item`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`pk_item`, `fk_koleksi`, `fk_kategori`, `item_name`, `jenis_item`, `file_size`, `harga`, `updated_date`, `rating`) VALUES
(1, 1, 1, 'God Of War', 'DATA', NULL, 50000, '2013-04-18 23:32:47', 10),
(2, 2, 2, 'Suikoden 2', 'DATA', NULL, 20000, '2013-04-18 23:32:47', 4),
(3, 1, 1, 'Alice in Wonderland', 'DATA', NULL, 25000, '2013-04-19 00:29:57', 1),
(4, 1, 2, 'Grandia', 'DATA', NULL, 25000, '2013-04-19 00:31:10', 5),
(5, 2, 1, 'Devil May Cry 5', 'DATA', NULL, 35000, '2013-04-19 00:31:10', 7),
(6, 1, 5, 'Age of Empire', 'DATA', NULL, 30000, '2013-04-19 08:03:58', 2),
(7, 2, 5, 'Disgaea', 'DATA', NULL, 10000, '2013-04-19 08:03:58', 0),
(8, 1, 1, 'Assasin Creed', 'DATA', NULL, 20000, '2013-04-19 08:10:02', 3),
(9, 2, 5, 'Final Fantasy Tactics', 'DATA', NULL, 15000, '2013-04-19 08:10:02', 2),
(10, 1, 5, 'World of Warcraft', 'DATA', NULL, 45000, '2013-04-19 08:15:36', 20),
(11, 2, 2, 'Romance of the Three Kingdom', 'DATA', NULL, 30000, '2013-04-19 08:15:36', 5);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

DROP TABLE IF EXISTS `kategori`;
CREATE TABLE IF NOT EXISTS `kategori` (
  `pk_kategori` int(11) NOT NULL AUTO_INCREMENT,
  `kategori_name` varchar(50) NOT NULL,
  `kategori_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_kategori`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`pk_kategori`, `kategori_name`, `kategori_desc`) VALUES
(1, 'Adventure', NULL),
(2, 'RPG', NULL),
(5, 'Strategy', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `koleksi`
--

DROP TABLE IF EXISTS `koleksi`;
CREATE TABLE IF NOT EXISTS `koleksi` (
  `pk_koleksi` int(11) NOT NULL AUTO_INCREMENT,
  `koleksi_name` varchar(50) NOT NULL,
  `koleksi_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_koleksi`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `koleksi`
--

INSERT INTO `koleksi` (`pk_koleksi`, `koleksi_name`, `koleksi_desc`) VALUES
(1, 'PSP', 'This is the great console'),
(2, 'PS2', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `koleksi_relation`
--

DROP TABLE IF EXISTS `koleksi_relation`;
CREATE TABLE IF NOT EXISTS `koleksi_relation` (
  `pk_koleksi_relation` int(11) NOT NULL AUTO_INCREMENT,
  `fk_koleksi` int(11) NOT NULL,
  `fk_kategori` int(11) NOT NULL,
  PRIMARY KEY (`pk_koleksi_relation`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `koleksi_relation`
--

INSERT INTO `koleksi_relation` (`pk_koleksi_relation`, `fk_koleksi`, `fk_kategori`) VALUES
(1, 1, 2),
(2, 2, 1),
(3, 1, 1),
(4, 2, 2),
(5, 1, 5),
(6, 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_login` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(25) NOT NULL,
  `active` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_login`, `password`, `role`, `active`) VALUES
(1, 'admin', '25d55ad283aa400af464c76d713c07ad', 'ADMIN', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
