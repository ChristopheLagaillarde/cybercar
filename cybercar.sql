-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 15, 2022 at 05:31 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cybercar`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int(5) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `adresse` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `nom`, `prenom`, `adresse`) VALUES
(1, 'Stones', 'Jerry', 'Curpipe'),
(2, 'Smith', 'Ella', 'Rose-Hill'),
(3, 'Begue', 'Anna', 'Port-Louis');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `id_employé` int(5) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `adresse` varchar(20) DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `motDePasse` varchar(20) DEFAULT NULL,
  `departement` varchar(20) DEFAULT NULL,
  `civilite` varchar(20) DEFAULT NULL,
  `nomDeJeuneFille` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `situationConjugale` varchar(20) DEFAULT NULL,
  `nombreEnfants` int(2) DEFAULT NULL,
  `entecedantMedicale` varchar(20) DEFAULT NULL,
  `fonction` varchar(20) DEFAULT NULL,
  `dateEmbauche` varchar(20) DEFAULT NULL,
  `Salaire` varchar(20) DEFAULT NULL,
  `nombreConge` varchar(20) DEFAULT NULL,
  `nombreCongeRestant` varchar(20) DEFAULT NULL,
  `dateFinContrat` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_employé`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `id_login` int(5) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `motDePasse` varchar(100) DEFAULT NULL,
  `fonction` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_login`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id_login`, `email`, `motDePasse`, `fonction`) VALUES
(1, 'toto@gmail.com', 'SysAdmin', 'vendeur'),
(2, 'tutu@gmail.com', 'SysAdmin1', 'admin'),
(3, 'titi@gmail.com', 'SysAdmi21', 'gestion');

-- --------------------------------------------------------

--
-- Table structure for table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
CREATE TABLE IF NOT EXISTS `voiture` (
  `id_voiture` int(5) NOT NULL AUTO_INCREMENT,
  `Marque` varchar(25) DEFAULT NULL,
  `Modèle` varchar(25) DEFAULT NULL,
  `Couleur` varchar(25) DEFAULT NULL,
  `Année_de_production` int(5) DEFAULT NULL,
  `Transmission` varchar(20) DEFAULT NULL,
  `Type_de_carburant` varchar(20) DEFAULT NULL,
  `Date_de_livraison` varchar(20) DEFAULT NULL,
  `Pays_de_provenance` varchar(20) DEFAULT NULL,
  `Prix` varchar(20) DEFAULT NULL,
  `Entrepôt` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_voiture`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `voiture`
--

INSERT INTO `voiture` (`id_voiture`, `Marque`, `Modèle`, `Couleur`, `Année_de_production`, `Transmission`, `Type_de_carburant`, `Date_de_livraison`, `Pays_de_provenance`, `Prix`, `Entrepôt`) VALUES
(1, 'Nissan', 'Qashqai', 'Gris', 2022, 'Manuel', 'Essence', '', 'Japon', 'Rs1,800,000', 'Port Louis'),
(2, 'Nissan', 'Qashqai', 'Blanc', 2018, 'Manuel', 'Essence', '', 'Japon', 'Rs1,500,000', 'Baie du Tombeau'),
(3, 'Nissan', 'Qashqai', 'Blanc', 2019, 'Automatique', 'Essence', '', 'Japon', 'Rs1,650,000', 'Pheonix'),
(4, 'Nissan', 'Juke', 'Noir', 2021, 'Automatique', 'Essence', '', 'Japon', 'Rs1,500,000', 'Port Louis'),
(5, 'Nissan', 'Juke', 'Bleu', 2019, 'Automatique', 'Essence', '', 'Japon', 'Rs1,100,000', 'Port Louis'),
(6, 'Nissan', 'Juke', 'Noir', 2021, 'Manuel', 'Essence', '', 'Japon', 'Rs1,400,000', 'Plaisance'),
(7, 'Nissan', 'Navara', 'Gris', 2022, 'Automatique', 'Diesel', '', 'Japon', 'Rs2,100,000', 'Pheonix'),
(8, 'Nissan', 'Navara', 'Argent', 2022, 'Manuel', 'Diesel', '', 'Japon', 'Rs2,000,000', 'Baie du Tombeau'),
(9, 'Nissan', 'Navara', 'Blanc', 2021, 'Manuel', 'Diesel', '', 'Japon', 'Rs1,900,000', 'Plaisance'),
(10, 'Toyota', 'Hilux', 'Blanc', 2022, 'Manuel', 'Diesel', '', 'Japon', 'Rs1,800,000', 'Port Louis'),
(11, 'Toyota', 'Hilux', 'Noir', 2022, 'Manuel', 'Diesel', '', 'Japon', 'Rs1,800,000', 'Baie du Tombeau'),
(12, 'Toyota', 'Hilux', 'Blanc', 2021, 'Automatique', 'Diesel', '', 'Japon', 'Rs2,000,000', 'Pheonix'),
(13, 'Toyota', 'C-HR', 'Blanc', 2022, 'Automatique', 'Essence', '', 'Japon', 'Rs1,800,000', 'Port-Louis'),
(14, 'Toyota', 'C-HR', 'Rouge', 2022, 'Automatique', 'Essence', '', 'Japon', 'Rs1,800,000', 'Plaisance'),
(15, 'Toyota', 'C-HR', 'Blanc', 2022, 'Automatique', 'Essence', '', 'Japon', 'Rs1,800,000', 'Port-Louis'),
(16, 'Mitsubishi', 'L200', 'Argent', 2022, 'Automatique', 'Diesel', '', 'Japon', 'Rs1,700,000', 'Pheonix'),
(17, 'Mitsubishi', 'L200', 'Bleu', 2022, 'Manuel', 'Diesel', '', 'Japon', 'Rs1,600,000', 'Pheonix'),
(18, 'Mitsubishi', 'Triton', 'Noir', 2022, 'Automatique', 'Diesel', '', 'Japon', 'Rs1,800,000', 'Plaisance'),
(19, 'Mitsubishi', 'Triton', 'Blanc', 2022, 'Manuel', 'Diesel', '', 'Japon', 'Rs1,700,000', 'Port Louis');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
