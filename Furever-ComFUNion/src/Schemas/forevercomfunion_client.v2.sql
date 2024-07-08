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
-- Table structure for table `client.v2`
--

DROP TABLE IF EXISTS `client.v2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client.v2` (
  `ClientID` int NOT NULL AUTO_INCREMENT,
  `ClientUsername` varchar(45) DEFAULT NULL,
  `ClientPassword` varchar(45) DEFAULT NULL,
  `ClientAcctStatus` varchar(45) DEFAULT NULL,
  `ClientFullName` varchar(45) DEFAULT NULL,
  `ClientAge` int DEFAULT NULL,
  `ClientAddress` varchar(100) DEFAULT NULL,
  `CellNum` varchar(10) DEFAULT NULL,
  `ClientEmailAdd` varchar(45) DEFAULT NULL,
  `ClientOccupation` varchar(45) DEFAULT NULL,
  `CompanyName` varchar(45) DEFAULT NULL,
  `WorkType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ClientID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client.v2`
--

LOCK TABLES `client.v2` WRITE;
/*!40000 ALTER TABLE `client.v2` DISABLE KEYS */;
INSERT INTO `client.v2` VALUES (1,'JJMacatunao','tunaw123','A','John Joshua Macatunao',19,'81 Pouros Grove, Suite 091, 64822-2475, East Jaronfurt, Iowa, United States','9892865657','jjmelt@yahoo.com','Photographer','Melt Studio','T'),(2,'Katrina14','tara8ball','D','Katrina Halili',20,'095 Loy Divide, Suite 919, 70892, Hansenstad, Wyoming, United States','9652655123','akonaman@gmail.com','NASA Scientist','NASA','NT'),(3,'Joly123','jawlineislife','A','Joly Gonzaga',31,'Poblacion, Baliuag, Bulacan, Philippines','9652235242','McWater@yahoo.com','Gym Instructor','Fitness Inc.','NT'),(4,'MarkQuiet28','shhh!!!','A','Mark Quiet',21,'826 Loyal Point, Suite 753, 37394-6564, Kuphalton, Ohio, United States','9528652421','marktahimik@gmail.com','Senior Software Engineer','Microsoft','NT'),(5,'RandyF','r.a.n.d.i.','A','Randy Fernandez',24,'77828 Towne Knoll, Suite 229, 24698-7170, Burniceburgh, West Virginia, United States','9652234242','Power.Fernandez01@y8mail.com','Senior Fraud Analyst','HSBC','NT'),(6,'AnnaSky','starrynight22','D','Anna Sky',25,'123 Blue Ridge, Suite 102, 12345, Mountainview, California, United States','9899987654','annasky@gmail.com','Graphic Designer','Blue Sky Designs','T'),(7,'MikeBuilder','builditstrong','A','Mike Builder',28,'456 Red Street, Suite 234, 23456, Bricktown, Ohio, United States','9898876543','mikeb@buildstrong.com','Construction Manager','BuildStrong Inc.','NT'),(8,'LucyReads','bookworm2020','A','Lucy Reads',22,'789 Green Avenue, Suite 345, 34567, Readington, Massachusetts, United States','9897765432','lucyreads@bookworld.com','Librarian','City Library','T'),(9,'TomPilot','flyhigh123','A','Tom Pilot',30,'012 Yellow Road, Suite 456, 45678, Aviatonville, Texas, United States','9896654321','tom.pilot@flyhigh.com','Pilot','FlyHigh Airlines','NT'),(10,'NancyCook','chefmaster456','A','Nancy Cook',35,'345 Orange Boulevard, Suite 567, 56789, Culinary City, New York, United States','9895543210','nancy.cook@culinarycity.com','Chef','Culinary Delights','T'),(11,'JakeTech','codingwizard78','A','Jake Tech',27,'678 Purple Lane, Suite 678, 67890, Silicon Valley, California, United States','9894432109','jake.tech@techworld.com','Software Developer','TechWorld','NT'),(12,'SophieArt','creativemind99','A','Sophie Art',29,'901 Pink Drive, Suite 789, 78901, Artville, Florida, United States','9893321098','sophie.art@artsy.com','Artist','Artsy Creations','T'),(13,'LeoDoctor','healtheworld','A','Leo Doctor',33,'234 White Crescent, Suite 890, 89012, Medicity, Illinois, United States','9892210987','leo.doctor@medicity.com','Doctor','Mediclinic','NT'),(14,'EvaWriter','storyteller33','A','Eva Writer',26,'567 Black Court, Suite 901, 90123, Storytown, Oregon, United States','9891109876','eva.writer@storyworld.com','Writer','StoryWorld','T'),(15,'OscarTeach','educateall','D','Oscar Teach',32,'890 Brown Plaza, Suite 012, 01234, Educity, Nevada, United States','9890098765','oscar.teach@educity.com','Teacher','Educity High','NT');
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

-- Dump completed on 2024-07-08 17:46:34
