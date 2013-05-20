-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 20, 2013 at 11:55 
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
-- Table structure for table `belanja`
--

CREATE TABLE IF NOT EXISTS `belanja` (
  `pk_belanja` int(11) NOT NULL AUTO_INCREMENT,
  `fk_user` int(11) NOT NULL,
  `kode_belanja` varchar(50) NOT NULL,
  `kode_autentikasi` varchar(50) DEFAULT NULL,
  `total_item` int(11) DEFAULT NULL,
  `total_harga` int(11) DEFAULT NULL,
  `updated_date` datetime NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`pk_belanja`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `belanja`
--

INSERT INTO `belanja` (`pk_belanja`, `fk_user`, `kode_belanja`, `kode_autentikasi`, `total_item`, `total_harga`, `updated_date`, `status`) VALUES
(1, 3, 'PS20134010002', '12345678', 2, 75000, '2013-05-01 02:26:09', 'BAYAR'),
(2, 2, 'MB20134010003', NULL, NULL, NULL, '2013-05-01 03:06:19', 'PENDING'),
(3, 2, 'MB20134010004', NULL, NULL, NULL, '2013-05-01 11:41:04', 'PENDING'),
(4, 2, 'MB20134010005', NULL, NULL, NULL, '2013-05-01 11:45:07', 'PENDING'),
(5, 2, 'MB20134010006', NULL, NULL, NULL, '2013-05-01 11:51:53', 'PENDING');

-- --------------------------------------------------------

--
-- Table structure for table `belanja_detail`
--

CREATE TABLE IF NOT EXISTS `belanja_detail` (
  `pk_belanja_detail` int(11) NOT NULL AUTO_INCREMENT,
  `fk_belanja` int(11) NOT NULL,
  `fk_item` int(11) NOT NULL,
  `belanja_qty` int(11) NOT NULL,
  `harga_belanja` int(11) NOT NULL,
  `is_retur` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pk_belanja_detail`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `belanja_detail`
--

INSERT INTO `belanja_detail` (`pk_belanja_detail`, `fk_belanja`, `fk_item`, `belanja_qty`, `harga_belanja`, `is_retur`) VALUES
(1, 1, 5, 1, 35000, 0),
(2, 1, 1, 1, 50000, 0),
(3, 2, 9, 0, 0, 0),
(4, 2, 3, 0, 0, 0),
(5, 3, 7, 0, 0, 0),
(6, 4, 7, 0, 0, 0),
(7, 4, 5, 0, 0, 0),
(8, 5, 7, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `pk_item` int(11) NOT NULL AUTO_INCREMENT,
  `fk_koleksi` int(11) NOT NULL,
  `fk_kategori` int(11) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `jenis_item` varchar(50) NOT NULL,
  `file_size` varchar(50) DEFAULT NULL,
  `harga` int(12) NOT NULL,
  `informasi_produk` varchar(255) DEFAULT NULL,
  `informasi_lain` varchar(255) DEFAULT NULL,
  `item_qty` int(25) NOT NULL DEFAULT '1',
  `path` varchar(500) DEFAULT NULL,
  `updated_date` datetime NOT NULL,
  `rating` int(12) NOT NULL,
  PRIMARY KEY (`pk_item`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`pk_item`, `fk_koleksi`, `fk_kategori`, `item_name`, `jenis_item`, `file_size`, `harga`, `informasi_produk`, `informasi_lain`, `item_qty`, `path`, `updated_date`, `rating`) VALUES
(1, 1, 1, 'God Of War', 'DATA', NULL, 50000, 'game keren bagus yang mempunyai kualitas gambar luar biasa dan tiada duanya. Gameplay action yang sangat seru, dimana melawan bos bos besar. Dan dapat juga menemui dewa dewa kuno yunani seperti zeus, hera, hades dan lain sebagainya', 'CPU:	 Intel Core 2 Duo 1.8GHz, AMD Athlon X2 64 2.4GHz  CPU Speed:	 1.8 GHz RAM:	 1 GB for Windows XP / 1.5 GB for Windows Vista)  OS:	 Windows Vista - Service Pack 1 / XP - Service Pack 3 / Windows 7  Video Card:	 256MB NVIDIA 7900+ / 256MB ATI X1900+  S', 42, 'https://www.dropbox.com/s/358066xdm4zgs77/BatchSeven.avi', '2013-04-18 23:32:47', 10),
(2, 2, 2, 'Suikoden 2', 'DATA', NULL, 20000, '', '', 31, NULL, '2013-04-18 23:32:47', 4),
(3, 1, 1, 'Alice in Wonderland', 'DATA', NULL, 25000, '', '', 22, NULL, '2013-04-19 00:29:57', 1),
(4, 1, 2, 'Grandia', 'DATA', NULL, 25000, '', '', 2, NULL, '2013-04-19 00:31:10', 5),
(5, 2, 1, 'Devil May Cry 5', 'DATA', NULL, 35000, '', '', 2, 'F:/Picture/joystik.jpg', '2013-04-19 00:31:10', 7),
(6, 1, 5, 'Age of Empire', 'DATA', NULL, 30000, '', '', 21, NULL, '2013-04-19 08:03:58', 2),
(7, 2, 5, 'Disgaea', 'DATA', NULL, 10000, '', '', 3, NULL, '2013-04-19 08:03:58', 0),
(8, 1, 1, 'Assasin Creed', 'DATA', NULL, 20000, '', '', 1, NULL, '2013-04-19 08:10:02', 3),
(9, 2, 5, 'Final Fantasy Tactics', 'DATA', NULL, 15000, '', '', 4, NULL, '2013-04-19 08:10:02', 2),
(10, 1, 5, 'World of Warcraft', 'DATA', NULL, 45000, '', '', 3, NULL, '2013-04-19 08:15:36', 20),
(11, 2, 2, 'Romance of the Three Kingdom', 'DATA', NULL, 30000, '', '', 12, NULL, '2013-04-19 08:15:36', 5);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

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
-- Table structure for table `konfigurasi`
--

CREATE TABLE IF NOT EXISTS `konfigurasi` (
  `pk_konfigurasi` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `header` varchar(25) NOT NULL,
  `banner_name` varchar(100) DEFAULT NULL,
  `banner_path` varchar(255) DEFAULT NULL,
  `kata_hiasan` varchar(255) NOT NULL,
  PRIMARY KEY (`pk_konfigurasi`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `konfigurasi`
--

INSERT INTO `konfigurasi` (`pk_konfigurasi`, `nama`, `alamat`, `telepon`, `header`, `banner_name`, `banner_path`, `kata_hiasan`) VALUES
(1, 'Nexia', 'Jl.Gardu Asam no.173c', '08988992852', 'Toko Game', 'plus.png', 'C:/runtime/uploads\\1368211380576.png', 'Terima Kasih');

-- --------------------------------------------------------

--
-- Table structure for table `opname`
--

CREATE TABLE IF NOT EXISTS `opname` (
  `pk_opname` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal_opname` datetime NOT NULL,
  `total_selisih` int(11) NOT NULL,
  `total_biaya` int(11) NOT NULL,
  `opname_path` varchar(255) NOT NULL,
  PRIMARY KEY (`pk_opname`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `opname`
--

INSERT INTO `opname` (`pk_opname`, `tanggal_opname`, `total_selisih`, `total_biaya`, `opname_path`) VALUES
(1, '2013-05-16 12:18:31', -2, -50000, ''),
(2, '2013-05-19 23:40:16', 0, 0, ''),
(3, '2013-05-19 23:42:48', 2, -580000, ''),
(4, '2013-05-19 23:56:03', 188, 0, ''),
(5, '2013-05-20 00:01:39', 2124, -150000, ''),
(6, '2013-05-20 00:11:11', 222, -75000, ''),
(7, '2013-05-20 00:13:29', -30, -775000, ''),
(8, '2013-05-20 00:18:05', 89, -75000, ''),
(9, '2013-05-20 00:29:44', 101, -75000, ''),
(10, '2013-05-20 00:32:59', 83, -250000, '');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE IF NOT EXISTS `pembelian` (
  `pk_pembelian` int(11) NOT NULL AUTO_INCREMENT,
  `nota` varchar(25) NOT NULL,
  `supplier` varchar(25) NOT NULL,
  `tanggal_beli` datetime NOT NULL,
  PRIMARY KEY (`pk_pembelian`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`pk_pembelian`, `nota`, `supplier`, `tanggal_beli`) VALUES
(1, 'tolong', 'asdad', '2013-05-24 16:31:04'),
(2, 'Mantap', 'mantap', '2013-05-17 19:01:09'),
(3, 'Yahuu', 'adssad', '2013-05-22 19:06:59'),
(4, 'dasda', 'sdfdsf', '2013-05-17 19:09:07'),
(5, 'asdad', 'adas', '2013-09-09 19:11:37'),
(6, 'coba lagi', 'asdad', '2013-08-15 00:38:08');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian_detail`
--

CREATE TABLE IF NOT EXISTS `pembelian_detail` (
  `pk_pembelian_detail` int(11) NOT NULL AUTO_INCREMENT,
  `fk_pembelian` int(11) NOT NULL,
  `fk_item` int(11) NOT NULL,
  `harga_pembelian` int(11) NOT NULL,
  `pembelian_qty` int(11) NOT NULL,
  `keterangan` varchar(255) NOT NULL,
  PRIMARY KEY (`pk_pembelian_detail`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `pembelian_detail`
--

INSERT INTO `pembelian_detail` (`pk_pembelian_detail`, `fk_pembelian`, `fk_item`, `harga_pembelian`, `pembelian_qty`, `keterangan`) VALUES
(12, 5, 6, 133324, 2, 'asdada'),
(11, 5, 4, 23424, 3, 'asdads'),
(14, 6, 2, 2342342, 1, 'sadsada'),
(13, 6, 4, 34343, 2, 'asdsad');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE IF NOT EXISTS `penjualan` (
  `pk_penjualan` int(11) NOT NULL AUTO_INCREMENT,
  `fk_belanja` int(11) NOT NULL,
  `jual_qty` int(11) NOT NULL,
  `total_beli` int(11) NOT NULL,
  `total_retur` int(11) NOT NULL,
  `total_belanja` int(11) NOT NULL,
  `total_bayar` int(11) NOT NULL,
  `total_kembali` int(11) NOT NULL,
  `tanggal_jual` datetime NOT NULL,
  PRIMARY KEY (`pk_penjualan`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`pk_penjualan`, `fk_belanja`, `jual_qty`, `total_beli`, `total_retur`, `total_belanja`, `total_bayar`, `total_kembali`, `tanggal_jual`) VALUES
(1, 1, 2, 85000, 0, 85000, 85000, 0, '2013-05-10 01:41:56');

-- --------------------------------------------------------

--
-- Table structure for table `promo_detail`
--

CREATE TABLE IF NOT EXISTS `promo_detail` (
  `pk_promo_detail` int(11) NOT NULL AUTO_INCREMENT,
  `fk_promo_main` int(11) NOT NULL,
  `fk_item` int(11) NOT NULL,
  `nilai_diskon` int(11) NOT NULL,
  `jenis_diskon` varchar(50) NOT NULL,
  PRIMARY KEY (`pk_promo_detail`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `promo_detail`
--

INSERT INTO `promo_detail` (`pk_promo_detail`, `fk_promo_main`, `fk_item`, `nilai_diskon`, `jenis_diskon`) VALUES
(1, 5, 5, 4343, 'RUPIAH'),
(2, 5, 5, 4343, 'RUPIAH'),
(3, 6, 7, 2500, 'RUPIAH'),
(4, 6, 7, 2500, 'RUPIAH'),
(8, 9, 3, 23, 'PERSEN');

-- --------------------------------------------------------

--
-- Table structure for table `promo_main`
--

CREATE TABLE IF NOT EXISTS `promo_main` (
  `pk_promo_main` int(11) NOT NULL AUTO_INCREMENT,
  `promo_name` varchar(50) NOT NULL,
  `promo_desc` varchar(255) DEFAULT NULL,
  `promo_active` int(11) NOT NULL DEFAULT '0',
  `promo_active_date` date DEFAULT NULL,
  PRIMARY KEY (`pk_promo_main`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `promo_main`
--

INSERT INTO `promo_main` (`pk_promo_main`, `promo_name`, `promo_desc`, `promo_active`, `promo_active_date`) VALUES
(5, 'testing', 'asdadas', 0, NULL),
(6, 'testing', 'adada', 0, NULL),
(9, 'jelek', 'dasdad', 1, '2013-05-16');

-- --------------------------------------------------------

--
-- Table structure for table `retur`
--

CREATE TABLE IF NOT EXISTS `retur` (
  `pk_retur` int(11) NOT NULL AUTO_INCREMENT,
  `fk_belanja_detail` int(11) NOT NULL,
  `fk_belanja` int(11) NOT NULL,
  `fk_item` int(11) NOT NULL,
  `retur_qty` int(11) NOT NULL,
  `reason` varchar(255) NOT NULL,
  PRIMARY KEY (`pk_retur`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `retur`
--


-- --------------------------------------------------------

--
-- Table structure for table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `sequence_name` varchar(50) NOT NULL,
  `sequence_no` int(11) NOT NULL,
  `sequence_date` date NOT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence`
--

INSERT INTO `sequence` (`sequence_name`, `sequence_no`, `sequence_date`) VALUES
('kode_belanja', 7, '2013-05-01');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `pk_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_login` varchar(25) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `handphone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(25) NOT NULL,
  `active` int(11) NOT NULL,
  PRIMARY KEY (`pk_user`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`pk_user`, `user_login`, `name`, `handphone`, `address`, `email`, `password`, `role`, `active`) VALUES
(1, 'admin', 'admin', NULL, NULL, '', '25d55ad283aa400af464c76d713c07ad', 'ADMIN', 1),
(2, 'mardy', 'mardy jonathan', '08988992852', NULL, '', '25d55ad283aa400af464c76d713c07ad', 'MEMBER', 1),
(3, NULL, 'joko', '08978834308', 'Jl.Cengkir Raya no.17B', 'asdsad@yahoo.com', NULL, 'PERSONAL', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
