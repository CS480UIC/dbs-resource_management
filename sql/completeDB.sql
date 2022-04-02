-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: resource_management
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Temporary view structure for view `available_resource`
--

DROP TABLE IF EXISTS `available_resource`;
/*!50001 DROP VIEW IF EXISTS `available_resource`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `available_resource` AS SELECT 
 1 AS `id`,
 1 AS `resource_name`,
 1 AS `available_capacity`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `booked_view`
--

DROP TABLE IF EXISTS `booked_view`;
/*!50001 DROP VIEW IF EXISTS `booked_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `booked_view` AS SELECT 
 1 AS `employee_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` varchar(7) NOT NULL,
  `employee_user_id` varchar(7) NOT NULL,
  `resource_id` varchar(7) NOT NULL,
  `booked_capacity` smallint unsigned NOT NULL,
  `booking_slot` datetime NOT NULL,
  `number_of_hours` tinyint unsigned NOT NULL,
  `notes` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `employee_user_id` (`employee_user_id`),
  KEY `resource_id` (`resource_id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`employee_user_id`) REFERENCES `booking_employee` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chk_bookc` CHECK ((`booked_capacity` > 0)),
  CONSTRAINT `chk_noh` CHECK ((`number_of_hours` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES ('id12','skati6','cmp321',13,'2022-04-26 15:00:00',2,'required for 2 hours'),('id13','maddie7','chem35',22,'2022-04-12 13:30:00',3,NULL),('id14','kate22','bf34',24,'2022-04-15 09:00:00',3,'required for 3 hours'),('id15','diana36','cl324',43,'2022-04-25 14:00:00',3,NULL),('id16','ahmad12','sw2786',50,'2022-04-25 15:00:00',2,'Swimming pool has to be cleaned');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `booking_details`
--

DROP TABLE IF EXISTS `booking_details`;
/*!50001 DROP VIEW IF EXISTS `booking_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `booking_details` AS SELECT 
 1 AS `slot_booked`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `booking_employee`
--

DROP TABLE IF EXISTS `booking_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_employee` (
  `user_id` varchar(7) NOT NULL,
  `school_code` varchar(7) NOT NULL,
  `employee_name` varchar(20) NOT NULL,
  `password` varchar(12) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `school_code` (`school_code`),
  CONSTRAINT `booking_employee_ibfk_1` FOREIGN KEY (`school_code`) REFERENCES `school` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_employee`
--

LOCK TABLES `booking_employee` WRITE;
/*!40000 ALTER TABLE `booking_employee` DISABLE KEYS */;
INSERT INTO `booking_employee` VALUES ('ahmad12','UIS8','Ahmad','ahmad12'),('diana36','UIUC123','Diana','diana36'),('kate22','UIC8','Kate','kate22'),('maddie7','CHI606','Maddie','maddie7'),('skati6','A123','Shreya','skati6');
/*!40000 ALTER TABLE `booking_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_employee_grade`
--

DROP TABLE IF EXISTS `booking_employee_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_employee_grade` (
  `grade` tinyint unsigned NOT NULL,
  `booking_employee_user_id` varchar(7) NOT NULL,
  PRIMARY KEY (`grade`,`booking_employee_user_id`),
  KEY `booking_employee_user_id` (`booking_employee_user_id`),
  CONSTRAINT `booking_employee_grade_ibfk_1` FOREIGN KEY (`booking_employee_user_id`) REFERENCES `booking_employee` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_employee_grade`
--

LOCK TABLES `booking_employee_grade` WRITE;
/*!40000 ALTER TABLE `booking_employee_grade` DISABLE KEYS */;
INSERT INTO `booking_employee_grade` VALUES (6,'ahmad12'),(4,'diana36'),(8,'kate22'),(7,'maddie7'),(12,'skati6');
/*!40000 ALTER TABLE `booking_employee_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
/*!50001 DROP VIEW IF EXISTS `employee_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `employee_details` AS SELECT 
 1 AS `user_id`,
 1 AS `employee_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `hour_booked`
--

DROP TABLE IF EXISTS `hour_booked`;
/*!50001 DROP VIEW IF EXISTS `hour_booked`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `hour_booked` AS SELECT 
 1 AS `booked_resources`,
 1 AS `number_of_hours`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `join_view`
--

DROP TABLE IF EXISTS `join_view`;
/*!50001 DROP VIEW IF EXISTS `join_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `join_view` AS SELECT 
 1 AS `name`,
 1 AS `resource_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource` (
  `id` varchar(7) NOT NULL,
  `school_code` varchar(7) NOT NULL,
  `resource_name` varchar(20) NOT NULL,
  `resource_location` varchar(50) NOT NULL,
  `full_capacity` smallint unsigned NOT NULL,
  `available_capacity` smallint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `school_code` (`school_code`),
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`school_code`) REFERENCES `school` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chk_fullc` CHECK ((`full_capacity` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES ('bf34','UIC8','Basketball field','890 S monroe street',48,24),('chem35','CHI606','Chemistry lab','770 S Halsted',25,3),('cl324','UIUC123','Computer labs','650 S Halsted',50,7),('cmp321','A123','Computers','100 N Broadway Ave',20,7),('sw2786','UIS8','Swimming pool','440 W Madison',100,50);
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school` (
  `code` varchar(7) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `head` varchar(20) NOT NULL,
  `login_id` varchar(10) NOT NULL,
  `password` varchar(12) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `login_id` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES ('A123','ABC International','100 N Broadway Ave','Rhea Ballard','fio7','rheaballard'),('CHI606','Chicago elementary','770 S Halsted','Sandy','skati1','sandy'),('UIC8','UIC','890 S monroe street','Torim White','diana25','torimwhite'),('UIS8','UIS','440 W Madison','Lupita lopez','katie','lupilopez'),('UIUC123','UIUC','650 S Halsted','Steve Maxwel','hanset','steve');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `school_details`
--

DROP TABLE IF EXISTS `school_details`;
/*!50001 DROP VIEW IF EXISTS `school_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `school_details` AS SELECT 
 1 AS `name`,
 1 AS `address`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
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
-- Final view structure for view `available_resource`
--

/*!50001 DROP VIEW IF EXISTS `available_resource`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `available_resource` AS select `resource`.`id` AS `id`,`resource`.`resource_name` AS `resource_name`,`resource`.`available_capacity` AS `available_capacity` from `resource` where (`resource`.`available_capacity` > 0) order by `resource`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `booked_view`
--

/*!50001 DROP VIEW IF EXISTS `booked_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `booked_view` AS select `be`.`employee_name` AS `employee_name` from `booking_employee` `be` where exists(select 1 from `booking` where ((`booking`.`employee_user_id` = `be`.`user_id`) and (`booking`.`booked_capacity` > 25))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `booking_details`
--

/*!50001 DROP VIEW IF EXISTS `booking_details`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `booking_details` AS select concat(`booking`.`booking_slot`,' for ',`booking`.`number_of_hours`,' hours') AS `slot_booked` from `booking` where (cast(`booking`.`booking_slot` as time) = '15:00:00') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `employee_details`
--

/*!50001 DROP VIEW IF EXISTS `employee_details`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `employee_details` AS select `booking_employee`.`user_id` AS `user_id`,`booking_employee`.`employee_name` AS `employee_name` from `booking_employee` where `booking_employee`.`school_code` in (select `school`.`code` from `school` where (`school`.`name` = 'UIUC')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `hour_booked`
--

/*!50001 DROP VIEW IF EXISTS `hour_booked`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `hour_booked` AS select count(0) AS `booked_resources`,`booking`.`number_of_hours` AS `number_of_hours` from `booking` group by `booking`.`number_of_hours` having (count(0) > 2) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `join_view`
--

/*!50001 DROP VIEW IF EXISTS `join_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `join_view` AS select `s`.`name` AS `name`,`r`.`resource_name` AS `resource_name` from (`school` `s` join `resource` `r`) where (`s`.`code` = `r`.`school_code`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `school_details`
--

/*!50001 DROP VIEW IF EXISTS `school_details`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `school_details` AS select `school`.`name` AS `name`,`school`.`address` AS `address` from `school` where (`school`.`head` = 'Sandy') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


