-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: tp_seminario_siglo21_renzo_comoglio
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `datosensor`
--

DROP TABLE IF EXISTS `datosensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datosensor` (
  `IDSensor` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Valor` int(11) DEFAULT NULL,
  `Valor_normal` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDSensor`,`Fecha`,`Hora`),
  CONSTRAINT `datosensor_ibfk_1` FOREIGN KEY (`IDSensor`) REFERENCES `sensor` (`IDSensor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datosensor`
--

LOCK TABLES `datosensor` WRITE;
/*!40000 ALTER TABLE `datosensor` DISABLE KEYS */;
INSERT INTO `datosensor` VALUES (1,'2023-06-01','12:00:00',25,20),(1,'2023-06-02','12:30:00',26,21),(2,'2023-06-01','12:00:00',60,50),(2,'2023-06-02','12:30:00',62,52),(3,'2023-06-01','12:00:00',50,45),(3,'2023-06-02','12:30:00',52,47),(4,'2023-06-01','12:00:00',400,350),(4,'2023-06-02','12:30:00',410,360),(5,'2024-06-29','17:00:00',40,20),(5,'2024-06-30','17:30:00',31,20),(6,'2024-06-29','17:00:00',30,50),(6,'2024-06-30','17:30:00',31,50),(7,'2024-06-29','17:00:00',45,45),(7,'2024-06-30','17:30:00',45,45),(8,'2024-06-29','17:00:00',400,350),(8,'2024-06-30','17:30:00',410,350);
/*!40000 ALTER TABLE `datosensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gateway`
--

DROP TABLE IF EXISTS `gateway`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gateway` (
  `ID` int(11) NOT NULL,
  `Mac` varchar(255) NOT NULL,
  `Geolocalización` double DEFAULT NULL,
  PRIMARY KEY (`ID`,`Mac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gateway`
--

LOCK TABLES `gateway` WRITE;
/*!40000 ALTER TABLE `gateway` DISABLE KEYS */;
INSERT INTO `gateway` VALUES (1,'00:14:22:01:23:45',34.0522),(2,'00:00:00',122333);
/*!40000 ALTER TABLE `gateway` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nodos`
--

DROP TABLE IF EXISTS `nodos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nodos` (
  `IDNodo` int(11) NOT NULL,
  `Geolocalización` double DEFAULT NULL,
  `ID_Gateway` int(11) DEFAULT NULL,
  `Estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDNodo`),
  KEY `nodos_ibfk_1` (`ID_Gateway`),
  CONSTRAINT `nodos_ibfk_1` FOREIGN KEY (`ID_Gateway`) REFERENCES `gateway` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nodos`
--

LOCK TABLES `nodos` WRITE;
/*!40000 ALTER TABLE `nodos` DISABLE KEYS */;
INSERT INTO `nodos` VALUES (1,1,1,'OK'),(2,3.45667,1,'Ok'),(3,776546,1,'Ok');
/*!40000 ALTER TABLE `nodos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `ID_persona` int(11) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  `dirección` varchar(255) DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `nacionalidad` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_persona`,`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sensor` (
  `IDSensor` int(11) NOT NULL,
  `IDNodo` int(11) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDSensor`),
  KEY `sensor_ibfk_1` (`IDNodo`),
  CONSTRAINT `sensor_ibfk_1` FOREIGN KEY (`IDNodo`) REFERENCES `nodos` (`IDNodo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
INSERT INTO `sensor` VALUES (1,1,'Temperatura'),(2,1,'Humedad'),(3,1,'Monóxido de Carbono'),(4,1,'Dióxido de Carbono'),(5,2,'Temperatura'),(6,2,'Humedad'),(7,2,'Monóxido de Carbono'),(8,2,'Dióxido de Carbono');
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablagraficos`
--

DROP TABLE IF EXISTS `tablagraficos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tablagraficos` (
  `IDSensor` int(11) NOT NULL,
  `nombre_dato` varchar(255) NOT NULL,
  `dato` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDSensor`,`nombre_dato`),
  CONSTRAINT `tablagraficos_ibfk_1` FOREIGN KEY (`IDSensor`) REFERENCES `sensor` (`IDSensor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablagraficos`
--

LOCK TABLES `tablagraficos` WRITE;
/*!40000 ALTER TABLE `tablagraficos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tablagraficos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_usuario` (
  `id_tipo` int(11) NOT NULL,
  `tipo_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID_persona` int(11) NOT NULL,
  `id_tipo` int(11) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_persona`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `id_tipo` (`id_tipo`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`ID_persona`) REFERENCES `persona` (`ID_persona`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tp_seminario_siglo21_renzo_comoglio'
--

--
-- Dumping routines for database 'tp_seminario_siglo21_renzo_comoglio'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-29 13:03:13
