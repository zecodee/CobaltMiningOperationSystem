-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 26, 2026 at 01:37 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cmos_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_pegawai` int(11) NOT NULL,
  `kode_admin` varchar(20) NOT NULL,
  `tanggal_mulai_akses` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `detail_monitoring`
--

CREATE TABLE `detail_monitoring` (
  `id_detail` int(11) NOT NULL,
  `nilai_pengukuran` decimal(12,2) NOT NULL,
  `status_detail` varchar(20) NOT NULL,
  `catatan` varchar(255) DEFAULT NULL,
  `monitoring_lingkungan_id_monitoring` int(11) NOT NULL,
  `parameter_lingkungan_id_parameter` int(11) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `id_pegawai` int(11) NOT NULL,
  `no_sim` varchar(50) NOT NULL,
  `masa_berlaku_sim` date NOT NULL,
  `status_driver` varchar(10) NOT NULL DEFAULT 'TERSEDIA'
) ;

-- --------------------------------------------------------

--
-- Table structure for table `jenis_material`
--

CREATE TABLE `jenis_material` (
  `id_material` int(11) NOT NULL,
  `nama_material` varchar(100) NOT NULL,
  `satuan` varchar(20) NOT NULL,
  `deskripsi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `id_kendaraan` int(11) NOT NULL,
  `jenis_kendaraan` varchar(50) NOT NULL,
  `nomor_polisi` varchar(20) NOT NULL,
  `kapasitas` decimal(10,2) NOT NULL,
  `tahun_kendaraan` smallint(5) UNSIGNED NOT NULL,
  `status_kendaraan` varchar(10) NOT NULL DEFAULT 'TERSEDIA'
) ;

-- --------------------------------------------------------

--
-- Table structure for table `lokasi`
--

CREATE TABLE `lokasi` (
  `id_lokasi` int(11) NOT NULL,
  `nama_lokasi` varchar(100) NOT NULL,
  `jenis_lokasi` varchar(20) NOT NULL,
  `status_operasional` varchar(20) NOT NULL DEFAULT 'AKTIF',
  `keterangan` varchar(255) DEFAULT NULL
) ;

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `id_pegawai` int(11) NOT NULL,
  `divisi_tanggung_jawab` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `monitoring_lingkungan`
--

CREATE TABLE `monitoring_lingkungan` (
  `id_monitoring` int(11) NOT NULL,
  `tanggal_monitoring` datetime NOT NULL,
  `status_monitoring` varchar(20) NOT NULL DEFAULT 'NORMAL',
  `tindak_lanjut` varchar(255) DEFAULT NULL,
  `status_penanganan` varchar(20) NOT NULL DEFAULT 'TIDAK_DIPERLUKAN',
  `catatan` varchar(255) DEFAULT NULL,
  `lokasi_id_lokasi` int(11) NOT NULL,
  `petugas_hse_id_pegawai` int(11) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Table structure for table `parameter_lingkungan`
--

CREATE TABLE `parameter_lingkungan` (
  `id_parameter` int(11) NOT NULL,
  `nama_parameter` varchar(100) NOT NULL,
  `satuan` varchar(30) NOT NULL,
  `batas_minimum` decimal(12,2) DEFAULT NULL,
  `batas_maksimum` decimal(12,2) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL
) ;

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `nama_pegawai` varchar(100) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `tanggal_masuk` date NOT NULL,
  `status_pegawai` varchar(15) NOT NULL DEFAULT 'AKTIF'
) ;

-- --------------------------------------------------------

--
-- Table structure for table `pengangkutan`
--

