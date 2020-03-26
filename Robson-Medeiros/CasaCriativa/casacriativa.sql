-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 26-Mar-2020 às 13:50
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `casacriativa`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ideias`
--

CREATE TABLE `ideias` (
  `idIdeia` int(20) NOT NULL,
  `nomeIdeia` varchar(15) DEFAULT NULL,
  `categoriaIdeia` varchar(12) DEFAULT NULL,
  `descricaoIdeia` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ideias`
--

INSERT INTO `ideias` (`idIdeia`, `nomeIdeia`, `categoriaIdeia`, `descricaoIdeia`) VALUES
(41, 'gs', 'werywer', 'khkjhkjhkj'),
(43, 'yrew', 'asdf', 'dbadfbsdbvdvd'),
(44, 'wqeqt', 'qtwet', 'qwetq');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ideias`
--
ALTER TABLE `ideias`
  ADD PRIMARY KEY (`idIdeia`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ideias`
--
ALTER TABLE `ideias`
  MODIFY `idIdeia` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
