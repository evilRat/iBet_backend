-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ibet
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_bet`
--

DROP TABLE IF EXISTS `t_bet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_bet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `redballnum` int(11) NOT NULL,
  `blueballnum` int(11) NOT NULL,
  `redballrange` int(11) NOT NULL,
  `blueballrange` int(11) NOT NULL,
  `picname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_bet`
--

LOCK TABLES `t_bet` WRITE;
/*!40000 ALTER TABLE `t_bet` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_bet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_bet_betsite`
--

DROP TABLE IF EXISTS `t_bet_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_bet_site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `betid` int(11) DEFAULT NULL,
  `betsiteid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `betid_idx` (`betid`),
  KEY `betsiteid_idx` (`betsiteid`),
  CONSTRAINT `betid` FOREIGN KEY (`betid`) REFERENCES `t_bet` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `betsiteid1` FOREIGN KEY (`betsiteid`) REFERENCES `t_betsite` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_bet_site`
--

LOCK TABLES `t_bet_site` WRITE;
/*!40000 ALTER TABLE `t_bet_site` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_bet_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_betsite`
--

DROP TABLE IF EXISTS `t_betsite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_betsite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `master` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_betsite`
--

LOCK TABLES `t_betsite` WRITE;
/*!40000 ALTER TABLE `t_betsite` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_betsite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wxopenid` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `wxnickname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_betsite`
--

DROP TABLE IF EXISTS `t_user_betsite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_betsite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `betsiteid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid_idx` (`userid`),
  KEY `betsiteid_idx` (`betsiteid`),
  CONSTRAINT `betsiteid` FOREIGN KEY (`betsiteid`) REFERENCES `t_betsite` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_betsite`
--

LOCK TABLES `t_user_betsite` WRITE;
/*!40000 ALTER TABLE `t_user_betsite` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_betsite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ibet'
--

--
-- Dumping routines for database 'ibet'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-07 14:43:37
