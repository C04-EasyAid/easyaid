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
  CONSTRAINT `studente` FOREIGN KEY (`studente`) REFERENCES `studente` (`email_studente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutore` FOREIGN KEY (`tutor`) REFERENCES `tutor` (`email_tutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commento`
--

LOCK TABLES `commento` WRITE;
/*!40000 ALTER TABLE `commento` DISABLE KEYS */;
INSERT INTO `commento` VALUES (13,11,18,'Va bene, ci sarò!','2021-07-14','10:00','fneri34@studenti.unisa.it','mdibianco45@studenti.unisa.it'),(14,12,14,'Ok, perfetto!','2021-12-01','12:00','marcoverdi4@studenti.unisa.it','adebiase41@studenti.unisa.it'),(15,13,21,'Non ci sono problemi!','2021-11-12','10:00','cderio22@studenti.unisa.it','saracapriotti55@studenti.unisa.it'),(16,14,19,'Ci sarò sicuramente!','2021-11-29','9:00','paolorossi10@studenti.unisa.it','paoloserrati23@studenti.unisa.it'),(17,16,22,'Ti avviserò se dovessi avere dei problemi!','2021-10-03','15:55','paolorossi10@studenti.unisa.it','paoloserrati23@studenti.unisa.it'),(18,16,22,'Tutto confermato!','2021-10-05','8:00','paolorossi10@studenti.unisa.it','paoloserrati23@studenti.unisa.it');
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
  `luogo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `e-mail_idx` (`tutor`),
  KEY `id_idx` (`tutorato`),
  KEY `idtutorato_didattico_idx` (`tutorato`),
  CONSTRAINT `idtutorato_didattico` FOREIGN KEY (`tutorato`) REFERENCES `tutorato_didattico` (`idtutorato_didattico`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutor` FOREIGN KEY (`tutor`) REFERENCES `tutorato_didattico` (`tutor_email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lezione`
--

LOCK TABLES `lezione` WRITE;
/*!40000 ALTER TABLE `lezione` DISABLE KEYS */;
INSERT INTO `lezione` VALUES (11,18,'10:00','12:00','2021-07-15','mdibianco45@studenti.unisa.it',1,''),(12,14,'16:30','18:30','2021-12-02','adebiase41@studenti.unisa.it',2,''),(13,21,'10:00','12:00','2021-11-13','saracapriotti55@studenti.unisa.it',3,''),(14,19,'11:00','13:00','2021-11-30','paoloserrati23@studenti.unisa.it',3,''),(15,15,'16:30','18:30','2021-09-29','lorenzorossi1@studenti.unisa.it',0,''),(16,22,'9:00','11:00','2021-10-05','paoloserrati23@studenti.unisa.it',1,''),(17,23,'15:00','17:00','2021-10-12','paoloserrati23@studenti.unisa.it',1,''),(18,24,'16:00','18:00','2021-10-11','paoloserrati23@studenti.unisa.it',1,'');
/*!40000 ALTER TABLE `lezione` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `personale_amministrativo`
--

LOCK TABLES `personale_amministrativo` WRITE;
/*!40000 ALTER TABLE `personale_amministrativo` DISABLE KEYS */;
INSERT INTO `personale_amministrativo` VALUES ('cgigli91@unisa.it'),('gfalchi67@unisa.it'),('gstorti67@unisa.it'),('paoloneri45@unisa.it');
/*!40000 ALTER TABLE `personale_amministrativo` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `professore_referente`
--

LOCK TABLES `professore_referente` WRITE;
/*!40000 ALTER TABLE `professore_referente` DISABLE KEYS */;
INSERT INTO `professore_referente` VALUES ('adevito11@unisa.it','fisica'),('dbelli01@unisa.it','informatica'),('gporetti89@unisa.it','farmacia'),('mlamberti78@unisa.it','economia'),('rdistasi@unisa.it','informatica');
/*!40000 ALTER TABLE `professore_referente` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `studente`
--

LOCK TABLES `studente` WRITE;
/*!40000 ALTER TABLE `studente` DISABLE KEYS */;
INSERT INTO `studente` VALUES ('abaglio9@studenti.unisa.it','DSA','dislessia',15,22),('cderio22@studenti.unisa.it','DSA','disgrafia',40,25),('fneri34@studenti.unisa.it','DSA','discalculia',15,14),('marcoverdi4@studenti.unisa.it','disabile','motorie',50,30),('paolorossi10@studenti.unisa.it','DSA','disprassia',20,10);
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supporto_esame`
--

LOCK TABLES `supporto_esame` WRITE;
/*!40000 ALTER TABLE `supporto_esame` DISABLE KEYS */;
INSERT INTO `supporto_esame` VALUES (15,'2021-08-11','10:00',5,'Del vecchio','scritto e orale','nessuno','tutor lettore',2,'Analisi 1','Ti aspetto all edificio E2','Edificio E2 aula e8','economia','fneri34@studenti.unisa.it',NULL,NULL),(16,'2022-01-18','9:30',3,'Ferrucci','scritto','tempo aggiuntivo','tutor scrittore',3,'Ingegneria del Software','Ci vediamo alle 9:30!','Edificio F3 aula p4','informatica','marcoverdi4@studenti.unisa.it','lorenzorossi1@studenti.unisa.it',NULL),(17,'2021-12-01','18:00',3,'Romano','scritto e orale','nessuno','tutor scrittore',0,'Grafica ed interattività',NULL,'Edificio F3 aula p20','informatica','paolorossi10@studenti.unisa.it',NULL,NULL),(18,'2021-10-05','15:00',8,'Gaeta','scritto ','tempo aggiuntivo','tutor lettore',3,'Probabilità e statistica','Ci vediamo alle 15!','Edificio F3 aula p18','informatica','abaglio9@studenti.unisa.it','adebiase41@studenti.unisa.it','mlamberti78@unisa.it'),(19,'2021-11-12','12:00',6,'Balestra','scritto','tempo aggiuntivo','tutor scrittore',3,'Reti di calcolatori','Ci vediamo giovedì!','Edificio F2 aula p5','informatica','cderio22@studenti.unisa.it','saracapriotti55@studenti.unisa.it','dbelli01@unisa.it');
/*!40000 ALTER TABLE `supporto_esame` ENABLE KEYS */;
UNLOCK TABLES;

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
  `ore disponibili` int(11) NOT NULL,
  PRIMARY KEY (`email_tutor`),
  CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`email_tutor`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES ('adebiase41@studenti.unisa.it','informatica','Laurea Triennale',10,30),('lorenzorossi1@studenti.unisa.it','informatica','Laurea Triennale',3,17),('mdibianco45@studenti.unisa.it','economia','Laurea Triennale',0,20),('paoloserrati23@studenti.unisa.it','informatica','Laurea Triennale',2,30),('saracapriotti55@studenti.unisa.it','informatica','Laurea Triennale',2,25);
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
  `docente` varchar(100) NOT NULL,
  PRIMARY KEY (`idtutorato_didattico`),
  KEY `e-mail_idx` (`studente_email`),
  KEY `e-mail_tutor_idx` (`tutor_email`),
  KEY `e-mail_prof_refe_idx` (`prof_refe_email`),
  CONSTRAINT `e-mail_prof_refe` FOREIGN KEY (`prof_refe_email`) REFERENCES `professore_referente` (`email_prof_refe`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e-mail_studente` FOREIGN KEY (`studente_email`) REFERENCES `studente` (`email_studente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e-mail_tutor` FOREIGN KEY (`tutor_email`) REFERENCES `tutor` (`email_tutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutorato_didattico`
--

LOCK TABLES `tutorato_didattico` WRITE;
/*!40000 ALTER TABLE `tutorato_didattico` DISABLE KEYS */;
INSERT INTO `tutorato_didattico` VALUES (14,'Lunedì,Martedì','Lunedì:16:30,Martedì:17:30',7,NULL,2,'Reti di calcolatori','informatica','marcoverdi4@studenti.unisa.it','adebiase41@studenti.unisa.it',NULL,''),(15,'Mercoledì,Giovedì','Mercoledì:16:30,Giovedì:09:30',4,'Ci vediamo mercoledì!',0,'Programmazione 1','informatica','abaglio9@studenti.unisa.it','lorenzorossi1@studenti.unisa.it',NULL,''),(18,'Giovedì,Venerdì','Giovedì:10:00,Venerdì:14:00',10,'D\'accordo!',1,'Sistemi operativi','informatica','fneri34@studenti.unisa.it','mdibianco45@studenti.unisa.it',NULL,''),(19,'Lunedì,Venerdì','Lunedì: 9:00,Venerdì: 11:00',8,'Ci vediamo venerdì mattina!',3,'Matematica discreta','informatica','paolorossi10@studenti.unisa.it','paoloserrati23@studenti.unisa.it','gporetti89@unisa.it',''),(21,'Lunedì,Giovedì','Lunedì: 10:00,Giovedì: 13:30',9,'Tutto confermato!',3,'Fisica','fisica','cderio22@studenti.unisa.it','saracapriotti55@studenti.unisa.it','adevito11@unisa.it',''),(22,'Martedì,Venerdì','Martedì: 9:00, Venerdì:11:30',5,'Perfetto!',1,'Grafica ed interattività','informatica','paolorossi10@studenti.unisa.it','paoloserrati23@studenti.unisa.it',NULL,''),(23,'Martedì, Mercoledì','Martedì: 15:00, Mercoledì: 9:00',4,'Non ci sono problemi!',1,'Programmazione OO','informatica','paolorossi10@studenti.unisa.it','paoloserrati23@studenti.unisa.it',NULL,''),(24,'Lunedì, Mercoledì','Lunedì: 16:00,Giovedì: 15:30',6,'Ci vediamo la settimana prossima!',1,'Reti di calcolatori','informatica','paolorossi10@studenti.unisa.it','paoloserrati23@studenti.unisa.it',NULL,'');
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
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `ruolo` varchar(100) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('Aldo','Baglio','abaglio9@studenti.unisa.it','839801b3f35880844d9b78264a2ec0c61c9105b6','S'),('Antonio','De Biase','adebiase41@studenti.unisa.it','f19aa987f101ddd8259f66d662240effd8531da5','T'),('Aldo','De Vito','adevito11@unisa.it','cb11a9011ef03a1d1e04113dd014daf76094d1fc','P'),('Carlotta','De Rio','cderio22@studenti.unisa.it','647d1444268ecb94760c9a1a40c5567232641d72','S'),('Carla','Gigli','cgigli91@unisa.it','45c12593547b0593efd909e8e86019f53f6bb405','PA'),('Dario','Belli','dbelli01@unisa.it','d1dece9ec9d5d36e9d249f574e29f965c2ca46ec','P'),('Francesco','Neri','fneri34@studenti.unisa.it','9f96a0aee93f7f0f422dfb8659a08c79a29f8f11','S'),('Giuseppe','Falchi','gfalchi67@unisa.it','77f55bfcbd6c7e771f49ba420ae8513cc5ecb53d','PA'),('Giacomo','Poretti','gporetti89@unisa.it','85e50b92eddaec97e90f217f32059ec3268b72bb','P'),('Giovanni','Storti','gstorti67@unisa.it','6f46aefba6fc38682ae44f8975478662ed5b124a','PA'),('Lorenzo','Rossi','lorenzorossi1@studenti.unisa.it','3c3d48a726baf8c1238e000ba85bb68a591ae98d','T'),('Marco','Verdi','marcoverdi4@studenti.unisa.it','c684e7a333ffc50b6f7c44c536c9711a9eedd29e','S'),('Marco','Di Bianco','mdibianco45@studenti.unisa.it','5de0fc381e87539dfdd6ed2b1105cb687a80586a','T'),('Maurizio','lamberti','mlamberti78@unisa.it','d7952100cc8f77d6dc2b0884d594f0a3f7312f95','P'),('Paolo','Neri','paoloneri45@unisa.it','9ea6e8310c462e6d8ff3af2ac929aebbbc64c9a2','PA'),('Paolo','Rossi','paolorossi10@studenti.unisa.it','c4c564dde0858e4e2dc937e8bc581b19ca693fb5','S'),('Paolo','Serrati','paoloserrati23@studenti.unisa.it','d92ea20bbc0faf2e5a55f30dcbabb3de15e2b1b5','T'),('Riccardo','Distasi','rdistasi@unisa.it','9cf5b6bd570657464275ced548fcdb65f134cc9d','P'),('Sara','Capriotti','saracapriotti55@studenti.unisa.it','ec8f631e4738440b7d091088dea0e80c207de0d2','T');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-10 21:59:35
