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
-- Table structure for table `application.v2`
--

DROP TABLE IF EXISTS `application.v2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application.v2` (
  `ApplicationID` int NOT NULL AUTO_INCREMENT,
  `ApplicationType` varchar(45) DEFAULT NULL,
  `AppointDate` date DEFAULT NULL,
  `AppointTime` varchar(45) DEFAULT NULL,
  `AppointPlace` varchar(45) DEFAULT NULL,
  `AppointStatus` varchar(45) DEFAULT NULL,
  `ClientID` int DEFAULT NULL,
  `PetID` int DEFAULT NULL,
  `VetID` int DEFAULT NULL,
  PRIMARY KEY (`ApplicationID`),
  KEY `PetID_idx` (`PetID`),
  KEY `VetID_idx` (`VetID`),
  KEY `ClientID_idx` (`ClientID`),
  CONSTRAINT `ClientID` FOREIGN KEY (`ClientID`) REFERENCES `client.v2` (`ClientID`),
  CONSTRAINT `PetID` FOREIGN KEY (`PetID`) REFERENCES `pet.v2` (`PetID`),
  CONSTRAINT `VetID` FOREIGN KEY (`VetID`) REFERENCES `vet.v2` (`VetID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application.v2`
--

LOCK TABLES `application.v2` WRITE;
/*!40000 ALTER TABLE `application.v2` DISABLE KEYS */;
INSERT INTO `application.v2` VALUES (1,'R','2024-06-04','08:30:00','Vet Clinic','S',1,5,1),(2,'R','2024-03-30','10:30:00','Vet Clinic','S',2,3,3),(3,'R','2024-04-12','12:00:00','Vet Clinic','S',3,2,3),(4,'A','2024-04-19','15:00:00','Vet Clinic','S',4,1,1),(5,'A','2024-04-25','16:00:00','Vet Clinic','S',4,2,1),(6,'A','2024-04-02','17:00:00','Vet Clinic','C',4,3,1),(7,'A','2024-04-19','15:00:00','Vet Clinic','C',4,4,1),(8,'A','2024-06-23','13:00:00','Vet Clinic','S',5,5,2),(9,'A','2024-06-23','13:30:00','Vet Clinic','P',5,6,2),(10,'R','2024-07-23','09:30:00','Vet Clinic','S',5,7,2),(11,'R','2024-07-07','01:51:00','Vet Clinic','S',4,8,4),(20,'R','2024-07-09','10:00:00','Vet Clinic','P',1,45,4),(22,'A','2024-07-09','12:00:00','Vet Clinic','S',1,4,4),(23,'R','2024-07-09','13:00:00','Vet Clinic','P',1,47,4),(24,'A','2024-07-09','14:00:00','Vet Clinic','S',1,11,4),(25,'A','2024-07-09','16:00:00','Vet Clinic','C',1,9,4),(26,'A','2024-07-09','15:00:00','Vet Clinic','C',1,6,4),(28,'A','2024-07-09','15:00:00','Vet Clinic','P',1,10,4);
/*!40000 ALTER TABLE `application.v2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-12  2:28:38
