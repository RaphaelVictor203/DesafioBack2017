-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 20-Maio-2018 às 21:11
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbcliente`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_customer_account`
--

DROP TABLE IF EXISTS `tb_customer_account`;
CREATE TABLE IF NOT EXISTS `tb_customer_account` (
  `id_customer` int(5) NOT NULL AUTO_INCREMENT,
  `cpf_cnpj` int(11) NOT NULL,
  `nm_customer` varchar(46) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `vl_total` double NOT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_customer_account`
--

INSERT INTO `tb_customer_account` (`id_customer`, `cpf_cnpj`, `nm_customer`, `is_active`, `vl_total`) VALUES
(1, 19283489, 'Raphael Victor Mendes Silva', 1, 2400),
(2, 12345678, 'Gabriel', 1, 5000),
(3, 12345678, 'Gabriel', 1, 5000),
(4, 87654321, 'Nathalia', 1, 10000),
(5, 97654327, 'Henrique', 1, 6000),
(6, 27465723, 'Ronaldo', 1, 3500);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
