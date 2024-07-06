-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: forevercomfunion
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
  `ApplicationID` int NOT NULL,
  `ApplicationType` text,
  `AppointDate` date DEFAULT NULL,
  `AppointTime` text,
  `AppointPlace` text,
  `AppointStatus` text,
  `ClientID` int DEFAULT NULL,
  `PetID` varchar(4) DEFAULT NULL,
  `VetID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`ApplicationID`),
  KEY `ClienID_idx` (`ClientID`),
  KEY `PetID_idx` (`PetID`),
  KEY `VetID_idx` (`VetID`),
  CONSTRAINT `ClienID` FOREIGN KEY (`ClientID`) REFERENCES `client.v2` (`ClientID`),
  CONSTRAINT `PetID` FOREIGN KEY (`PetID`) REFERENCES `pet.v2` (`PetID`),
  CONSTRAINT `VetID` FOREIGN KEY (`VetID`) REFERENCES `vet.v2` (`VetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application.v2`
--

LOCK TABLES `application.v2` WRITE;
/*!40000 ALTER TABLE `application.v2` DISABLE KEYS */;
INSERT INTO `application.v2` VALUES (1,'R','2024-06-04','8:30:00','Vet Clinic','S',1,'P005','V001'),(2,'R','2024-03-30','10:30:00','Vet Clinic','S',2,'P003','V003'),(3,'R','2024-04-12','12:00:00','Vet Clinic','S',3,'P002','V003'),(4,'A','2024-04-19','15:00:00','Vet Clinic','S',4,'P001','V001'),(5,'A','2024-04-25','16:00:00','Vet Clinic','S',4,'P002','V001'),(6,'A','2024-04-02','17:00:00','Vet Clinic','C',4,'P003','V001'),(7,'A','2024-04-19','15:00:00','Vet Clinic','C',4,'P004','V001'),(8,'A','2024-06-23','13:00:00','Vet Clinic','S',5,'P005','V002'),(9,'A','2024-06-23','13:30:00','Vet Clinic','P',5,'P006','V002'),(10,'R','2024-07-23','9:30:00','Vet Clinic','S',5,'P007','V002');
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

-- Dump completed on 2024-07-04 11:48:53
