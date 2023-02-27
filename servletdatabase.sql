-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: servletdatabase
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `login_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `id_UNIQUE` (`login_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'madhurmoms','1234','Madhur Jatiya','9407192414','Indore'),(2,'ranu','000','Rani ahire','1234567890','indore'),(3,'loki','000','Lokesh Nargesh','8827729125','Dhar'),(5,'Sansu','000','Sanskirti Maheshwari ','1234567890','Dhar');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'Tinkuscafe','hfu','Tinku','Cafe','7832783278','TinkuCafe@gmail.com'),(3,'Madhurmoms','1234','Madhur','Jatiya','9407192414','madhurmoms@gmail.com'),(4,'Anu','123456','Anurag','Jain','9407167890','anuragjain2rr@gmail.com'),(5,'Junnu','1111','Jhankar','Gadhwal','6767676767','junnu@gmail.com'),(6,'raj1432','1234','Lokesh','Nargesh','8827729125','nargeshraj1432@gmail.com'),(8,'Ranu','1212','Rani','Ahire','6767675652','Raniahire@gmail.com'),(9,'Rani','111','Rani','Badole','9078787878','RaniBadole@gmail.com'),(13,'Adsadsa','�Ü›ÛRÐMÂ\06ÛØ1>ÐU','cxvx','xcdxc','2323222222','asw@vf.com'),(15,'ams','�Ü›ÛRÐMÂ\06ÛØ1>ÐU','ams','ams','1234123412','123@dhh.com'),(16,'ayush','!ÃNåíËaŒOš®5�s§','ayush','gupta','1234578900','fgd@fhb'),(17,'balram','®^¸$ï‡IŸdL?§aW','balram','bdh','0987654321','gvdg@fgbh'),(18,'ashvini','ash','Ashvini','Bhandhari','6789054321','ash@vini'),(19,'ritik','ritik','Ritik','Sharma','4567890321','ritik@gmail.com'),(20,'wangadu','ä|§ ?öx)cE4Y0§','Funsuk','Wangadu','8796504321','wangadu@gmail.com'),(21,'Sans','ðq?¨é?ÌÊ?ü¥3K?õF','Sanskriti','Maheshwari','2222299999','sanskriti'),(22,'mjboss','Î¸D|Ä«xÒì4Í?ä¾Ò','Mj','Boss','5555555543','mj@gmail.com'),(25,'akash','4545','Akash','Rohit','9021902190','akash@gmail.com'),(26,'ambika','Ambika','Ambika','Sarwara','6493274879','ambika@gmail.com'),(28,'Sudhanshu','6767','Sudhanshu','Purohit','9403276723','Sudhanshu@gmail.comSudhanshu@gmail.com'),(31,'Anushka','anu','Anushka','Gadak','8827188834','Anushka@gmail.com'),(32,'Ravi','6767','Ravi','Verma','9407192434','ravi@gmail.com'),(33,'chandanraj','7878','Chandan','Ningwal','7729748249','chandan@gmail.com'),(34,'99','99','bgfvh','gvnbh ','1234567456','vfnch@gvhn'),(35,'00','00','bgfvh','gvnbh ','0987653443','vfnfch@gvhn'),(37,'Aahu','aahu','Ahana','Jatiya','8888887777','aahu@gmail.com'),(38,'55','µ;:=j¹à&‚)›Þ','55','55','5555555555','55@gma');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-27 11:53:31
