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
-- Table structure for table `client.v2`
--

DROP TABLE IF EXISTS `client.v2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client.v2` (
  `ClientID` int NOT NULL,
  `ClientUsername` text,
  `ClientPassword` text,
  `ClientAcctStatus` text,
  `ClientFullName` text,
  `ClientAge` int DEFAULT NULL,
  `ClientAddress` text,
  `CellNum` bigint DEFAULT NULL,
  `ClientEmailAdd` text,
  `ClientOccupation` text,
  `CompanyIncome` text,
  `CompanyName` text,
  `WorkType` text,
  PRIMARY KEY (`ClientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client.v2`
--

LOCK TABLES `client.v2` WRITE;
/*!40000 ALTER TABLE `client.v2` DISABLE KEYS */;
INSERT INTO `client.v2` VALUES (1,'JJMacatunao','tunaw123','A','John Joshua Macatunao',19,'81 Pouros Grove, Suite 091, 64822-2475, East Jaronfurt, Iowa, United States',9892865657,'jjmelt@yahoo.com','Photographer','$69,000','Melt Studio','T'),(2,'Katrina14','tara8ball','A','Katrina Halili',20,'095 Loy Divide, Suite 919, 70892, Hansenstad, Wyoming, United States',9652655123,'akonaman@gmail.com','NASA Scientist','$405,000','NASA','NT'),(3,'Joly123','jawlineislife','A','Joly Gonzaga',31,'Poblacion, Baliuag, Bulacan, Philippines',9652235242,'McWater@yahoo.com','Gym Instructor','$51,000','Fitness Inc.','NT'),(4,'MarkQuiet28','shhh!!!','A','Mark Quiet',21,'826 Loyal Point, Suite 753, 37394-6564, Kuphalton, Ohio, United States',9528652421,'marktahimik@gmail.com','Senior Software Engineer','$375,635','Microsoft','NT'),(5,'RandyF','r.a.n.d.i.','A','Randy Fernandez',24,'77828 Towne Knoll, Suite 229, 24698-7170, Burniceburgh, West Virginia, United States',9652234242,'Power.Fernandez01@y8mail.com','Senior Fraud Analyst','$93,290','HSBC','NT');
/*!40000 ALTER TABLE `client.v2` ENABLE KEYS */;
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
