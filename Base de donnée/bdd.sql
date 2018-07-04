-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: projetevenement
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomCategorie` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'cinema'),(2,'theatre'),(3,'exterieur'),(4,'interieur'),(5,'musique'),(6,'expo'),(7,'enfant'),(8,'gratuit');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evenement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `utilisateur_id` int(11) NOT NULL,
  `Adresse` varchar(250) NOT NULL,
  `validation` tinyint(4) NOT NULL DEFAULT '0',
  `nom` varchar(45) NOT NULL,
  `tarif` decimal(10,2) NOT NULL,
  `evenementSupr` varchar(45) NOT NULL DEFAULT '1',
  `dateDebut` datetime NOT NULL,
  `dateFin` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_evenement_utilisateur_idx` (`utilisateur_id`),
  CONSTRAINT `fk_evenement_utilisateur` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evenement`
--

LOCK TABLES `evenement` WRITE;
/*!40000 ALTER TABLE `evenement` DISABLE KEYS */;
INSERT INTO `evenement` VALUES (1,2,'Boulevard Vauban 59000 Lille',1,'Jardin Vauban',0.00,'','2018-06-12 10:00:00','2018-06-13 11:00:00'),(2,1,'18 Bis Rue de Valmy, 59000 Lille',1,'Palais des beaux-arts de Lille',0.00,'','2018-06-15 08:00:00','2018-06-16 10:00:00'),(3,3,'40 Rue de Béthune, 59800 Lille',1,'UGC Ciné Cité Lille',10.00,'','2018-06-20 10:00:00','2018-06-20 12:00:00'),(4,2,'17 Boulevard Jean-Baptiste Lebas, 59800 Lille',1,'Gare de Lille-Saint-Sauveur',0.00,'','2018-07-01 20:00:00','2018-07-01 21:00:00'),(5,2,'59800',1,'Beffroi de Lille',0.00,'','2018-06-28 15:00:00','2018-06-28 16:00:00');
/*!40000 ALTER TABLE `evenement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evenement_categorie`
--

DROP TABLE IF EXISTS `evenement_categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evenement_categorie` (
  `evenement_id` int(11) NOT NULL,
  `categorie_id` int(11) NOT NULL,
  PRIMARY KEY (`evenement_id`,`categorie_id`),
  KEY `fk_evenement_has_categorie_categorie1_idx` (`categorie_id`),
  KEY `fk_evenement_has_categorie_evenement1_idx` (`evenement_id`),
  CONSTRAINT `fk_evenement_has_categorie_categorie1` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_has_categorie_evenement1` FOREIGN KEY (`evenement_id`) REFERENCES `evenement` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evenement_categorie`
--

LOCK TABLES `evenement_categorie` WRITE;
/*!40000 ALTER TABLE `evenement_categorie` DISABLE KEYS */;
INSERT INTO `evenement_categorie` VALUES (1,2),(2,2),(3,2),(1,3),(3,4),(1,5);
/*!40000 ALTER TABLE `evenement_categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evenement_ressource`
--

DROP TABLE IF EXISTS `evenement_ressource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evenement_ressource` (
  `evenement_id` int(11) NOT NULL,
  `ressource_id` int(11) NOT NULL,
  PRIMARY KEY (`evenement_id`,`ressource_id`),
  KEY `fk_evenement_has_ressource_ressource1_idx` (`ressource_id`),
  KEY `fk_evenement_has_ressource_evenement1_idx` (`evenement_id`),
  CONSTRAINT `fk_evenement_has_ressource_evenement1` FOREIGN KEY (`evenement_id`) REFERENCES `evenement` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_has_ressource_ressource1` FOREIGN KEY (`ressource_id`) REFERENCES `ressource` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evenement_ressource`
--

LOCK TABLES `evenement_ressource` WRITE;
/*!40000 ALTER TABLE `evenement_ressource` DISABLE KEYS */;
/*!40000 ALTER TABLE `evenement_ressource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evenement_valider_par_utilisateur`
--

DROP TABLE IF EXISTS `evenement_valider_par_utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evenement_valider_par_utilisateur` (
  `evenement_id` int(11) NOT NULL,
  `utilisateur_id` int(11) NOT NULL,
  PRIMARY KEY (`evenement_id`,`utilisateur_id`),
  KEY `fk_evenement_has_utilisateur_utilisateur1_idx` (`utilisateur_id`),
  KEY `fk_evenement_has_utilisateur_evenement1_idx` (`evenement_id`),
  CONSTRAINT `fk_evenement_has_utilisateur_evenement1` FOREIGN KEY (`evenement_id`) REFERENCES `evenement` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_has_utilisateur_utilisateur1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evenement_valider_par_utilisateur`
--

LOCK TABLES `evenement_valider_par_utilisateur` WRITE;
/*!40000 ALTER TABLE `evenement_valider_par_utilisateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `evenement_valider_par_utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ressource`
--

DROP TABLE IF EXISTS `ressource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ressource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ressource`
--

LOCK TABLES `ressource` WRITE;
/*!40000 ALTER TABLE `ressource` DISABLE KEYS */;
/*!40000 ALTER TABLE `ressource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reputation` int(11) NOT NULL DEFAULT '0',
  `nom` varchar(150) NOT NULL,
  `prenom` varchar(150) NOT NULL,
  `pseudonyme` varchar(150) NOT NULL,
  `email` varchar(300) NOT NULL,
  `mot_de_passe` varchar(150) NOT NULL,
  `date_de_naissance` date NOT NULL,
  `utilisateurSupr` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,5,'Diot','Cedric','cediot','cediot@ici.fr','toto','1984-06-05',1),(2,3,'Lebrun','jerome','jebrun','jebrun@ici.fr','toto','1989-09-12',1),(3,5,'Lecocq','Florian','flo','florian-lc@ici.fr','tata','1994-07-02',1),(4,3,'Legrand','Gerard','gege','gegedu59@ici.fr','titi','1959-02-02',1),(5,1,'Terieur','Alain','Alterr','alain.terieur@ici.fr','tutu','1982-12-07',1);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur_participe_evenement`
--

DROP TABLE IF EXISTS `utilisateur_participe_evenement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur_participe_evenement` (
  `utilisateur_id` int(11) NOT NULL,
  `evenement_id` int(11) NOT NULL,
  PRIMARY KEY (`utilisateur_id`,`evenement_id`),
  KEY `fk_utilisateur_has_evenement_evenement1_idx` (`evenement_id`),
  KEY `fk_utilisateur_has_evenement_utilisateur1_idx` (`utilisateur_id`),
  CONSTRAINT `fk_utilisateur_has_evenement_evenement1` FOREIGN KEY (`evenement_id`) REFERENCES `evenement` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_utilisateur_has_evenement_utilisateur1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur_participe_evenement`
--

LOCK TABLES `utilisateur_participe_evenement` WRITE;
/*!40000 ALTER TABLE `utilisateur_participe_evenement` DISABLE KEYS */;
/*!40000 ALTER TABLE `utilisateur_participe_evenement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-04  9:45:56
