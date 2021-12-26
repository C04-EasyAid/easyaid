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
  `studente` varchar(100) NOT NULL,
  `tutor` varchar(100) NOT NULL,
  PRIMARY KEY (`id`,`lezione`,`tutorato`),
  KEY `idlezione_idx` (`lezione`),
  KEY `idtutorato_idx` (`tutorato`),
  KEY `e-mail_studente_idx` (`studente`),
  KEY `e-mail_tutor_idx` (`tutor`),
  CONSTRAINT `idlezione` FOREIGN KEY (`lezione`) REFERENCES `lezione` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idtutorato` FOREIGN KEY (`tutorato`) REFERENCES `lezione` (`tutorato`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studente` FOREIGN KEY (`studente`) REFERENCES `studente` (`e-mail_studente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutore` FOREIGN KEY (`tutor`) REFERENCES `tutor` (`e-mail_tutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commento`
--

LOCK TABLES `commento` WRITE;
/*!40000 ALTER TABLE `commento` DISABLE KEYS */;
/*!40000 ALTER TABLE `commento` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`),
  KEY `e-mail_idx` (`tutor`),
  KEY `id_idx` (`tutorato`),
  KEY `idtutorato_didattico_idx` (`tutorato`),
  CONSTRAINT `idtutorato_didattico` FOREIGN KEY (`tutorato`) REFERENCES `tutorato_didattico` (`idtutorato_didattico`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutor` FOREIGN KEY (`tutor`) REFERENCES `tutorato_didattico` (`tutor_email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lezione`
--

LOCK TABLES `lezione` WRITE;
/*!40000 ALTER TABLE `lezione` DISABLE KEYS */;
INSERT INTO `lezione` VALUES (5,13,'16:30','18:00','2021-12-15','lorenzorossi1@studenti.unisa.it',1),(6,13,'10:00','12:00','2021-12-16','lorenzorossi1@studenti.unisa.it',1),(7,13,'16:30','18:30','2021-12-22','lorenzorossi1@studenti.unisa.it',0);
/*!40000 ALTER TABLE `lezione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personale_amministrativo`
--

DROP TABLE IF EXISTS `personale_amministrativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personale_amministrativo` (
  `e-mail_pers_admin` varchar(100) NOT NULL,
  PRIMARY KEY (`e-mail_pers_admin`),
  CONSTRAINT `personale_amministrativo_ibfk_1` FOREIGN KEY (`e-mail_pers_admin`) REFERENCES `utente` (`e-mail`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personale_amministrativo`
--

LOCK TABLES `personale_amministrativo` WRITE;
/*!40000 ALTER TABLE `personale_amministrativo` DISABLE KEYS */;
INSERT INTO `personale_amministrativo` VALUES ('gfalchi67@unisa.it'),('gstorti67@unisa.it'),('paoloneri45@unisa.it');
/*!40000 ALTER TABLE `personale_amministrativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professore_referente`
--

DROP TABLE IF EXISTS `professore_referente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professore_referente` (
  `e-mail_prof_refe` varchar(100) NOT NULL,
  `dipartimento` varchar(100) NOT NULL,
  PRIMARY KEY (`e-mail_prof_refe`),
  KEY `email_idx` (`e-mail_prof_refe`),
  CONSTRAINT `e-mail` FOREIGN KEY (`e-mail_prof_refe`) REFERENCES `utente` (`e-mail`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professore_referente`
--

LOCK TABLES `professore_referente` WRITE;
/*!40000 ALTER TABLE `professore_referente` DISABLE KEYS */;
INSERT INTO `professore_referente` VALUES ('gporetti89@unisa.it','farmacia'),('mlamberti78@unisa.it','economia'),('rdistasi@unisa.it','informatica');
/*!40000 ALTER TABLE `professore_referente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studente`
--

DROP TABLE IF EXISTS `studente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studente` (
  `e-mail_studente` varchar(100) NOT NULL,
  `tipo_di_disabilità` varchar(100) NOT NULL,
  `specifiche_disturbo` varchar(100) DEFAULT NULL,
  `percentuale_disabilità` int(11) DEFAULT NULL,
  `ore_disponibili` int(11) NOT NULL,
  PRIMARY KEY (`e-mail_studente`),
  KEY `email_idx` (`e-mail_studente`),
  CONSTRAINT `email` FOREIGN KEY (`e-mail_studente`) REFERENCES `utente` (`e-mail`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studente`
--

LOCK TABLES `studente` WRITE;
/*!40000 ALTER TABLE `studente` DISABLE KEYS */;
INSERT INTO `studente` VALUES ('abaglio9@studenti.unisa.it','DSA','dislessia',15,22),('fneri34@studenti.unisa.it','DSA','discalculia',15,14),('marcoverdi4@studenti.unisa.it','disabile','motorie',50,30);
/*!40000 ALTER TABLE `studente` ENABLE KEYS */;
UNLOCK TABLES;

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
  `modalità_esame` varchar(100) NOT NULL,
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
  CONSTRAINT `prof_refe_key` FOREIGN KEY (`prof_refe_email`) REFERENCES `professore_referente` (`e-mail_prof_refe`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studente_key` FOREIGN KEY (`studente_email`) REFERENCES `studente` (`e-mail_studente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutor_key` FOREIGN KEY (`tutor_email`) REFERENCES `tutor` (`e-mail_tutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supporto_esame`
--

LOCK TABLES `supporto_esame` WRITE;
/*!40000 ALTER TABLE `supporto_esame` DISABLE KEYS */;
INSERT INTO `supporto_esame` VALUES (13,'2021-08-11','10:00',5,'del vecchio','scritto e orale','nessuno','tutor lettore',2,'Analisi 1','Ti aspetto all edificio E2','Edificio E2 aula e8','economia','fneri34@studenti.unisa.it',NULL,NULL),(14,'2022-01-18','9:30',3,'ferrucci','scritto','tempo aggiuntivo','tutor scrittore',0,'Ingegneria del Software','','Edificio F3 aula p4','informatica','marcoverdi4@studenti.unisa.it',NULL,NULL);
/*!40000 ALTER TABLE `supporto_esame` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor` (
  `e-mail_tutor` varchar(100) NOT NULL,
  `dipartimento` varchar(100) NOT NULL,
  `qualifica` varchar(100) NOT NULL,
  `ore_svolte` int(11) NOT NULL,
  `ore disponibili` int(11) NOT NULL,
  PRIMARY KEY (`e-mail_tutor`),
  CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`e-mail_tutor`) REFERENCES `utente` (`e-mail`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES ('lorenzorossi1@studenti.unisa.it','informatica','Laurea Triennale',3,17),('mdibianco45@studenti.unisa.it','economia','Laurea Triennale',0,20),('paoloserrati23@studenti.unisa.it','informatica','Laurea Triennale',16,4);
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`idtutorato_didattico`),
  KEY `e-mail_idx` (`studente_email`),
  KEY `e-mail_tutor_idx` (`tutor_email`),
  KEY `e-mail_prof_refe_idx` (`prof_refe_email`),
  CONSTRAINT `e-mail_prof_refe` FOREIGN KEY (`prof_refe_email`) REFERENCES `professore_referente` (`e-mail_prof_refe`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e-mail_studente` FOREIGN KEY (`studente_email`) REFERENCES `studente` (`e-mail_studente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e-mail_tutor` FOREIGN KEY (`tutor_email`) REFERENCES `tutor` (`e-mail_tutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutorato_didattico`
--

LOCK TABLES `tutorato_didattico` WRITE;
/*!40000 ALTER TABLE `tutorato_didattico` DISABLE KEYS */;
INSERT INTO `tutorato_didattico` VALUES (12,'Lunedì,Martedì','Lunedì:16:30,Martedì:17:30',7,NULL,0,'Reti di calcolatori','Informatica','marcoverdi4@studenti.unisa.it',NULL,NULL),(13,'Mercoledì,Giovedì','Mercoledì:16:30,Giovedì:09:30',4,'Ci vediamo mercoledì!',1,'Programmazione 1','Informatica','abaglio9@studenti.unisa.it','lorenzorossi1@studenti.unisa.it',NULL);
/*!40000 ALTER TABLE `tutorato_didattico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  `e-mail` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `ruolo` varchar(100) NOT NULL,
  PRIMARY KEY (`e-mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('Aldo','Baglio','abaglio9@studenti.unisa.it','Aldo#Baglio45','S'),('Francesco','Neri','fneri34@studenti.unisa.it','Franc3#Ner154','S'),('Giuseppe','Falchi','gfalchi67@unisa.it','Giu@Falchi895','PA'),('Giacomo','Poretti','gporetti89@unisa.it','G#Poretti9083','P'),('Giovanni','Storti','gstorti67@unisa.it','Gio#Storti786','PA'),('Lorenzo','Rossi','lorenzorossi1@studenti.unisa.it','Lorenzo#rossi1','T'),('Marco','Verdi','marcoverdi4@studenti.unisa.it','Mark#Verdi45','S'),('Marco','Di Bianco','mdibianco45@studenti.unisa.it','MarcoD#B1anc0','T'),('Maurizio','lamberti','mlamberti78@unisa.it','M#Lamberti890','P'),('Paolo','Neri','paoloneri45@unisa.it','Paolo#Neri892','PA'),('Paolo','Serrati','paoloserrati23@studenti.unisa.it','Paolo#Serrati23','T'),('Riccardo','Distasi','rdistasi@unisa.it','R#Distasi#908','P');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2021-12-22 18:28:49
