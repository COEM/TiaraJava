-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2017 at 12:32 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `kd_buku` varchar(35) NOT NULL,
  `judul` varchar(1000) NOT NULL,
  `penerbit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`kd_buku`, `judul`, `penerbit`) VALUES
('B001', 'MATEMATIKA SMA-MA/SMK KLS X', 'SEWU'),
('B002', 'BAHASA INDONESIA SMA-MA/SMK KLS X', 'YRAMA WIDYA'),
('B003', 'SOSIOLOGI SMA-MA/SMK KLS X', 'SEWU'),
('B004', 'GEOGRAFI BILINGUAL SMA KLS XI', 'YRAMA WIDYA'),
('M001', 'BUKU GURU IPA TERPADU UNTUK SMP KELAS VIII', 'YRAMA WIDYA'),
('M002', 'BUKU GURU HEADLINE ENGLISH UNTUK SMP KELAS VIII', 'SEWU'),
('M003', 'MATEMATIKA UNTUK SMP/MTS KELAS IX "KURIKULUM 2013"', 'YRAMA WIDYA'),
('M004', 'BUKU GURU HEADLINE ENGLISH 1 FOR SMP/MTS KLS VII KURIKULUM 2013', 'SEWU'),
('S001', 'BUKU GURU TEMATIK UNTUK SD/MI KELAS 1F', 'YRAMA WIDYA'),
('S002', 'TEMATIK BERBAGI PEKERJAAN 4D (TEMA 4) UNTUK SD/MI KELAS 4', 'YRAMA WIDYA'),
('S003', 'MATEMATIKA BERBASIS KARAKTER SD/MI KELAS 1', 'SEWU'),
('S004', 'IPS BERBASIS KARAKTER SD/MI KELAS 2', 'SEWU');

--
-- Triggers `buku`
--
DELIMITER $$
CREATE TRIGGER `addStok` AFTER INSERT ON `buku` FOR EACH ROW BEGIN
 INSERT INTO stok (no_buku,jumlah)
 VALUES (new.kd_buku,0);
 END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `buku_masuk`
--

CREATE TABLE `buku_masuk` (
  `no_faktur` varchar(25) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `kd_suplier` varchar(25) NOT NULL,
  `no_po` int(20) NOT NULL,
  `lokasi` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku_masuk`
--

