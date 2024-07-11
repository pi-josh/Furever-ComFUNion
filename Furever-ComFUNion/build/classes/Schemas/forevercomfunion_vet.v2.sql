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
-- Table structure for table `vet.v2`
--

DROP TABLE IF EXISTS `vet.v2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vet.v2` (
  `VetID` int NOT NULL AUTO_INCREMENT,
  `VetUsername` varchar(45) DEFAULT NULL,
  `VetPassword` varchar(45) DEFAULT NULL,
  `VetAcctStatus` varchar(45) DEFAULT NULL,
  `VetFullName` varchar(45) DEFAULT NULL,
  `VetAge` varchar(45) DEFAULT NULL,
  `VetCellNum` varchar(45) DEFAULT NULL,
  `VetEmailAdd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`VetID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vet.v2`
--

LOCK TABLES `vet.v2` WRITE;
/*!40000 ALTER TABLE `vet.v2` DISABLE KEYS */;
INSERT INTO `vet.v2` VALUES (1,'Snoopy420','pogiako123','A','Snoop Dog','52','9124512315','wildyoungfree@yahoo.com'),(2,'WallyBayola123','wallybayola17','A','Wally Bayola','51','9632634189','wallyeatbulaga@gmail.com'),(3,'CMartin01','angprobinsyano7','A','Coco Martin','42','9326168234','buhaypasicardo@gmail.com'),(4,'Juswa07','riseandshine','A','Joshua Macatunao','20','9458722802','joshua.macatunao69@gmail.com'),(5,'Zelda9','breathofthewild','D','Zelda Link','25','9668479203','zeldalink@gmail.com'),(6,'CatCareDoc','feline123','A','Catherine Whisker','45','9112345678','catherine@catcare.com'),(7,'DogDoc','barkbark88','A','Daniel Barker','38','9223456789','daniel@dogdoc.com'),(8,'HamsterHero','tinyfeet77','D','Harold Hamster','40','9334567890','harold@hamsterhero.com'),(9,'RabbitRescue','hopalong66','A','Rebecca Rabbit','33','9445678901','rebecca@rabbitrescue.com'),(10,'FelineFriend','meowmeow55','A','Fiona Feline','50','9556789012','fiona@felinefriend.com'),(11,'PupPro','woofwoof44','D','Paul Pup','37','9667890123','paul@puppro.com'),(12,'HamsterHelper','squeak33','A','Helen Hamster','42','9778901234','helen@hamsterhelper.com'),(13,'RabbitRanger','bunny22','D','Ryan Agoncillo','29','9889012345','ryan@rabbitranger.com'),(14,'CatVet','purrfect11','A','Clara Cat','48','9990123456','clara@catvet.com'),(15,'DoggyDoc','doggydoc00','D','Derek Dog','36','9101234567','derek@doggydoc.com'),(16,'rawrf_l','tigercity123','A','Rafael Lafuente','20','9867897876','rafael.lafuentT@gmail.com');
/*!40000 ALTER TABLE `vet.v2` ENABLE KEYS */;
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
