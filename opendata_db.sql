-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 14 jan 2020 kl 11:00
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
-- Tabellstruktur `car`
--

CREATE TABLE `car` (
  `id` int(11) NOT NULL COMMENT 'Item id (PRIMARY)',
  `link` varchar(256) NOT NULL COMMENT 'Link to bytbil.com article. ex: bytbil.com/[LINK]',
  `brand` varchar(32) NOT NULL COMMENT 'Bilens märke',
  `regnum` varchar(16) NOT NULL COMMENT 'Regnummret till bilen',
  `address` varchar(128) NOT NULL COMMENT 'Address till vart bilen finns',
  `model` varchar(32) NOT NULL COMMENT 'Bilens modell',
  `drivewheel` varchar(16) NOT NULL COMMENT '2wd / 4wd',
  `milage` int(11) NOT NULL COMMENT 'Hur många mil bilen gått',
  `price` int(11) NOT NULL COMMENT 'Vad bilen säljs för',
  `gearbox` varchar(16) NOT NULL COMMENT 'manuel / automat',
  `year` int(11) NOT NULL COMMENT 'Årsmodell',
  `fuel` varchar(32) NOT NULL COMMENT 'Type of fuel (Disel/Bensin)'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellstruktur `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT 'User ID (PRIMARY)',
  `username` varchar(32) NOT NULL COMMENT 'username (UNIQUE)',
  `hash` varchar(256) NOT NULL COMMENT 'hashed version of users password',
  `oauth_id` varchar(32) DEFAULT NULL COMMENT 'Oauth ID from Github',
  `token` varchar(128) DEFAULT NULL COMMENT 'OAuth/Auth Token'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellstruktur `user_car`
--

CREATE TABLE `user_car` (
  `user_id` int(11) NOT NULL COMMENT 'Users ID',
  `car_id` int(11) NOT NULL COMMENT 'Items ID'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Ersättningsstruktur för vy `user_car_full_info`
-- (See below for the actual view)
--
CREATE TABLE `user_car_full_info` (
`user_id` int(11)
,`username` varchar(32)
,`item_id` int(11)
,`link` varchar(256)
,`brand` varchar(32)
,`regnum` varchar(16)
,`address` varchar(128)
,`model` varchar(32)
,`drivewheel` varchar(16)
,`milage` int(11)
,`price` int(11)
,`gearbox` varchar(16)
);

-- --------------------------------------------------------

--
-- Struktur för vy `user_car_full_info`
--
DROP TABLE IF EXISTS `user_car_full_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_car_full_info`  AS  select `user`.`id` AS `user_id`,`user`.`username` AS `username`,`car`.`id` AS `item_id`,`car`.`link` AS `link`,`car`.`brand` AS `brand`,`car`.`regnum` AS `regnum`,`car`.`address` AS `address`,`car`.`model` AS `model`,`car`.`drivewheel` AS `drivewheel`,`car`.`milage` AS `milage`,`car`.`price` AS `price`,`car`.`gearbox` AS `gearbox` from ((`user` join `car`) join `user_car`) where `user`.`id` = `user_car`.`user_id` and `car`.`id` = `user_car`.`car_id` ;

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `link_idx` (`link`);

--
-- Index för tabell `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_idx` (`username`),
  ADD UNIQUE KEY `token_idx` (`token`),
  ADD UNIQUE KEY `oauth_idx` (`oauth_id`);

--
-- Index för tabell `user_car`
--
ALTER TABLE `user_car`
  ADD PRIMARY KEY (`user_id`,`car_id`),
  ADD KEY `item_id` (`car_id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `car`
--
ALTER TABLE `car`
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
-- Restriktioner för tabell `user_car`
--
ALTER TABLE `user_car`
  ADD CONSTRAINT `item_id` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