INSERT INTO `buku_masuk` (`no_faktur`, `tgl_masuk`, `kd_suplier`, `no_po`, `lokasi`) VALUES
('S-19051701', '2017-05-19', 'as', 1, 2),
('S-19051702', '2017-05-19', 'w1', 2, 3),
('S-30051701', '2017-05-30', '12', 12, 1),
('S-30051702', '2017-05-30', '12', 1, 1),
('S-30051703', '2017-05-30', '1', 2, 1),
('S-30051704', '2017-05-30', '13', 1, 1),
('S-30051705', '2017-05-30', '12', 1, 1),
('S-30051706', '2017-05-30', '12', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `cek_pesanan`
--

CREATE TABLE `cek_pesanan` (
  `kd_sp` varchar(20) NOT NULL,
  `kd_plgn` varchar(20) NOT NULL,
  `id_sales` varchar(10) NOT NULL,
  `tgl` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cek_pesanan`
--

INSERT INTO `cek_pesanan` (`kd_sp`, `kd_plgn`, `id_sales`, `tgl`) VALUES
('SP-12071701', 'a01-00003', 'a01', '2017-07-12');

-- --------------------------------------------------------

--
-- Table structure for table `data_buku`
--

CREATE TABLE `data_buku` (
  `kode_buku` varchar(50) NOT NULL,
  `no_faktur` varchar(50) NOT NULL,
  `nama_buku` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `hrg_distributor` bigint(50) NOT NULL,
  `hrg_satuan` bigint(50) NOT NULL,
  `stok` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_buku`
--

INSERT INTO `data_buku` (`kode_buku`, `no_faktur`, `nama_buku`, `penerbit`, `hrg_distributor`, `hrg_satuan`, `stok`) VALUES
('4h4h', 'S-15051701', 'sa', 'asde', 12, 13, 5),
('a0009', 'S-15051701', 'ada', 'sad', 1313, 12, 1),
('a009', 'S-15051701', 'sa', 'asde', 12, 12, 12),
('a12', 'S-15051701', 'ads', 'as', 134, 1234, 4),
('a123', 'S-15051701', 'sad', 'asd', 12, 12, 2),
('a123243', 'S-19051702', 'sf', 'df', 1, 1, 1),
('a1256', 'S-15051701', 'assd', 'asda', 123, 12, 1),
('a312', 'S-15051701', 'asda', 'asd', 12345, 12, 1),
('as123e', 'S-18051701', 'asd', 'ds', 123, 1, 1),
('b002', 'S-30051701', 'adasdsadad', 'rerewfdf', 123, 12, 2),
('b005', 'S-12061701', 'b005', 'sdjdk', 21, 12, 5),
('b123', 'S-30051702', 'dfdfdf', 'adsd', 44, 33, 2),
('c121', 'S-30051703', 'adas', 'afegh', 45, 32, 3),
('d12', 'S-15051701', 'asd', 'asd', 12, 1, 1),
('d3', 'S-19051701', 'ad', 'asd', 1, 2, 1),
('e23', 'S-30051705', 'asds', 'ffaaa', 234, 12, 1),
('e32', 'S-30051706', 'adtr', 'dfdg', 3, 2, 1),
('f1234', 'S-15051701', 'asd', 'asd', 1244, 12, 1),
('f32', 'S-30051705', 'ad', 'dasd', 54, 2, 1),
('ryftghjw', 'S-31051701', 'ryftghjw', 'tf', 4, 3, 5),
('s123', 'S-18051701', 'asd', 'asd', 123, 12, 1),
('s423', 'S-30051704', 'ads', 'dgfgf', 45, 3, 3),
('v232', 'S-30051704', 'adsa', 'dfdf', 23, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `data_masuk`
--

CREATE TABLE `data_masuk` (
  `kode_buku` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `detail_fbuku`
--

CREATE TABLE `detail_fbuku` (
  `id_fbuku` int(11) NOT NULL,
  `no_fbuku` varchar(50) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `jumlah` int(30) NOT NULL,
  `hrg_satuan` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_fbuku`
--

INSERT INTO `detail_fbuku` (`id_fbuku`, `no_fbuku`, `kode_buku`, `jumlah`, `hrg_satuan`) VALUES
(1, 'FB-12061701', 'a001', 2, 3000),
(2, 'FB-12061701', 'a003', 5, 1000),
(3, 'FB-12061701', 'a004', 3, 2000),
(4, 'FB-12061701', 'a005', 1, 3000),
(5, 'FB-13061701', 'a006', 3, 7000),
(6, 'FB-13061701', 'a001', 3, 2000),
(7, 'FB-13061702', 'a001', 3, 2000),
(8, 'FB-13061703', 'a006', 2, 7000),
(9, 'FB-11071701', 'S004', 3, 53000),
(10, 'FB-11071701', 'B004', 4, 46500),
(11, 'FB-12071701', 'B002', 15, 79500),
(12, 'FB-12071701', 'B003', 20, 52500),
(13, 'FB-12071701', 'S004', 20, 53000);

--
-- Triggers `detail_fbuku`
--
DELIMITER $$
CREATE TRIGGER `trgTmbhStokUpdateHrg` AFTER INSERT ON `detail_fbuku` FOR EACH ROW BEGIN
 INSERT INTO stok SET 
 no_buku=new.kode_buku,
 jumlah=new.jumlah
 ON DUPLICATE KEY UPDATE jumlah=jumlah+New.jumlah;
 update harga SET 
 hrg_satuan=new.hrg_satuan
where id_buku=new.kode_buku;
 END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_fjual`
--

CREATE TABLE `detail_fjual` (
  `id_fjual` int(50) NOT NULL,
  `kd_fjual` varchar(25) NOT NULL,
  `kode_bk` varchar(25) NOT NULL,
  `jumlah` int(20) NOT NULL,
  `discount` int(20) NOT NULL,
  `subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_fjual`
--

INSERT INTO `detail_fjual` (`id_fjual`, `kd_fjual`, `kode_bk`, `jumlah`, `discount`, `subtotal`) VALUES
(1, 'FJ-12071701', 'S004', 3, 10, 143100),
(2, 'FJ-12071702', 'S004', 3, 5, 151050),
(3, 'FJ-12071703', 'S004', 3, 5, 151050);

--
-- Triggers `detail_fjual`
--
DELIMITER $$
CREATE TRIGGER `UpdateStokUpdateSubtotal` AFTER INSERT ON `detail_fjual` FOR EACH ROW BEGIN
 INSERT INTO stok SET 
 no_buku=new.kode_bk,
 jumlah=new.jumlah
 ON DUPLICATE KEY UPDATE jumlah=jumlah-New.jumlah;
 INSERT INTO total_jual SET
 kd_faktur=new.kd_fjual,
 total=new.subtotal
 ON DUPLICATE KEY UPDATE total=total+New.subtotal;
 END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `deleteTotalandPiutang` AFTER DELETE ON `detail_fjual` FOR EACH ROW BEGIN
DELETE from total_jual where kd_faktur=old.kd_fjual;

Update stok SET
jumlah=jumlah+old.jumlah where no_buku = old.kode_bk; 
 END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_sp`
--

CREATE TABLE `detail_sp` (
  `id_sp` int(11) NOT NULL,
  `kode_sp` varchar(50) NOT NULL,
  `kode_buku` varchar(50) NOT NULL,
  `jmlh` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_sp`
--

INSERT INTO `detail_sp` (`id_sp`, `kode_sp`, `kode_buku`, `jmlh`) VALUES
(1, 'SP-14061701', 'a001', 2),
(2, 'SP-14061701', 'a006', 2),
(3, 'SP-14061702', 'a001', 2),
(4, 'SP-14061703', 'a001', 2),
(5, 'SP-14061704', 'a001', 4),
(6, 'SP-14061705', 'a001', 3),
(7, 'SP-14061706', 'a001', 2),
(8, 'SP-14061707', 'a001', 2),
(9, 'SP-16061701', 'a001', 3),
(10, 'SP-16061702', 'a001', 4),
(11, 'SP-16061702', 'a001', 3),
(12, 'SP-16061702', 'a006', 3),
(13, 'SP-18061701', 'a001', 4),
(14, 'SP-18061702', 'a001', 3),
(15, 'SP-18061702', 'a006', 2),
(16, 'SP-19061701', 'a001', 20),
(17, 'SP-12071701', 'S004', 3);

-- --------------------------------------------------------

--
-- Table structure for table `faktur_buku`
--

CREATE TABLE `faktur_buku` (
  `no_fbuku` varchar(50) NOT NULL,
  `tgl` date NOT NULL,
  `kd_suplier` int(10) NOT NULL,
  `no_po` int(10) NOT NULL,
  `lokasi` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faktur_buku`
--

INSERT INTO `faktur_buku` (`no_fbuku`, `tgl`, `kd_suplier`, `no_po`, `lokasi`) VALUES
('FB-11071701', '2017-07-11', 1, 1, 1),
('FB-12061701', '2017-06-12', 1, 1, 1),
('FB-12071701', '2017-07-12', 1, 1, 1),
('FB-13061701', '2017-06-13', 3, 3, 3),
('FB-13061702', '2017-06-13', 2, 1, 1),
('FB-13061703', '2017-06-13', 2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `faktur_jual`
--

CREATE TABLE `faktur_jual` (
  `no_fjual` varchar(50) NOT NULL,
  `no_sp` varchar(25) NOT NULL,
  `kode_plgn` varchar(25) NOT NULL,
  `kode_sales` varchar(20) NOT NULL,
  `j_tgl` date NOT NULL,
  `j_tempo` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faktur_jual`
--

INSERT INTO `faktur_jual` (`no_fjual`, `no_sp`, `kode_plgn`, `kode_sales`, `j_tgl`, `j_tempo`) VALUES
('FJ-12071701', 'SP-12071701', 'a01-00003', 'a01', '2017-07-12', '2017-08-01'),
('FJ-12071702', 'SP-12071701', 'a01-00003', 'a01', '2017-07-12', '2017-08-08'),
('FJ-12071703', 'SP-12071701', 'a01-00003', 'a01', '2017-07-12', '2017-08-08');

--
-- Triggers `faktur_jual`
--
DELIMITER $$
CREATE TRIGGER `updatePiutang` AFTER INSERT ON `faktur_jual` FOR EACH ROW BEGIN
Update piutang SET
 kode_fjual = new.no_fjual,
 kode_plgn = new.kode_plgn,
 tgl=new.j_tgl
where kode_fjual=new.no_fjual;
delete from cek_pesanan where kd_sp=no_sp;
 END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `harga`
--

CREATE TABLE `harga` (
  `id_buku` varchar(20) NOT NULL,
  `hrg_satuan` int(11) NOT NULL,
  `hrg_distributor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harga`
--

INSERT INTO `harga` (`id_buku`, `hrg_satuan`, `hrg_distributor`) VALUES
('B001', 99500, 99500),
('B002', 79500, 79500),
('B003', 52500, 52500),
('B004', 46500, 46500),
('M001', 39500, 39500),
('M002', 39500, 39500),
('M003', 96000, 96000),
('M004', 39500, 39500),
('S001', 38000, 38000),
('S002', 45000, 45000),
('S003', 63000, 63000),
('S004', 53000, 53000);

-- --------------------------------------------------------

--
-- Table structure for table `harga_buku`
--

CREATE TABLE `harga_buku` (
  `id_meta` int(11) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `value` int(11) NOT NULL,
  `tgl` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harga_buku`
--

INSERT INTO `harga_buku` (`id_meta`, `jenis`, `value`, `tgl`) VALUES
(1, 'faktur_buku', 0, '0000-00-00'),
(2, 'faktur_jual', 0, '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `log_stok_buku`
--

CREATE TABLE `log_stok_buku` (
  `log_id` int(50) NOT NULL,
  `kd_buku` varchar(50) NOT NULL,
  `stok_lama` int(25) NOT NULL,
  `stok_baru` int(25) NOT NULL,
  `tgl` date NOT NULL,
  `keterangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `kd_manager` varchar(20) NOT NULL,
  `nama_manager` varchar(25) NOT NULL,
  `alamat_manager` varchar(25) NOT NULL,
  `no_telp_manager` varchar(25) NOT NULL,
  `wilayah_manager` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`kd_manager`, `nama_manager`, `alamat_manager`, `no_telp_manager`, `wilayah_manager`) VALUES
('m01', 'Agus', 'Jl. Putri Candramidi', '089693838710', 'Pontianak Kota'),
('m02', 'Muji', 'Jl. A.Yani', '089693838711', 'Pontianak Selatan'),
('m03', 'Budi', 'Jl. Alianyang', '089693838712', 'Pontianak Timur');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `kd_pelanggan` varchar(25) NOT NULL,
  `no_sales` varchar(20) NOT NULL,
  `nama_pelanggan` varchar(20) NOT NULL,
  `alamat_pelanggan` varchar(20) NOT NULL,
  `no_telp_pelanggan` varchar(20) NOT NULL,
  `limits` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`kd_pelanggan`, `no_sales`, `nama_pelanggan`, `alamat_pelanggan`, `no_telp_pelanggan`, `limits`) VALUES
('a01-00002', 'a01', 'MAN2', 'JL. A.YANI NO 9', '0561764907', 5000000),
('a01-00003', 'a01', 'SD MUHAMMADIYAH 2', 'JL. A.YANI', '056178116', 3000000),
('a03-00001', 'a03', 'MTS NEGERI 1', 'JL ALIANYANG', '0891212131', 1000000),
('a06-00001', 'a06', 'sa', 'dada', '012', 12);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `no_kwitansi` varchar(25) NOT NULL,
  `no_jual` varchar(25) NOT NULL,
  `no_plgn` varchar(25) NOT NULL,
  `tgl` date NOT NULL,
  `jumlah_bayar` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`no_kwitansi`, `no_jual`, `no_plgn`, `tgl`, `jumlah_bayar`) VALUES
('KW-12071701', 'FJ-12071702', 'a01-00003', '2017-07-12', 151050);

--
-- Triggers `pembayaran`
--
DELIMITER $$
CREATE TRIGGER `updateSaldoandPiutang` AFTER INSERT ON `pembayaran` FOR EACH ROW BEGIN
 UPDATE piutang SET 
 saldo=saldo-new.jumlah_bayar
 where kode_fjual=new.no_jual;
 UPDATE saldo_plgn SET 
 saldo=saldo-new.jumlah_bayar,
 id_pelanggan=new.no_plgn
 where id_pelanggan=new.no_plgn;
 END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `piutang`
--

CREATE TABLE `piutang` (
  `kode_fjual` varchar(25) NOT NULL,
  `kode_plgn` varchar(20) NOT NULL,
  `tgl` date NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `piutang`
--

INSERT INTO `piutang` (`kode_fjual`, `kode_plgn`, `tgl`, `saldo`) VALUES
('FJ-12071701', 'a01-00003', '2017-07-12', 143100),
('FJ-12071702', 'a01-00003', '2017-07-12', 0),
('FJ-12071703', 'a01-00003', '2017-07-12', 151050);

--
-- Triggers `piutang`
--
DELIMITER $$
CREATE TRIGGER `insertSaldoPlgn` AFTER UPDATE ON `piutang` FOR EACH ROW BEGIN
 INSERT INTO saldo_plgn SET 
 id_pelanggan=new.kode_plgn,
 saldo=new.saldo
 ON DUPLICATE KEY UPDATE saldo=saldo+New.saldo;
 end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `saldo_plgn`
--

CREATE TABLE `saldo_plgn` (
  `id_pelanggan` varchar(25) NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saldo_plgn`
--

INSERT INTO `saldo_plgn` (`id_pelanggan`, `saldo`) VALUES
('a01-00003', 151050);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `kd_sales` varchar(20) NOT NULL,
  `kd_manager` varchar(20) NOT NULL,
  `nama_sales` varchar(20) NOT NULL,
  `alamat_sales` varchar(25) NOT NULL,
  `no_telp_sales` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`kd_sales`, `kd_manager`, `nama_sales`, `alamat_sales`, `no_telp_sales`) VALUES
('a01', 'm01', 'fahri', 'Jl. Perdamaian', '089693838709'),
('a02', 'm01', 'Reza', 'Jl. Ilham', '089693838708'),
('a03', 'm02', 'Yudi', 'Jl. Danau Sentarum', '089693838701'),
('a04', 'm02', 'Meka', 'Jl. M.Yamin', '089693838702'),
('a05', 'm03', 'Nuzul', 'Jl. Dr. Wahidin', '089693838703');

-- --------------------------------------------------------

--
-- Table structure for table `stok`
--

CREATE TABLE `stok` (
  `no_buku` varchar(20) NOT NULL,
  `jumlah` int(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stok`
--

INSERT INTO `stok` (`no_buku`, `jumlah`) VALUES
('B001', 0),
('B002', 15),
('B003', 20),
('B004', 4),
('M001', 0),
('M002', 0),
('M003', 0),
('M004', 0),
('S001', 0),
('S002', 0),
('S003', 0),
('S004', 14);

-- --------------------------------------------------------

--
-- Table structure for table `surat_pemesanan`
--

CREATE TABLE `surat_pemesanan` (
  `kd_sp` varchar(50) NOT NULL,
  `kd_pelanggan` varchar(25) NOT NULL,
  `kd_sales` varchar(10) NOT NULL,
  `tgl` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `surat_pemesanan`
--

INSERT INTO `surat_pemesanan` (`kd_sp`, `kd_pelanggan`, `kd_sales`, `tgl`) VALUES
('SP-12071701', 'a01-00003', 'a01', '2017-07-12');

-- --------------------------------------------------------

--
-- Table structure for table `total_jual`
--

CREATE TABLE `total_jual` (
  `kd_faktur` varchar(25) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `total_jual`
--

INSERT INTO `total_jual` (`kd_faktur`, `total`) VALUES
('FJ-12071701', 143100),
('FJ-12071702', 151050),
('FJ-12071703', 151050);

--
-- Triggers `total_jual`
--
DELIMITER $$
CREATE TRIGGER `deletePiutang` AFTER DELETE ON `total_jual` FOR EACH ROW Begin
Delete from piutang where kode_fjual = old.kd_faktur;
end
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insertUpdateSaldoPiutang` AFTER INSERT ON `total_jual` FOR EACH ROW BEGIN
 INSERT INTO piutang SET 
 kode_fjual = new.kd_faktur,
  saldo=new.total
 ON DUPLICATE KEY UPDATE saldo=saldo+new.total;
 END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `level`) VALUES
('admin', 'admin', 'accountant'),
('gudang', 'gudang', 'gudang');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kd_buku`);

--
-- Indexes for table `buku_masuk`
--
ALTER TABLE `buku_masuk`
  ADD PRIMARY KEY (`no_faktur`);

--
-- Indexes for table `cek_pesanan`
--
ALTER TABLE `cek_pesanan`
  ADD PRIMARY KEY (`kd_sp`);

--
-- Indexes for table `data_buku`
--
ALTER TABLE `data_buku`
  ADD PRIMARY KEY (`kode_buku`);

--
-- Indexes for table `detail_fbuku`
--
ALTER TABLE `detail_fbuku`
  ADD PRIMARY KEY (`id_fbuku`);

--
-- Indexes for table `detail_fjual`
--
ALTER TABLE `detail_fjual`
  ADD PRIMARY KEY (`id_fjual`);

--
-- Indexes for table `detail_sp`
--
ALTER TABLE `detail_sp`
  ADD PRIMARY KEY (`id_sp`);

--
-- Indexes for table `faktur_buku`
--
ALTER TABLE `faktur_buku`
  ADD PRIMARY KEY (`no_fbuku`);

--
-- Indexes for table `faktur_jual`
--
ALTER TABLE `faktur_jual`
  ADD PRIMARY KEY (`no_fjual`);

--
-- Indexes for table `harga`
--
ALTER TABLE `harga`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `harga_buku`
--
ALTER TABLE `harga_buku`
  ADD PRIMARY KEY (`id_meta`);

--
-- Indexes for table `log_stok_buku`
--
ALTER TABLE `log_stok_buku`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`kd_manager`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`kd_pelanggan`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`no_kwitansi`);

--
-- Indexes for table `piutang`
--
ALTER TABLE `piutang`
  ADD PRIMARY KEY (`kode_fjual`);

--
-- Indexes for table `saldo_plgn`
--
ALTER TABLE `saldo_plgn`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`kd_sales`);

--
-- Indexes for table `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`no_buku`);

--
-- Indexes for table `surat_pemesanan`
--
ALTER TABLE `surat_pemesanan`
  ADD PRIMARY KEY (`kd_sp`);

--
-- Indexes for table `total_jual`
--
ALTER TABLE `total_jual`
  ADD PRIMARY KEY (`kd_faktur`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_fbuku`
--
ALTER TABLE `detail_fbuku`
  MODIFY `id_fbuku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `detail_fjual`
--
ALTER TABLE `detail_fjual`
  MODIFY `id_fjual` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `harga_buku`
--
ALTER TABLE `harga_buku`
  MODIFY `id_meta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `log_stok_buku`
--
ALTER TABLE `log_stok_buku`
  MODIFY `log_id` int(50) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
