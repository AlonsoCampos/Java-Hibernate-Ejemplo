-- MySQL dump 10.13  Distrib 5.5.8, for Win32 (x86)
--
-- Host: localhost    Database: estimulos
-- ------------------------------------------------------
-- Server version	5.1.57-community

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
-- Table structure for table `estimulos`
--
create database estimulos;
use estimulos;

DROP TABLE IF EXISTS `estimulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estimulos` (
  `idEstimulos` int(11) NOT NULL AUTO_INCREMENT,
  `RFC` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `ApellidoPaterno` varchar(45) NOT NULL,
  `ApellidoMaterno` varchar(45) NOT NULL,
  `Clave` varchar(45) NOT NULL,
  `FechaIngreso` varchar(45) NOT NULL,
  `Observaciones` varchar(45) NOT NULL,
  `Puesto` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstimulos`),
  UNIQUE KEY `idEstimulos_UNIQUE` (`idEstimulos`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estimulos`
--

LOCK TABLES `estimulos` WRITE;
/*!40000 ALTER TABLE `estimulos` DISABLE KEYS */;
INSERT INTO `estimulos` VALUES (5,'sdjh','jh','Administrativo','Administrativo','kjh','21/09/12','adsas','Administrativo'),(6,'sdjh','jh','Administrativo','Administrativo','kjh','21/09/12','adsas','Administrativo'),(7,'Yosho','Yoshi','Docente','Docente','1234','23/09/12','Es un yoshi	s','Docente'),(9,'8HDHAI','REX','Administrativo','Administrativo','2449','23/09/12','ninguna','Administrativo'),(11,'hjhjk','jhjhkj','Administrativo','Administrativo','','23/09/12','','Administrativo'),(12,'11200ui','Hector','Campos','Alonso','hjsdhk','23/09/12','skjd','Administrativo'),(13,'jhdfjhkh','jhkj','hjh','jh','jkhl','1/10/92','SADSHAJKDHKLJ','Administrativo'),(14,'d','jhj','hjhk','hkhj','hkjhkj','10/09/92','sd,msnd	','Docente'),(15,'sdshjdsad','hkh','jhl','jkhj','hjkhkjh','12/09/02','sdasljlñda','Docente'),(16,'hdskljh','hkjhkl','hjljkh','gfhgfhgd','hgfgfhjgf','15/12/72','fdsf','Docente'),(17,'uio','o','opioi','bjhok','hkpopk','1/09/87','dsa','Administrativo'),(18,'kjoij','ji','jio','jpij','pio','10/09/97','dsds','Administrativo'),(19,'090d','jk9009','j09jj','90j9j','j90j9','8/09/87','dasda','Administrativo'),(20,'88989','8098900','u90hh','iuiuo','uoiuo','29/04/87','sadsad','Administrativo'),(21,'9','iu89','8j','8p0','9i9','14/04/82','adsajñ','Administrativo'),(22,'jjiojnn9','00jnk','kj','lk','jlk','5/09/72','sadmlksjad','Administrativo'),(23,'i\'09','09','\'090','joiji','9\'0','14/09/67','sjkldjañskl','Docente'),(24,'jhdsjh','jhkj','hklj','hkjh','kjhlkj','18/09/97','sdkjsakljñ	','Administrativo'),(25,'90','YOSHOsdhgsajdg','Docentegj','Docentehg','8098hjg','15/09/12','Is a Yoshihj	','Administrativo'),(26,'t86guyo8','78g7o8','g78ghugy','g7yg78u','gyg7','15/09/12','sdabsdjklh	','Docente');
/*!40000 ALTER TABLE `estimulos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-05 13:18:18
