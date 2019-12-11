-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 11 dec 2019 kl 12:28
-- Serverversion: 10.4.6-MariaDB
-- PHP-version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `opendata_db`
--
CREATE DATABASE IF NOT EXISTS `opendata_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `opendata_db`;

-- --------------------------------------------------------

--
-- Tabellstruktur `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL COMMENT 'Item id (PRIMARY)',
  `link` varchar(256) NOT NULL COMMENT 'Link to bytbil.com article. ex: bytbil.com/[LINK]'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellstruktur `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT 'User ID (PRIMARY)',
  `username` varchar(32) NOT NULL COMMENT 'username (UNIQUE)',
  `hash` varchar(256) NOT NULL COMMENT 'hashed version of users password'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellstruktur `user_item`
--

CREATE TABLE `user_item` (
  `user_id` int(11) NOT NULL COMMENT 'Users ID',
  `item_id` int(11) NOT NULL COMMENT 'Items ID'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Ersättningsstruktur för vy `user_item_full_info`
-- (See below for the actual view)
--
CREATE TABLE `user_item_full_info` (
`user_id` int(11)
,`username` varchar(32)
,`item_id` int(11)
,`link` varchar(256)
);

-- --------------------------------------------------------

--
-- Struktur för vy `user_item_full_info`
--
DROP TABLE IF EXISTS `user_item_full_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_item_full_info`  AS  select `user`.`id` AS `user_id`,`user`.`username` AS `username`,`item`.`id` AS `item_id`,`item`.`link` AS `link` from ((`user` join `item`) join `user_item`) where `user`.`id` = `user_item`.`user_id` and `item`.`id` = `user_item`.`item_id` ;

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `link_idx` (`link`);

--
-- Index för tabell `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_idx` (`username`);

--
-- Index för tabell `user_item`
--
ALTER TABLE `user_item`
  ADD PRIMARY KEY (`user_id`,`item_id`),
  ADD KEY `item_id` (`item_id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Item id (PRIMARY)';

--
-- AUTO_INCREMENT för tabell `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'User ID (PRIMARY)';

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `user_item`
--
ALTER TABLE `user_item`
  ADD CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
