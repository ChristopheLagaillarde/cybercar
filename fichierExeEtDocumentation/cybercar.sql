-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2022 at 05:49 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.28

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

CREATE TABLE `client` (
  `id_client` int(5) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `adresse` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `employe` (
  `id_employé` int(5) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `adresse` varchar(20) DEFAULT NULL,
  `login` varchar(50) DEFAULT NULL,
  `motDePasse` varchar(100) DEFAULT NULL,
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
  `dateFinContrat` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`id_employé`, `nom`, `prenom`, `adresse`, `login`, `motDePasse`, `departement`, `civilite`, `nomDeJeuneFille`, `telephone`, `email`, `situationConjugale`, `nombreEnfants`, `entecedantMedicale`, `fonction`, `dateEmbauche`, `Salaire`, `nombreConge`, `nombreCongeRestant`, `dateFinContrat`) VALUES
(51, 'Lorette', 'Alice', 'Curepipe', 'vendeur@cybercar.com', '30e36724313b7e3d9fff50e3772f769d361ad626fb228662385235a28499f761', 'Vente', 'Mme', 'Philogene', '0697346494', 'philogene5@yahoo.fr', 'Divorse', 3, 'Diabete', 'vendeur', '01-01-22', '28000', '22', '20', NULL),
(52, 'Wong', 'Chloe', 'Ebene', 'adminSystem@cybercar.com', '-48d96d33c54c32241a109efc542c1ac08a74f2c6bc4a77923f11eb47dddf9667', 'SI', 'Mme', 'Wong', '0669633814', 'Wong@yahoo.fr', 'Aucun', 0, 'Asme', 'adminSystem', '08-07-21', '30000', '21', '10', '12-05-24'),
(53, 'Daron', 'Paul', 'Port Louis', 'employeRH@cybercar.com', '-3c9c2fb35e16dfb2d7be2aa35e84fded75ee0f0a36169fadd051631d78a0fee8', 'RH', ' Mr', 'non concerne', '0622547996', 'PaulD@gmail.com', 'Marie', 2, 'Aucun', 'employeRH', '05-11-20', '32000', '21', '18', '12-05-23'),
(54, 'Meyepa', 'Alice', 'Riviere noire', 'garagiste@cybercar.com', '5e0680057960895ffdd0ef2243a5ecff4211d3ed4e93441163438aee62adb3fa', 'garage', 'Mme', 'Meyepa', '0677896302', 'AlMeye@yahoo.fr', 'Aucun', 0, 'Aucun', 'garagiste', '01-08-21', '26000', '23', '5', '28-01-23'),
(55, 'De Vitry', 'John', 'Curepipe', 'employeFinance@cybercar.com', '-4c1b2d48cfa3bba27b0f4df771b5f30b7aa11471a08d029f31107066d64f8c39', 'Finance', 'Mr', 'non concerne', '0655896365', 'devitry@yahoo.fr', 'Marie', 2, 'Hyper tension', 'employeFinance', '05-11-20', '35000', '24', '7', NULL),
(56, 'Ramasamy', 'Tariq', 'Ebene', 'employeSI@cybercar.com', '637e4a6e7de2542401e758538e65b4679c80b631a37a3b5f8ccbe18eb696f924', 'SI', 'Mr', 'non concerne', '0655996254', 'tariqR@gmail.com', 'Aucun', 3, 'Aucun', 'employeSI', '05-11-20', '26000', '21', '21', '27-05-24'),
(57, 'Soreefan', 'Bob', 'Tamarin', 'nouveau@cybercar.com', '3f030f77f686eb0629b77dc4664a6d5ecf2d53b55457f8cac46ef68853872b43', 'Finance', ' A remplir', 'A remplir', '0655789644', 'bob@yahoo.fr', 'A remplir', 0, 'A remplir', 'employeFinance', '01-06-22', '27000', '21', '21', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id_login` int(5) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `motDePasse` varchar(100) DEFAULT NULL,
  `fonction` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id_login`, `email`, `motDePasse`, `fonction`) VALUES
(1, 'vendeur@cybercar.com', '30e36724313b7e3d9fff50e3772f769d361ad626fb228662385235a28499f761', 'vendeur'),
(2, 'adminSystem@cybercar.com', '-48d96d33c54c32241a109efc542c1ac08a74f2c6bc4a77923f11eb47dddf9667', 'adminSystem'),
(3, 'employeRH@cybercar.com', '-3c9c2fb35e16dfb2d7be2aa35e84fded75ee0f0a36169fadd051631d78a0fee8', 'employeRH'),
(4, 'garagiste@cybercar.com', '5e0680057960895ffdd0ef2243a5ecff4211d3ed4e93441163438aee62adb3fa', 'garagiste'),
(5, 'employeFinance@cybercar.com', '-4c1b2d48cfa3bba27b0f4df771b5f30b7aa11471a08d029f31107066d64f8c39', 'employeFinance'),
(6, 'employeSI@cybercar.com', '637e4a6e7de2542401e758538e65b4679c80b631a37a3b5f8ccbe18eb696f924', 'employeSI'),
(7, 'nouveau@cybercar.com', '3f030f77f686eb0629b77dc4664a6d5ecf2d53b55457f8cac46ef68853872b43', 'employeFinance');

-- --------------------------------------------------------

--
-- Table structure for table `voiture`
--

CREATE TABLE `voiture` (
  `id_voiture` int(5) NOT NULL,
  `Marque` varchar(25) DEFAULT NULL,
  `Modèle` varchar(25) DEFAULT NULL,
  `Couleur` varchar(25) DEFAULT NULL,
  `Année_de_production` int(5) DEFAULT NULL,
  `Transmission` varchar(20) DEFAULT NULL,
  `Type_de_carburant` varchar(20) DEFAULT NULL,
  `Date_de_livraison` varchar(20) DEFAULT NULL,
  `Pays_de_provenance` varchar(20) DEFAULT NULL,
  `Prix` varchar(20) DEFAULT NULL,
  `Entrepôt` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id_employé`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_login`);

--
-- Indexes for table `voiture`
--
ALTER TABLE `voiture`
  ADD PRIMARY KEY (`id_voiture`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `employe`
--
ALTER TABLE `employe`
  MODIFY `id_employé` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id_login` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `voiture`
--
ALTER TABLE `voiture`
  MODIFY `id_voiture` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
