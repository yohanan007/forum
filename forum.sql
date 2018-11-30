-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 16, 2018 at 10:49 AM
-- Server version: 5.7.21
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
-- Database: `forum`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(50) NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `categorie`) VALUES
(1, 'gueguerre'),
(2, 'national '),
(3, 'etranger'),
(4, 'strategie'),
(5, 'waterloo'),
(6, 'les grands stratege '),
(7, 'armements '),
(8, 'le futur '),
(9, 'histoire '),
(10, 'actualite ');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `id_question` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(50) NOT NULL,
  `date_de_creation` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id_utilisateur` int(11) NOT NULL,
  `id_categorie` int(11) NOT NULL,
  PRIMARY KEY (`id_question`),
  KEY `QUESTION_UTILISATEUR_FK` (`id_utilisateur`),
  KEY `QUESTION_categorie0_FK` (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id_question`, `question`, `date_de_creation`, `id_utilisateur`, `id_categorie`) VALUES
(1, 'pourquoi napoleon etait il petit ', '2018-11-16 08:06:21', 1, 6),
(2, 'qui veut aller au resto ?  ', '2018-11-16 08:10:24', 13, 6),
(3, 'comment poser une question ?  ', '2018-11-16 08:10:24', 15, 2),
(4, 'je cherche un lance missile ?  ', '2018-11-16 08:10:24', 11, 3),
(5, 'que pensez vous de ma question?  ', '2018-11-16 08:10:24', 2, 1),
(6, 'ou est l\'acceuil ', '2018-11-16 08:10:24', 14, 4),
(7, 'pourquoi napoleon etait il grand  ', '2018-11-16 08:10:24', 11, 5);

-- --------------------------------------------------------

--
-- Table structure for table `reponse`
--

DROP TABLE IF EXISTS `reponse`;
CREATE TABLE IF NOT EXISTS `reponse` (
  `id_reponse` int(11) NOT NULL AUTO_INCREMENT,
  `reponse` text NOT NULL,
  `date_de_post` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id_question` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`id_reponse`),
  KEY `REPONSE_QUESTION_FK` (`id_question`),
  KEY `REPONSE_UTILISATEUR0_FK` (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reponse`
--

INSERT INTO `reponse` (`id_reponse`, `reponse`, `date_de_post`, `id_question`, `id_utilisateur`) VALUES
(1, 'cher ami veuillez prendre un rendez-vous avec un formateur pour repoondre à votre question . d\'ailleurs tous ceci me fait pensez à la fameuse histoire du generald e gaulle lorque il allait se promener aux alentours , finalement cei ets secret d\'etat donc je vous raconterez cela une autre fois ', '2018-11-16 08:18:24', 3, 2),
(2, 'ceci est une honte comment osez faire un sacrilége ainsi est poser une question sur napoleon , le regresser vous serez fusillé !', '2018-11-16 08:18:24', 1, 13),
(3, 'Lorem Elsass ipsum lotto-owe tellus sagittis salu Heineken leo Gal. Verdammi in, messti de Bischheim sed hopla Gal ! libero, barapli wie Richard Schirmeck morbi consectetur  senectus Mauris non amet, suspendisse chambon Chulien tchao bissame Oberschaeffolsheim mollis et pellentesque Christkindelsmärik ullamcorper bredele sed ac Huguette leo mamsell porta yeuh. kuglopf mänele rucksack id geïz météor picon bière Oberschaeffolsheim geht\'s habitant hop Chulia Roberstau flammekueche dignissim tristique ac Carola Hans lacus réchime kougelhopf rhoncus quam. amet sit semper nullam libero. libero, hopla sit tellus purus vulputate DNA, elementum schneck munster schnaps schpeck sit baeckeoffe condimentum gravida Coopé de Truchtersheim ornare Pfourtz ! turpis Miss Dahlias so risus, hoplageiss varius nüdle ftomi! non Salut bisamme Salu bissame quam, wurscht hopla dui commodo Morbi rossbolla ch\'ai id, eleifend knack Strasbourg bissame dolor elit Wurschtsalad vielmols, auctor, gal Kabinetpapier ante adipiscing gewurztraminer Spätzle turpis, leverwurscht und kartoffelsalad s\'guelt Pellentesque aliquam Racing. ornare amet eget merci vielmols knepfle Yo dû. hopla jetz gehts los blottkopf, placerat', '2018-11-16 08:42:36', 2, 11),
(4, 'Lorem Elsass ipsum lotto-owe tellus sagittis salu Heineken leo Gal. Verdammi in, messti de Bischheim sed hopla Gal ! libero, barapli wie Richard Schirmeck morbi consectetur  senectus Mauris non amet, suspendisse chambon Chulien tchao bissame Oberschaeffolsheim mollis et pellentesque Christkindelsmärik ullamcorper bredele sed ac Huguette leo mamsell porta yeuh. kuglopf mänele rucksack id geïz météor picon bière Oberschaeffolsheim geht\'s habitant hop Chulia Roberstau flammekueche dignissim tristique ac Carola Hans lacus réchime kougelhopf rhoncus quam. amet sit semper nullam libero. libero, hopla sit tellus purus vulputate DNA, elementum schneck munster schnaps schpeck sit baeckeoffe condimentum gravida Coopé de Truchtersheim ornare Pfourtz ! turpis Miss Dahlias so risus, hoplageiss varius nüdle ftomi! non Salut bisamme Salu bissame quam, wurscht hopla dui commodo Morbi rossbolla ch\'ai id, eleifend knack Strasbourg bissame dolor elit Wurschtsalad vielmols, auctor, gal Kabinetpapier ante adipiscing gewurztraminer Spätzle turpis, leverwurscht und kartoffelsalad s\'guelt Pellentesque aliquam Racing. ornare amet eget merci vielmols knepfle Yo dû. hopla jetz gehts los blottkopf, placerat', '2018-11-16 08:42:36', 4, 13),
(5, 'Le meilleur moyen de tenir sa parole est de ne jamais la donner.', '2018-11-16 08:42:36', 4, 14),
(6, 'Une belle femme plaît aux yeux, une bonne femme plaît au coeur ; l\'une est un bijou, l\'autre un trésor.', '2018-11-16 08:42:36', 2, 10),
(7, 'Soyez polis envers tous, mais intimes avec peu ; et choisissez-les bien avant de leur faire confiance.', '2018-11-16 08:42:36', 2, 11),
(8, '\r\n\r\n\"Le patriotisme, c\'est aimer son pays. Le nationalisme, c\'est détester celui des autres.\" ', '2018-11-16 08:42:36', 5, 15),
(9, '\r\n\r\n\"Celui qui a l\'honneur de vous parler au nom des Français tient à vous dire que vous leur ressemblez fort.\" ', '2018-11-16 08:42:36', 6, 12),
(10, 'En 1940, le continent européen est en proie à la Seconde Guerre mondiale. Le 10 mai 1940, Winston Churchill succède à Neville Chamberlain. Trois jours plus tard, il prend la parole à la chambre anglaise. Lors de son premier discours, il ne leur promet que sang, larmes, transpiration et fatigue. L\'homme fut élu 62 ans plus tard comme le plus grand Britannique de tous les temps par la BBC. Dire la vérité peut donc se révéler payant.', '2018-11-16 08:42:36', 6, 11),
(11, 'Le 4 juin 1958, au coeur de ce que les Français appelaient encore alors pudiquement les \"troubles d\'Algérie\" mais qui s\'étaient transformé en véritable guerre, le président français se lance dans un discours à Alger. Sa phrase aussi célèbre qu\'ambiguë provoquera des désillusions dans les deux camps. Les accords d\'Evian mettront fin à la guerre d\'Algérie le 18 mars 1962. ', '2018-11-16 08:42:36', 2, 13),
(12, 'Le succès n’est pas ce que vous avez, mais plutôt qui vous êtes. (Bo Bennet)\r\nDe grands accomplissements ont souvent pris naissance par de grands sacrifices, et ce n’est jamais le résultat de l’égoïsme. (Napoleon Hill)\r\nN’essayez pas d’être un homme de succès, mais plutôt un homme de valeur. (Albert Einstein)\r\nLa pensée positive vous permettra de tout faire d’une meilleure façon que la pensée négative. (Zig Ziglar)\r\nLa gratitude n’est pas seulement la plus grande des vertus, mais également le parent de toutes les autres. (Cicero)\r\nJe peux accepter l’échec, tout le monde échoue dans quelque chose. Mais je ne peux accepter de ne pas essayer. (Michael Jordan)\r\nLes leaders ne forcent personne à les suivre, ils les invitent à un voyage. (Charles S. Lauer)\r\nJ’ai plus peur d’une armée de 100 moutons menée par un lion qu’une armée de 100 lions menée par un mouton. (Charles Maurice)', '2018-11-16 08:42:36', 7, 2);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `mot_de_passe` varchar(100) NOT NULL,
  `adresse_email` varchar(50) NOT NULL,
  `date_de_naissance` timestamp NOT NULL,
  `date_inscription` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `nom`, `prenom`, `username`, `mot_de_passe`, `adresse_email`, `date_de_naissance`, `date_inscription`) VALUES