CREATE TABLE `pengangkutan` (
  `id_pengangkutan` int(11) NOT NULL,
  `tanggal_pengangkutan` date NOT NULL,
  `waktu_mulai` datetime DEFAULT NULL,
  `waktu_selesai` datetime DEFAULT NULL,
  `jumlah_muatan` decimal(12,2) NOT NULL,
  `status_pengangkutan` varchar(20) NOT NULL DEFAULT 'DIJADWALKAN',
  `produksi_tambang_id_produksi` int(11) NOT NULL,
  `kendaraan_id_kendaraan` int(11) NOT NULL,
  `lokasi_id_lokasi` int(11) NOT NULL,
  `lokasi_tujuan_id_lokasi` int(11) NOT NULL,
  `petugas_operasional_id_pegawai` int(11) NOT NULL,
  `driver_id_pegawai` int(11) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Table structure for table `petugas_hse`
--

CREATE TABLE `petugas_hse` (
  `id_pegawai` int(11) NOT NULL,
  `no_sertifikasi_hse` varchar(50) NOT NULL,
  `masa_berlaku_sertifikasi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `petugas_operasional`
--

CREATE TABLE `petugas_operasional` (
  `id_pegawai` int(11) NOT NULL,
  `shift_kerja` varchar(20) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Table structure for table `produksi_tambang`
--

CREATE TABLE `produksi_tambang` (
  `id_produksi` int(11) NOT NULL,
  `tanggal_produksi` date NOT NULL,
  `jumlah_produksi` decimal(12,2) NOT NULL,
  `jumlah_tersedia` decimal(12,2) NOT NULL,
  `status_produksi` varchar(20) NOT NULL DEFAULT 'TERSEDIA',
  `jenis_material_id_material` int(11) NOT NULL,
  `lokasi_id_lokasi` int(11) NOT NULL,
  `petugas_operasional_id_pegawai` int(11) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `pegawai_id_pegawai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD UNIQUE KEY `kode_admin` (`kode_admin`);

--
-- Indexes for table `detail_monitoring`
--
ALTER TABLE `detail_monitoring`
  ADD PRIMARY KEY (`id_detail`),
  ADD UNIQUE KEY `uq_detail_monitoring_parameter` (`monitoring_lingkungan_id_monitoring`,`parameter_lingkungan_id_parameter`),
  ADD KEY `fk_detail_parameter` (`parameter_lingkungan_id_parameter`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD UNIQUE KEY `no_sim` (`no_sim`);

--
-- Indexes for table `jenis_material`
--
ALTER TABLE `jenis_material`
  ADD PRIMARY KEY (`id_material`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`id_kendaraan`),
  ADD UNIQUE KEY `nomor_polisi` (`nomor_polisi`);

--
-- Indexes for table `lokasi`
--
ALTER TABLE `lokasi`
  ADD PRIMARY KEY (`id_lokasi`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `monitoring_lingkungan`
--
ALTER TABLE `monitoring_lingkungan`
  ADD PRIMARY KEY (`id_monitoring`),
  ADD KEY `fk_monitoring_lokasi` (`lokasi_id_lokasi`),
  ADD KEY `fk_monitoring_hse` (`petugas_hse_id_pegawai`),
  ADD KEY `idx_monitoring_tanggal` (`tanggal_monitoring`);

--
-- Indexes for table `parameter_lingkungan`
--
ALTER TABLE `parameter_lingkungan`
  ADD PRIMARY KEY (`id_parameter`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `pengangkutan`
--
ALTER TABLE `pengangkutan`
  ADD PRIMARY KEY (`id_pengangkutan`),
  ADD KEY `fk_angkut_produksi` (`produksi_tambang_id_produksi`),
  ADD KEY `fk_angkut_asal` (`lokasi_id_lokasi`),
  ADD KEY `fk_angkut_tujuan` (`lokasi_tujuan_id_lokasi`),
  ADD KEY `fk_angkut_ops` (`petugas_operasional_id_pegawai`),
  ADD KEY `idx_angkut_jadwal` (`tanggal_pengangkutan`,`status_pengangkutan`),
  ADD KEY `idx_angkut_driver_jadwal` (`driver_id_pegawai`,`tanggal_pengangkutan`,`status_pengangkutan`),
  ADD KEY `idx_angkut_kendaraan_jadwal` (`kendaraan_id_kendaraan`,`tanggal_pengangkutan`,`status_pengangkutan`);

--
-- Indexes for table `petugas_hse`
--
ALTER TABLE `petugas_hse`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD UNIQUE KEY `no_sertifikasi_hse` (`no_sertifikasi_hse`);

--
-- Indexes for table `petugas_operasional`
--
ALTER TABLE `petugas_operasional`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `produksi_tambang`
--
ALTER TABLE `produksi_tambang`
  ADD PRIMARY KEY (`id_produksi`),
  ADD KEY `fk_produksi_material` (`jenis_material_id_material`),
  ADD KEY `fk_produksi_lokasi` (`lokasi_id_lokasi`),
  ADD KEY `fk_produksi_ops` (`petugas_operasional_id_pegawai`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `pegawai_id_pegawai` (`pegawai_id_pegawai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_monitoring`
--
ALTER TABLE `detail_monitoring`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jenis_material`
--
ALTER TABLE `jenis_material`
  MODIFY `id_material` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `id_kendaraan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lokasi`
--
ALTER TABLE `lokasi`
  MODIFY `id_lokasi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `monitoring_lingkungan`
--
ALTER TABLE `monitoring_lingkungan`
  MODIFY `id_monitoring` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `parameter_lingkungan`
--
ALTER TABLE `parameter_lingkungan`
  MODIFY `id_parameter` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id_pegawai` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pengangkutan`
--
ALTER TABLE `pengangkutan`
  MODIFY `id_pengangkutan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produksi_tambang`
--
ALTER TABLE `produksi_tambang`
  MODIFY `id_produksi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_pegawai` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON UPDATE CASCADE;

--
-- Constraints for table `detail_monitoring`
--
ALTER TABLE `detail_monitoring`
  ADD CONSTRAINT `fk_detail_monitoring` FOREIGN KEY (`monitoring_lingkungan_id_monitoring`) REFERENCES `monitoring_lingkungan` (`id_monitoring`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_detail_parameter` FOREIGN KEY (`parameter_lingkungan_id_parameter`) REFERENCES `parameter_lingkungan` (`id_parameter`) ON UPDATE CASCADE;

--
-- Constraints for table `driver`
--
ALTER TABLE `driver`
  ADD CONSTRAINT `fk_driver_pegawai` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON UPDATE CASCADE;

--
-- Constraints for table `manager`
--
ALTER TABLE `manager`
  ADD CONSTRAINT `fk_manager_pegawai` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON UPDATE CASCADE;

--
-- Constraints for table `monitoring_lingkungan`
--
ALTER TABLE `monitoring_lingkungan`
  ADD CONSTRAINT `fk_monitoring_hse` FOREIGN KEY (`petugas_hse_id_pegawai`) REFERENCES `petugas_hse` (`id_pegawai`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_monitoring_lokasi` FOREIGN KEY (`lokasi_id_lokasi`) REFERENCES `lokasi` (`id_lokasi`) ON UPDATE CASCADE;

--
-- Constraints for table `pengangkutan`
--
ALTER TABLE `pengangkutan`
  ADD CONSTRAINT `fk_angkut_asal` FOREIGN KEY (`lokasi_id_lokasi`) REFERENCES `lokasi` (`id_lokasi`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_angkut_driver` FOREIGN KEY (`driver_id_pegawai`) REFERENCES `driver` (`id_pegawai`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_angkut_kendaraan` FOREIGN KEY (`kendaraan_id_kendaraan`) REFERENCES `kendaraan` (`id_kendaraan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_angkut_ops` FOREIGN KEY (`petugas_operasional_id_pegawai`) REFERENCES `petugas_operasional` (`id_pegawai`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_angkut_produksi` FOREIGN KEY (`produksi_tambang_id_produksi`) REFERENCES `produksi_tambang` (`id_produksi`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_angkut_tujuan` FOREIGN KEY (`lokasi_tujuan_id_lokasi`) REFERENCES `lokasi` (`id_lokasi`) ON UPDATE CASCADE;

--
-- Constraints for table `petugas_hse`
--
ALTER TABLE `petugas_hse`
  ADD CONSTRAINT `fk_hse_pegawai` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON UPDATE CASCADE;

--
-- Constraints for table `petugas_operasional`
--
ALTER TABLE `petugas_operasional`
  ADD CONSTRAINT `fk_ops_pegawai` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON UPDATE CASCADE;

--
-- Constraints for table `produksi_tambang`
--
ALTER TABLE `produksi_tambang`
  ADD CONSTRAINT `fk_produksi_lokasi` FOREIGN KEY (`lokasi_id_lokasi`) REFERENCES `lokasi` (`id_lokasi`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_produksi_material` FOREIGN KEY (`jenis_material_id_material`) REFERENCES `jenis_material` (`id_material`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_produksi_ops` FOREIGN KEY (`petugas_operasional_id_pegawai`) REFERENCES `petugas_operasional` (`id_pegawai`) ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_pegawai` FOREIGN KEY (`pegawai_id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
