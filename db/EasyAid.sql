CREATE DATABASE  IF NOT EXISTS `easyaid` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `easyaid`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: easyaid
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `commento`
--

DROP TABLE IF EXISTS `commento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lezione` int(11) NOT NULL,
  `tutorato` int(11) NOT NULL,
  `testo` varchar(250) NOT NULL,
  `data` date NOT NULL,
  `ora` varchar(100) NOT NULL,
  `studente` varchar(100) DEFAULT NULL,
  `tutor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`lezione`,`tutorato`),
  KEY `idlezione_idx` (`lezione`),
  KEY `idtutorato_idx` (`tutorato`),
  KEY `e-mail_studente_idx` (`studente`),
  KEY `e-mail_tutor_idx` (`tutor`),
  CONSTRAINT `idlezione` FOREIGN KEY (`lezione`) REFERENCES `lezione` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idtutorato` FOREIGN KEY (`tutorato`) REFERENCES `lezione` (`tutorato`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studente` FOREIGN KEY (`studente`) REFERENCES `studente` (`email_studente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutore` FOREIGN KEY (`tutor`) REFERENCES `tutor` (`email_tutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lezione`
--

DROP TABLE IF EXISTS `lezione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lezione` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tutorato` int(11) NOT NULL,
  `ora_inizio` varchar(100) NOT NULL,
  `ora_fine` varchar(100) NOT NULL,
  `data` date NOT NULL,
  `tutor` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `luogo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `e-mail_idx` (`tutor`),
  KEY `id_idx` (`tutorato`),
  KEY `idtutorato_didattico_idx` (`tutorato`),
  CONSTRAINT `idtutorato_didattico` FOREIGN KEY (`tutorato`) REFERENCES `tutorato_didattico` (`idtutorato_didattico`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutor` FOREIGN KEY (`tutor`) REFERENCES `tutorato_didattico` (`tutor_email`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `personale_amministrativo`
--

DROP TABLE IF EXISTS `personale_amministrativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personale_amministrativo` (
  `email_pers_admin` varchar(100) NOT NULL,
  PRIMARY KEY (`email_pers_admin`),
  CONSTRAINT `personale_amministrativo_ibfk_1` FOREIGN KEY (`email_pers_admin`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `professore_referente`
--

DROP TABLE IF EXISTS `professore_referente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professore_referente` (
  `email_prof_refe` varchar(100) NOT NULL,
  `dipartimento` varchar(100) NOT NULL,
  PRIMARY KEY (`email_prof_refe`),
  KEY `email_idx` (`email_prof_refe`),
  CONSTRAINT `e-mail` FOREIGN KEY (`email_prof_refe`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `studente`
--

DROP TABLE IF EXISTS `studente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studente` (
  `email_studente` varchar(100) NOT NULL,
  `tipo_di_disabilita` varchar(100) NOT NULL,
  `specifiche_disturbo` varchar(100) DEFAULT NULL,
  `percentuale_disabilita` int(11) DEFAULT NULL,
  `ore_disponibili` int(11) NOT NULL,
  PRIMARY KEY (`email_studente`),
  KEY `email_idx` (`email_studente`),
  CONSTRAINT `email` FOREIGN KEY (`email_studente`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `supporto_esame`
--

DROP TABLE IF EXISTS `supporto_esame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supporto_esame` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `ora` varchar(45) NOT NULL,
  `ore_richieste` int(11) NOT NULL,
  `docente` varchar(100) NOT NULL,
  `modalita_esame` varchar(100) NOT NULL,
  `eventuali_ausili` varchar(100) NOT NULL,
  `tipo_di_assistenza` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `insegnamento` varchar(100) NOT NULL,
  `commento` varchar(250) DEFAULT NULL,
  `luogo` varchar(100) NOT NULL,
  `dipartimento` varchar(100) NOT NULL,
  `studente_email` varchar(100) NOT NULL,
  `tutor_email` varchar(100) DEFAULT NULL,
  `prof_refe_email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `e-mail_idx` (`studente_email`),
  KEY `e-mail_tutor_idx` (`tutor_email`),
  KEY `e-mail_prof_refe_idx` (`prof_refe_email`),
  CONSTRAINT `prof_refe_key` FOREIGN KEY (`prof_refe_email`) REFERENCES `professore_referente` (`email_prof_refe`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studente_key` FOREIGN KEY (`studente_email`) REFERENCES `studente` (`email_studente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutor_key` FOREIGN KEY (`tutor_email`) REFERENCES `tutor` (`email_tutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor` (
  `email_tutor` varchar(100) NOT NULL,
  `dipartimento` varchar(100) NOT NULL,
  `qualifica` varchar(100) NOT NULL,
  `ore_svolte` int(11) NOT NULL,
  `ore_disponibili` int(11) NOT NULL,
  PRIMARY KEY (`email_tutor`),
  CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`email_tutor`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tutorato_didattico`
--

DROP TABLE IF EXISTS `tutorato_didattico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutorato_didattico` (
  `idtutorato_didattico` int(11) NOT NULL AUTO_INCREMENT,
  `date_disponibili` varchar(100) NOT NULL,
  `ore_disponibili` varchar(45) NOT NULL,
  `ore_richieste` int(11) NOT NULL,
  `commento` varchar(250) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `insegnamento` varchar(100) NOT NULL,
  `dipartimento` varchar(100) NOT NULL,
  `studente_email` varchar(100) NOT NULL,
  `tutor_email` varchar(100) DEFAULT NULL,
  `prof_refe_email` varchar(100) DEFAULT NULL,
  `docente` varchar(100) NOT NULL,
  PRIMARY KEY (`idtutorato_didattico`),
  KEY `e-mail_idx` (`studente_email`),
  KEY `e-mail_tutor_idx` (`tutor_email`),
  KEY `e-mail_prof_refe_idx` (`prof_refe_email`),
  CONSTRAINT `e-mail_prof_refe` FOREIGN KEY (`prof_refe_email`) REFERENCES `professore_referente` (`email_prof_refe`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e-mail_studente` FOREIGN KEY (`studente_email`) REFERENCES `studente` (`email_studente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e-mail_tutor` FOREIGN KEY (`tutor_email`) REFERENCES `tutor` (`email_tutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `ruolo` varchar(100) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'easyaid'
--

--
-- Dumping routines for database 'easyaid'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-20 20:39:51
