CREATE DATABASE  IF NOT EXISTS `todo2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `todo2`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: todo2
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (40);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todo_task`
--

DROP TABLE IF EXISTS `todo_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `todo_task` (
  `id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaeld4jk9o3m2x8u5q6s0fsdru` (`user_id`),
  CONSTRAINT `FKaeld4jk9o3m2x8u5q6s0fsdru` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo_task`
--

LOCK TABLES `todo_task` WRITE;
/*!40000 ALTER TABLE `todo_task` DISABLE KEYS */;
INSERT INTO `todo_task` VALUES (1,'Gyakorolni a fojtási képességet','2023-03-01','i','Fojtás',1),(2,'Lefutni 5 km-t a Mustafaron','2023-04-10','f','futni',2),(5,'Beolajozni R2 kerekeit','2023-02-22','d','Olajozás',6),(12,'Taktikai megbeszélés a Yavinon','2023-03-10','f','Megbeszélés',8),(15,'Bunda kikefélése + szőrápoló olajozása','2023-03-02','d','Szőrápolás',9),(22,'Kitisztítani a markolatot + kristály állapotának ellenőrzése','2023-03-02','d','Kard karbantartás',1),(23,'Vaderrel megbeszélés','2023-03-07','d','Megbeszélés',1),(28,'Muchit megsétáltatni','2023-03-04','f','Muchi',27),(30,'Vacsora Leia-val','2023-03-07','f','Randi',29);
/*!40000 ALTER TABLE `todo_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` longblob,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kylo','Ren','tesztelek',NULL,'kylo_sith','kylo_ren@gmail.com'),(2,'Darth','Vader','teszt2',NULL,'LordVader','vadertheoneandonly@gmail.com'),(6,'Luke','Skywalker','asdasdasd',NULL,'luke_sw','skywalker_l@gmail.com'),(8,'Leia','Organa','asdasdasd',NULL,'organaL','leia.org@gmail.com'),(9,'Chewbacca','Chewie','asdasdasd',NULL,'chewieTheWookiie','chewi@gmail.com'),(25,'Rancor','Muchi','asdasd',NULL,'muchiRancor','muchi@gmail.com'),(26,'Ewok','Chubbray','asdasd',NULL,'cubrayEwok','chubrey@gmail.com'),(27,'Jabba','The Hutt','asdasd',NULL,'jabbaHutt','jabba@gmail.com'),(29,'Han','Solo','asdasd',NULL,'soloSolo','han_solo@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_task_set`
--

DROP TABLE IF EXISTS `user_task_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_task_set` (
  `user_id` int NOT NULL,
  `task_set_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`task_set_id`),
  UNIQUE KEY `UK_kkiftsn7kvju975gno5vn25b3` (`task_set_id`),
  CONSTRAINT `FK5ybsmacxv8ik5v9mgfhj595mw` FOREIGN KEY (`task_set_id`) REFERENCES `todo_task` (`id`),
  CONSTRAINT `FK8wokab54go8f8ddbkkqq6kdoa` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_task_set`
--

LOCK TABLES `user_task_set` WRITE;
/*!40000 ALTER TABLE `user_task_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_task_set` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-05  8:28:00
