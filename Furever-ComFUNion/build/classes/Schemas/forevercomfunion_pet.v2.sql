-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: forevercomfunion
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `pet.v2`
--

DROP TABLE IF EXISTS `pet.v2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet.v2` (
  `PetID` int NOT NULL AUTO_INCREMENT,
  `PetType` varchar(45) DEFAULT NULL,
  `PetOrigin` varchar(45) DEFAULT NULL,
  `PetStatus` varchar(45) DEFAULT NULL,
  `PetSize` varchar(45) DEFAULT NULL,
  `PetAge` varchar(45) DEFAULT NULL,
  `PetName` varchar(45) DEFAULT NULL,
  `PetSex` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PetID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet.v2`
--

LOCK TABLES `pet.v2` WRITE;
/*!40000 ALTER TABLE `pet.v2` DISABLE KEYS */;
INSERT INTO `pet.v2` VALUES (1,'Dog','R','A','M','2 months','Raphael','M'),(2,'Cat','O','A','L','9 months','Juswa','M'),(3,'Dog','O','A','M','7 months','Cooper','M'),(4,'Rabbit','R','A','T','15 months','Adjie','M'),(5,'Hamster','O','A','T','3 months','Hammy','M'),(6,'Cat','R','A','S','6 months','Gigi','F'),(7,'Dog','O','A','S','4 months','Cassyyy','M'),(8,'Cat','O','NA','M','24 months','Clover','M'),(9,'Hamster','R','NA','T','5 months','Mister','F'),(10,'Hamster','O','NA','S','7 months','Ball','F'),(11,'Cat','R','NA','L','12 months','Bella','F'),(12,'Dog','R','NA','S','5 months','Charlie','M'),(13,'Rabbit','O','NA','T','8 months','Lola','F'),(14,'Hamster','R','NA','T','4 months','Nibbles','M'),(15,'Cat','O','NA','M','7 months','Simba','M'),(16,'Dog','O','NA','L','9 months','Buddy','M'),(17,'Rabbit','R','NA','T','6 months','Thumper','F'),(18,'Hamster','O','NA','T','2 months','Squeaky','M'),(19,'Cat','R','NA','S','11 months','Luna','F'),(20,'Dog','O','NA','M','3 months','Rocky','M'),(21,'Rabbit','R','NA','T','13 months','Coco','F'),(22,'Hamster','O','NA','T','1 month','Tiny','F'),(23,'Cat','R','NA','M','18 months','Oliver','M'),(24,'Dog','O','NA','S','6 months','Duke','M'),(25,'Rabbit','R','NA','T','7 months','Bunny','F'),(26,'Hamster','O','NA','T','9 months','Fuzzball','M'),(27,'Cat','R','NA','L','10 months','Milo','M'),(28,'Dog','O','NA','M','4 months','Bailey','F'),(29,'Rabbit','R','NA','T','5 months','Peanut','M'),(30,'Hamster','O','NA','T','6 months','Whiskers','F'),(31,'Cat','R','NA','M','8 months','Chloe','F'),(32,'Dog','O','NA','L','7 months','Zeus','M'),(33,'Rabbit','R','NA','T','12 months','Fluffy','F'),(34,'Hamster','O','NA','T','3 months','Pip','M'),(35,'Cat','R','NA','M','14 months','Tiger','M'),(36,'Dog','O','NA','S','9 months','Oreo','F'),(37,'Rabbit','R','NA','T','2 months','Bambi','F'),(38,'Hamster','O','NA','T','5 months','Chewy','M'),(39,'Cat','R','NA','L','13 months','Lucy','F'),(40,'Dog','O','NA','M','11 months','Jack','M');
/*!40000 ALTER TABLE `pet.v2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-08 17:46:34
