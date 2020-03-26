-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Mar-2020 às 15:04
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeto`
--
CREATE DATABASE IF NOT EXISTS `projeto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `projeto`;

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `adicionaTarefa` (`titulo` VARCHAR(255), `descricao` TEXT, `prioridade` TINYINT(1))  INSERT INTO tarefas(tituloTarefa, descricaoTarefa, prioridadeTarefa) VALUES (titulo, descricao, prioridade)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `atualizaTarefa` (`id` BIGINT, `titulo` VARCHAR(255), `descricao` TEXT, `prioridade` TINYINT(1))  UPDATE tarefas 
	SET 
    	tituloTarefa = titulo,
        descricaoTarefa = descricao,
        prioridadeTarefa = prioridade
	WHERE idTarefa = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getQtdTarefasNoAno` ()  SELECT COUNT(idTarefa) FROM tarefas WHERE finalizacaoTarefa = 1 AND year(dataTerminoTarefa) = year(NOW())$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getQtdTarefasNoMes` ()  SELECT COUNT(idTarefa) FROM tarefas WHERE finalizacaoTarefa = 1 AND year(dataTerminoTarefa) = year(NOW()) AND month(dataTerminoTarefa) = month(NOW())$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getQtdTarefasNoTotal` ()  SELECT COUNT(idTarefa) FROM tarefas WHERE finalizacaoTarefa = 1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getQtdTarefasPendentes` ()  SELECT COUNT(idTarefa) FROM tarefas WHERE finalizacaoTarefa = 0$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaTarefasFinalizadas` ()  select * from tarefas where finalizacaoTarefa = 1 ORDER BY dataTerminoTarefa DESC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaTarefasPendentes` ()  select * from tarefas where finalizacaoTarefa != 1 ORDER BY dataInicioTarefa DESC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `marcarComoFinalizado` (`id` BIGINT)  UPDATE tarefas
	SET
    	finalizacaoTarefa = 1,
        dataTerminoTarefa = NOW()
	WHERE idTarefa = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `removeTarefa` (`id` BIGINT)  DELETE FROM tarefas WHERE idTarefa = id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tarefas`
--

CREATE TABLE `tarefas` (
  `idTarefa` bigint(20) NOT NULL,
  `tituloTarefa` varchar(255) NOT NULL,
  `descricaoTarefa` text DEFAULT NULL,
  `prioridadeTarefa` tinyint(1) NOT NULL DEFAULT 3,
  `finalizacaoTarefa` tinyint(1) NOT NULL DEFAULT 0,
  `dataInicioTarefa` datetime DEFAULT current_timestamp(),
  `dataTerminoTarefa` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tarefas`
--

INSERT INTO `tarefas` (`idTarefa`, `tituloTarefa`, `descricaoTarefa`, `prioridadeTarefa`, `finalizacaoTarefa`, `dataInicioTarefa`, `dataTerminoTarefa`) VALUES
(3, 'Levar o cachorro pra passear', 'O bicho tá triste', 2, 1, '2020-03-26 06:15:47', '2020-03-26 07:20:20'),
(4, 'Limpar o chiqueiro', 'Limpar esse chiqueiro que você chama de quarto.', 1, 0, '2020-03-26 07:25:19', NULL),
(6, 'Terminar de assistir a volta dos que não foram', '', 3, 1, '2020-03-26 07:27:31', '2020-03-26 10:49:41'),
(7, 'Fazer churrasco pós-quarentena', 'Muito importante', 1, 1, '2020-03-26 10:44:03', '2020-03-26 10:49:28'),
(8, 'Comprar cerveja', 'Tem que comprar porque tá muito quente', 1, 0, '2020-03-26 10:50:13', NULL);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tarefas`
--
ALTER TABLE `tarefas`
  ADD PRIMARY KEY (`idTarefa`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tarefas`
--
ALTER TABLE `tarefas`
  MODIFY `idTarefa` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
