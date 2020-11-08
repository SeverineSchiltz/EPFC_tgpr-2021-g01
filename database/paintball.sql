-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : lun. 19 oct. 2020 à 01:57 par Leyla Malsagova
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.2.27
DROP DATABASE IF EXISTS paintball;
CREATE DATABASE paintball;
USE paintball;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS paintball;
CREATE DATABASE paintball;
USE paintball;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
--
-- Base de données : `paintball`
--

-- --------------------------------------------------------

--
-- Structure de la table `Equipment_Stock`
--

CREATE TABLE `Equipment_Stock` (
  `id` int(10) NOT NULL,
  `equipment_type_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Equipment_Stock`
--

INSERT INTO `Equipment_Stock` (`id`, `equipment_type_id`) VALUES
(1, 1),
(28, 1),
(55, 1),
(56, 1),
(109, 1),
(110, 1),
(111, 1),
(112, 1),
(2, 2),
(29, 2),
(57, 2),
(58, 2),
(113, 2),
(114, 2),
(115, 2),
(116, 2),
(3, 3),
(30, 3),
(59, 3),
(60, 3),
(117, 3),
(118, 3),
(119, 3),
(120, 3),
(4, 4),
(31, 4),
(61, 4),
(62, 4),
(121, 4),
(122, 4),
(123, 4),
(124, 4),
(5, 5),
(32, 5),
(63, 5),
(64, 5),
(125, 5),
(126, 5),
(127, 5),
(128, 5),
(6, 6),
(33, 6),
(65, 6),
(66, 6),
(129, 6),
(130, 6),
(131, 6),
(132, 6),
(7, 7),
(34, 7),
(67, 7),
(68, 7),
(133, 7),
(134, 7),
(135, 7),
(136, 7),
(8, 8),
(35, 8),
(69, 8),
(70, 8),
(137, 8),
(138, 8),
(139, 8),
(140, 8),
(9, 9),
(36, 9),
(71, 9),
(72, 9),
(141, 9),
(142, 9),
(143, 9),
(144, 9),
(10, 10),
(37, 10),
(73, 10),
(74, 10),
(145, 10),
(146, 10),
(147, 10),
(148, 10),
(11, 11),
(38, 11),
(75, 11),
(76, 11),
(149, 11),
(150, 11),
(151, 11),
(152, 11),
(12, 12),
(39, 12),
(77, 12),
(78, 12),
(153, 12),
(154, 12),
(155, 12),
(156, 12),
(13, 13),
(40, 13),
(79, 13),
(80, 13),
(157, 13),
(158, 13),
(159, 13),
(160, 13),
(14, 14),
(41, 14),
(81, 14),
(82, 14),
(161, 14),
(162, 14),
(163, 14),
(164, 14),
(15, 15),
(42, 15),
(83, 15),
(84, 15),
(165, 15),
(166, 15),
(167, 15),
(168, 15),
(16, 16),
(43, 16),
(85, 16),
(86, 16),
(169, 16),
(170, 16),
(171, 16),
(172, 16),
(17, 17),
(44, 17),
(87, 17),
(88, 17),
(173, 17),
(174, 17),
(175, 17),
(176, 17),
(18, 18),
(45, 18),
(89, 18),
(90, 18),
(177, 18),
(178, 18),
(179, 18),
(180, 18),
(19, 19),
(46, 19),
(91, 19),
(92, 19),
(181, 19),
(182, 19),
(183, 19),
(184, 19),
(20, 20),
(47, 20),
(93, 20),
(94, 20),
(185, 20),
(186, 20),
(187, 20),
(188, 20),
(21, 21),
(48, 21),
(95, 21),
(96, 21),
(189, 21),
(190, 21),
(191, 21),
(192, 21),
(22, 22),
(49, 22),
(97, 22),
(98, 22),
(193, 22),
(194, 22),
(195, 22),
(196, 22),
(23, 23),
(50, 23),
(99, 23),
(100, 23),
(197, 23),
(198, 23),
(199, 23),
(200, 23),
(24, 24),
(51, 24),
(101, 24),
(102, 24),
(201, 24),
(202, 24),
(203, 24),
(204, 24),
(25, 25),
(52, 25),
(103, 25),
(104, 25),
(205, 25),
(206, 25),
(207, 25),
(26, 26),
(53, 26),
(105, 26),
(106, 26),
(27, 27),
(54, 27),
(107, 27),
(108, 27);

-- --------------------------------------------------------

--
-- Structure de la table `Equipment_Type`
--

CREATE TABLE `Equipment_Type` (
  `id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL COMMENT 'nom qui contient taille, couleur, ...',
  `rent_price` decimal(10,2) DEFAULT NULL,
  `sell_price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Equipment_Type`
--

INSERT INTO `Equipment_Type` (`id`, `name`, `rent_price`, `sell_price`) VALUES
(1, '100 GREEN Bullets', NULL, '5.00'),
(2, '100 RED Bullets', NULL, '5.00'),
(3, '100 YELLOW Bullets', NULL, '5.00'),
(4, '100 BLUE Bullets', NULL, '5.00'),
(5, '200 GREEN Bullets', NULL, '7.50'),
(6, '200 RED Bullets', NULL, '7.50'),
(7, '200 YELLOW Bullets', NULL, '7.50'),
(8, '200 BLUE Bullets', NULL, '7.50'),
(9, '300 GREEN Bullets', NULL, '11.00'),
(10, '300 RED Bullets', NULL, '11.00'),
(11, '300 YELLOW Bullets', NULL, '11.00'),
(12, '300 BLUE Bullets', NULL, '11.00'),
(13, 'Gun', '5.00', '80.00'),
(14, 'Suit S', NULL, NULL),
(15, 'Suit M', NULL, NULL),
(16, 'Suit L', NULL, NULL),
(17, 'Suit XL', NULL, NULL),
(18, 'Vest S', NULL, NULL),
(19, 'Vest M', NULL, NULL),
(20, 'Vest L', NULL, NULL),
(21, 'Vest XL', NULL, NULL),
(22, 'Helmet S', NULL, NULL),
(23, 'Helmet M', NULL, NULL),
(24, 'Helmet L', NULL, NULL),
(25, 'Color Flags', NULL, NULL),
(26, 'President Suit', NULL, NULL),
(27, 'Rabbit Suit', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `Equipment_Type_Fight_Type`
--

CREATE TABLE `Equipment_Type_Fight_Type` (
  `equipment_type_id` int(10) NOT NULL,
  `fight_type_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Equipment_Type_Fight_Type`
--

INSERT INTO `Equipment_Type_Fight_Type` (`equipment_type_id`, `fight_type_id`) VALUES
(25, 6),
(26, 1),
(27, 5);

-- --------------------------------------------------------

--
-- Structure de la table `Field`
--

CREATE TABLE `Field` (
  `id` int(10) NOT NULL,
  `name` varchar(16) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  `is_inside` tinyint(1) NOT NULL COMMENT '1 : true 0 : false',
  `level` tinyint(1) NOT NULL,
  `max_players` tinyint(2) NOT NULL COMMENT 'up to 24 players',
  `min_players` tinyint(2) NOT NULL COMMENT 'from 3 players',
  `vip` tinyint(1) NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Field`
--

INSERT INTO `Field` (`id`, `name`, `description`, `is_inside`, `level`, `max_players`, `min_players`, `vip`, `price`) VALUES
(1, 'FOREST', 'Very large forest full of trees with 4 camps that can accommodate 2-3-4 teams. Lots of small shelters.', 0, 1, 20, 8, 0, '80.00'),
(2, 'CASTLE', '2 opposing castles, which team will manage to prevent an intrusion into theirs ?\r\n', 0, 2, 14, 10, 0, '100.00'),
(3, 'JUNGLE', 'Large indoor space in a humid, tropical climate. ', 1, 3, 14, 8, 0, '80.00'),
(4, 'WAREHOUSE', 'A huge hangar full of hiding places. \r\nCan be used for a battle royal. ', 1, 4, 20, 10, 0, '100.00'),
(5, 'MAZE', 'A circular maze with 20 different entrances for each player.', 1, 5, 20, 10, 0, '100.00');

-- --------------------------------------------------------

--
-- Structure de la table `Fight_Type`
--

CREATE TABLE `Fight_Type` (
  `id` int(10) NOT NULL,
  `name` varchar(16) NOT NULL,
  `description` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Fight_Type`
--

INSERT INTO `Fight_Type` (`id`, `name`, `description`) VALUES
(1, 'PRESIDENT', 'The member of one of the teams (min 2, max 4) is president and must arrive from point A to point B. \r\nOnly the president\'s team will know where is the point B. \r\nThe president wears a bulletproof vest and has a weapon to defend himself.\r\n'),
(2, 'BATTLE ROYAL', 'There should only be one survivor... One or none. '),
(3, 'SPY', 'There is a traitor in each team... They know each other and they will do everything to erase everyone. '),
(4, 'AMONG US', ''),
(5, 'HUNTING', ''),
(6, 'CONQUERING', '');

-- --------------------------------------------------------

--
-- Structure de la table `Fight_Type_Field`
--

CREATE TABLE `Fight_Type_Field` (
  `fight_type_id` int(10) NOT NULL,
  `field_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Fight_Type_Field`
--

INSERT INTO `Fight_Type_Field` (`fight_type_id`, `field_id`) VALUES
(2, 5),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(6, 2);

-- --------------------------------------------------------

--
-- Structure de la table `Reservation`
--

CREATE TABLE `Reservation` (
  `id` int(10) NOT NULL,
  `date` datetime DEFAULT NULL,
  `timeslot` enum('Morning','Afternoon','Evening') NOT NULL,
  `is_cancelled` tinyint(1) DEFAULT NULL COMMENT '0 : not cancelled 1 : cancelled',
  `field_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `fight_type_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Reservation`
--

INSERT INTO `Reservation` (`id`, `date`, `timeslot`, `is_cancelled`, `field_id`, `user_id`, `fight_type_id`) VALUES
(1, '2020-12-18 00:00:00', 'Evening', NULL, 1, 1, 3),
(2, '2020-12-19 00:00:00', 'Morning', NULL, 2, 2, 4),
(3, '2020-12-20 00:00:00', 'Morning', NULL, 3, 3, 3),
(4, '2020-12-21 00:00:00', 'Afternoon', NULL, 4, 4, 4),
(5, '2020-12-22 00:00:00', 'Evening', NULL, 5, 5, 2),
(6, '2020-12-23 00:00:00', 'Afternoon', 1, 1, 6, 3);

-- --------------------------------------------------------

--
-- Structure de la table `Reservation_Equipment_Stock`
--

CREATE TABLE `Reservation_Equipment_Stock` (
  `reservation_id` int(10) NOT NULL,
  `equipment_stock_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Reservation_Equipment_Stock`
--

INSERT INTO `Reservation_Equipment_Stock` (`reservation_id`, `equipment_stock_id`) VALUES
(1, 110),
(1, 111),
(2, 114),
(3, 113),
(4, 30),
(5, 59),
(6, 112);

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE `User` (
  `id` int(10) NOT NULL,
  `username` varchar(32) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `e-mail` varchar(64) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','employe','member','member vip') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `User`
--

INSERT INTO `User` (`id`, `username`, `firstname`, `lastname`, `birthdate`, `e-mail`, `password`, `role`) VALUES
(1, 'lmalsag', 'Leyla', 'Malsagova', NULL, 'leyla.malsagova@gmail.com', 'leyla01', 'admin'),
(2, 'nvorkap', 'Nikola', 'Vorkapic', NULL, 'nikola.vorkapic@gmail.com', 'nikola01', 'employe'),
(3, 'sschilt', 'Séverine', 'Schiltz', NULL, 'severine.schiltz@gmail.com', 'severine01', 'member'),
(4, 'ssoupar', 'Sinouhé', 'Soupart', NULL, 'sinouhe.soupart@gmail.com', 'sinouhe01', 'member'),
(5, 'cjadot', 'Christophe', 'Jadot', NULL, 'christophe.jadot@gmail.com', 'christophe01', 'member vip'),
(6, 'iboudgh', 'Ines', 'Boudghene', NULL, 'ines.boudghene@gmail.com', 'ines01', 'member vip');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Equipment_Stock`
--
ALTER TABLE `Equipment_Stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_equipment_type.id` (`equipment_type_id`);

--
-- Index pour la table `Equipment_Type`
--
ALTER TABLE `Equipment_Type`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Equipment_Type_Fight_Type`
--
ALTER TABLE `Equipment_Type_Fight_Type`
  ADD PRIMARY KEY (`equipment_type_id`,`fight_type_id`),
  ADD KEY `fk_fight_type.id` (`fight_type_id`) USING BTREE,
  ADD KEY `fk_equipment_type.id` (`equipment_type_id`) USING BTREE;

--
-- Index pour la table `Field`
--
ALTER TABLE `Field`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_unique` (`name`) USING BTREE;

--
-- Index pour la table `Fight_Type`
--
ALTER TABLE `Fight_Type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_unique` (`name`) USING BTREE;

--
-- Index pour la table `Fight_Type_Field`
--
ALTER TABLE `Fight_Type_Field`
  ADD PRIMARY KEY (`fight_type_id`,`field_id`) USING BTREE,
  ADD KEY `fk_fight_type.id` (`fight_type_id`),
  ADD KEY `fk_field.id` (`field_id`);

--
-- Index pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_used.id` (`user_id`) USING BTREE,
  ADD KEY `fk_field.id` (`field_id`) USING BTREE,
  ADD KEY `fk_fight_type.id` (`fight_type_id`);

--
-- Index pour la table `Reservation_Equipment_Stock`
--
ALTER TABLE `Reservation_Equipment_Stock`
  ADD PRIMARY KEY (`reservation_id`,`equipment_stock_id`) USING BTREE,
  ADD KEY `fk_reservation.id` (`reservation_id`),
  ADD KEY `equipment_stock_id` (`equipment_stock_id`);

--
-- Index pour la table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_unique` (`username`) USING BTREE,
  ADD UNIQUE KEY `e-mail_unique` (`e-mail`) USING BTREE;

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Equipment_Stock`
--
ALTER TABLE `Equipment_Stock`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=208;

--
-- AUTO_INCREMENT pour la table `Equipment_Type`
--
ALTER TABLE `Equipment_Type`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;

--
-- AUTO_INCREMENT pour la table `Field`
--
ALTER TABLE `Field`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `Fight_Type`
--
ALTER TABLE `Fight_Type`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `Reservation`
--
ALTER TABLE `Reservation`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `User`
--
ALTER TABLE `User`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Equipment_Stock`
--
ALTER TABLE `Equipment_Stock`
  ADD CONSTRAINT `equipment_stock_ibfk_1` FOREIGN KEY (`equipment_type_id`) REFERENCES `Equipment_Type` (`id`);

--
-- Contraintes pour la table `Equipment_Type_Fight_Type`
--
ALTER TABLE `Equipment_Type_Fight_Type`
  ADD CONSTRAINT `equipment_type_fight_type_ibfk_1` FOREIGN KEY (`equipment_type_id`) REFERENCES `Equipment_Type` (`id`),
  ADD CONSTRAINT `equipment_type_fight_type_ibfk_2` FOREIGN KEY (`fight_type_id`) REFERENCES `Fight_Type` (`id`);

--
-- Contraintes pour la table `Fight_Type_Field`
--
ALTER TABLE `Fight_Type_Field`
  ADD CONSTRAINT `fight_type_field_ibfk_1` FOREIGN KEY (`fight_type_id`) REFERENCES `Fight_Type` (`id`),
  ADD CONSTRAINT `fight_type_field_ibfk_2` FOREIGN KEY (`field_id`) REFERENCES `Field` (`id`);

--
-- Contraintes pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`field_id`) REFERENCES `Field` (`id`),
  ADD CONSTRAINT `reservation_ibfk_4` FOREIGN KEY (`fight_type_id`) REFERENCES `Fight_Type` (`id`);

--
-- Contraintes pour la table `Reservation_Equipment_Stock`
--
ALTER TABLE `Reservation_Equipment_Stock`
  ADD CONSTRAINT `reservation_equipment_stock_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `Reservation` (`id`),
  ADD CONSTRAINT `reservation_equipment_stock_ibfk_2` FOREIGN KEY (`equipment_stock_id`) REFERENCES `Equipment_Stock` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;