(1, 'kassovitz', 'mathieu', 'utilisateur1', 'motdepasse', 'mathieu@kassovitz.fr', '1981-10-31 23:00:00', '2018-11-16 07:47:18'),
(2, 'lenormand', 'gerard', 'utilisateur2', 'motdepasse', 'lenormand@gerard.fr', '1980-10-31 23:00:00', '2018-11-16 07:54:55'),
(10, 'abrial', 'stephane', 'utilisateur3', 'motdepasse', 'stephane@abrial.fr', '1979-09-30 22:00:00', '2018-11-16 07:57:41'),
(11, 'andre', 'valerie', 'utilisateur4', 'motdepasse', 'valerie@andre.fr', '1978-09-30 22:00:00', '2018-11-16 07:57:41'),
(12, 'des minieres', 'eric bellot', 'utilisateur5', 'motdepasse', 'eric@minieres.fr', '1981-11-10 23:00:00', '2018-11-16 07:57:41'),
(13, 'bentega', 'henri', 'utilisateur6', 'motdepasse', 'henri@bentega.fr', '1979-12-24 23:00:00', '2018-11-16 07:57:41'),
(14, 'marnhac', 'xavier', 'utilisateur7', 'motdepasse', 'xavier@marnhac.fr', '1978-08-31 22:00:00', '2018-11-16 07:57:41'),
(15, 'bosser', 'jean-pierre', 'utilisateur8', 'motdepasse', 'jean@bosser.fr', '1972-05-15 22:00:00', '2018-11-16 07:57:41');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `QUESTION_UTILISATEUR_FK` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`),
  ADD CONSTRAINT `QUESTION_categorie0_FK` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`);

--
-- Constraints for table `reponse`
--
ALTER TABLE `reponse`
  ADD CONSTRAINT `REPONSE_QUESTION_FK` FOREIGN KEY (`id_question`) REFERENCES `question` (`id_question`),
  ADD CONSTRAINT `REPONSE_UTILISATEUR0_FK` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
