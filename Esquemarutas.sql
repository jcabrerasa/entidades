CREATE DATABASE  IF NOT EXISTS `rutas` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rutas`;


--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Iglesias'),(2,'Bares'),(3,'Museo'),(4,'Mercados');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operador`
--

DROP TABLE IF EXISTS `operador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operador` (
  `idOperador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`idOperador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operador`
--

LOCK TABLES `operador` WRITE;
/*!40000 ALTER TABLE `operador` DISABLE KEYS */;
INSERT INTO `operador` VALUES (1,'Franklin','Monay','34345','jcabrera@ups.edu.ec'),(2,'jorge','cebollares','3443','jcabrera@uops.edu.ec'),(3,'Carolina','Colombia','909090','jcabrera@uops.edu.ec');
/*!40000 ALTER TABLE `operador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta` (
  `idRuta` int(11) NOT NULL AUTO_INCREMENT,
  `TempoEstimado` int(11) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `horaInicial` timestamp NULL DEFAULT NULL,
  `horafinal` timestamp NULL DEFAULT NULL,
  `fechahorario` date DEFAULT NULL,
  `idCategoria` int(11) NOT NULL,
  `titulo` varchar(150) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `color` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idRuta`),
  KEY `fk_Ruta_Categoria` (`idCategoria`),
  CONSTRAINT `fk_Ruta_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta`
--

LOCK TABLES `ruta` WRITE;
/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
INSERT INTO `ruta` VALUES (1,3,'Igleseias coloniales','1970-01-01 15:00:00','1970-01-01 20:00:00','2017-06-15',1,'Iglesias centro','A','d452a7'),(2,3,'Museos patrimonio','1970-01-01 05:00:00','1970-01-01 05:00:00','2017-06-16',3,'Museos Patrimonio','A','e6e7f2'),(3,4,'Bares calle larga','1970-01-01 15:00:00','1970-01-01 14:00:00','2017-06-13',2,'Bares centro','A','00ffae'),(4,5,'Iglesias de las parroquias rurales','1970-01-01 15:00:00','1970-01-01 14:00:00','2017-06-14',1,'Iglesias rurales','A',NULL),(5,8,'Museos centro historico','1970-01-01 13:00:00','1970-01-01 21:00:00','2017-06-06',3,'Ruta de los museos','A','0900ff');
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutaturista`
--

DROP TABLE IF EXISTS `rutaturista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutaturista` (
  `idRutaTurista` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(1) DEFAULT NULL,
  `idRuta` int(11) NOT NULL,
  `idTurista` int(11) NOT NULL,
  `idOperador` int(11) NOT NULL,
  PRIMARY KEY (`idRutaTurista`),
  KEY `fk_RutaTurista_Ruta1` (`idRuta`),
  KEY `fk_RutaTurista_Turista1` (`idTurista`),
  KEY `fk_RutaTurista_Operador1` (`idOperador`),
  CONSTRAINT `fk_RutaTurista_Operador1` FOREIGN KEY (`idOperador`) REFERENCES `operador` (`idOperador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RutaTurista_Ruta1` FOREIGN KEY (`idRuta`) REFERENCES `ruta` (`idRuta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RutaTurista_Turista1` FOREIGN KEY (`idTurista`) REFERENCES `turista` (`idTurista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutaturista`
--

LOCK TABLES `rutaturista` WRITE;
/*!40000 ALTER TABLE `rutaturista` DISABLE KEYS */;
/*!40000 ALTER TABLE `rutaturista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutausuario`
--

DROP TABLE IF EXISTS `rutausuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutausuario` (
  `idRutaUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(1) DEFAULT NULL,
  `descripción` varchar(250) DEFAULT NULL,
  `idTurista` int(11) NOT NULL,
  `idOperador` int(11) NOT NULL,
  PRIMARY KEY (`idRutaUsuario`),
  KEY `fk_RutaUsuario_Turista1` (`idTurista`),
  KEY `fk_RutaUsuario_Operador1` (`idOperador`),
  CONSTRAINT `fk_RutaUsuario_Operador1` FOREIGN KEY (`idOperador`) REFERENCES `operador` (`idOperador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RutaUsuario_Turista1` FOREIGN KEY (`idTurista`) REFERENCES `turista` (`idTurista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `trayecto`
--

DROP TABLE IF EXISTS `trayecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trayecto` (
  `idTrayecto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(345) DEFAULT NULL,
  `tiempotrayectoria` int(11) DEFAULT NULL,
  `cordenadas` varchar(60) DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  `tiempovisita` int(11) DEFAULT NULL,
  `tipotrayecto` varchar(1) DEFAULT NULL COMMENT 'Tipo de trayecto:\nDefault\nUsuario',
  `idRuta` int(11) NOT NULL,
  `idRutaUsuario` int(11) DEFAULT NULL,
  `horarioatencion` timestamp NULL DEFAULT NULL,
  `direccion` varchar(300) DEFAULT NULL,
  `costovisita` double DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTrayecto`),
  KEY `fk_Trayecto_Ruta1` (`idRuta`),
  KEY `fk_Trayecto_RutaUsuario1` (`idRutaUsuario`),
  CONSTRAINT `fk_Trayecto_Ruta1` FOREIGN KEY (`idRuta`) REFERENCES `ruta` (`idRuta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trayecto_RutaUsuario1` FOREIGN KEY (`idRutaUsuario`) REFERENCES `rutausuario` (`idRutaUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trayecto`
--

LOCK TABLES `trayecto` WRITE;
/*!40000 ALTER TABLE `trayecto` DISABLE KEYS */;
INSERT INTO `trayecto` VALUES (8,'ttttttTTT',5,'',-2.8945037626867,-79.00854206054646,6,'D',3,NULL,NULL,NULL,NULL,NULL),(9,'iiii',5,NULL,-2.893646550500659,-79.00755500762898,6,'D',3,NULL,NULL,NULL,NULL,NULL),(10,'rre',5,NULL,-2.8935179686168335,-79.00570964782673,5,'D',3,NULL,NULL,NULL,NULL,NULL),(11,'qqqqqqqqqqqq',7,NULL,-2.8936036898743414,-79.00313472717244,7,'D',3,NULL,NULL,NULL,NULL,NULL),(12,'aaaaa',7,NULL,-2.8937751323698913,-79.00553798644978,7,'D',2,NULL,NULL,NULL,NULL,NULL),(13,'prueba8',3,NULL,-2.893217944164523,-79.00103187530476,3,'D',3,NULL,NULL,NULL,NULL,NULL),(14,'nuevoqqqq',1,NULL,-2.8929179196328128,-79.00446510284382,1,'D',1,NULL,NULL,NULL,NULL,NULL),(15,'bbbbb',1,NULL,-2.8915035165458325,-79.00360679595906,1,'D',2,NULL,NULL,NULL,NULL,NULL),(16,'rutas de LIANA AVILA',5,'',-2.8934322473528513,-79.00570964782673,5,'D',4,NULL,NULL,NULL,NULL,NULL),(17,'jhajajaja',2,NULL,-2.892403591679487,-79.01146030395466,2,'D',3,NULL,NULL,NULL,NULL,NULL),(18,'museo1',0,NULL,-2.8972039768334357,-79.00189018218953,20,'D',5,NULL,NULL,NULL,NULL,NULL),(19,'museo',10,NULL,-2.900685671870278,-79.00164413436869,15,'D',5,NULL,NULL,NULL,NULL,NULL),(20,'museo3',10,NULL,-2.9024043708953333,-78.99841403930623,15,'D',5,NULL,NULL,NULL,NULL,NULL),(21,'museo 4',10,NULL,-2.901975767875473,-78.9915475842281,15,'D',5,NULL,NULL,NULL,NULL,NULL),(22,'fvfv fvfvf',3,NULL,-2.8939465748395254,-79.00223350494343,5,'D',1,NULL,NULL,'4',NULL,NULL),(23,'aaaaaaaaaaa',NULL,NULL,-2.8942465990989676,-79.00004482238728,4,'D',1,NULL,'1970-01-01 12:00:00','bbbbbbb',4,NULL),(24,'nuevo punto',NULL,NULL,-2.8959181613759264,-78.9994010922237,5,'D',3,NULL,'1970-01-01 13:00:00','que pasa',7,10);
/*!40000 ALTER TABLE `trayecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turista`
--

DROP TABLE IF EXISTS `turista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turista` (
  `idTurista` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(150) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `referencia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idTurista`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turista`
--

INSERT INTO `turista` VALUES (2,'fdvfdvdf','dfvdf','jcabrera@ups.ed','vfvdf'),(3,'bgbgf','bgfbgf','jcabrera@ups.ed','hnjhnj'),(4,'Jorge Cabrera','09999','jleo84@outlook.com','ikjijijnknj'),(5,'meche','1111','jleoa84@outlook.com','dfdfdf'),(6,'cabrera','111','jleo84@outlook.com','383838'),(7,'Ivon Solarte','09373737','suka@hotmail.com','Cuenca'),(8,'Ivon Solarte','09373737','suka@hotmail.com','Cuenca'),(9,'Lili','09090','jleo84@outlook.com','jnjnj'),(10,'lili','090','jleo84@outlook.com','ojkjk'),(11,'jorge c','89898','suka@hotmail.com','jkjkj'),(12,'cabrera','09373737','suka@hotmail.com','bbbb'),(13,'uiu','uiu','suka@hotmail.com','22'),(14,NULL,NULL,NULL,NULL),(15,NULL,NULL,NULL,NULL),(16,NULL,NULL,NULL,NULL),(17,NULL,NULL,NULL,NULL),(18,NULL,NULL,NULL,NULL),(19,NULL,NULL,NULL,NULL),(20,NULL,NULL,NULL,NULL),(21,'Ivon Solarte','09373737','suka@hotmail.com',''),(22,'Meche Cabrera','092972518','suka@hotmail.com',''),(23,'jorge c','09090','ssss@hotmail.com',''),(24,'cabrera','09090','jleo84@outlook.com',''),(25,'Franklin','09373737','jleoa84@outlook.com',''),(26,'Franklin','09373737','ssss@hotmail.com',''),(27,'cabrera','09090','jleo84@outlook.com',''),(28,'kmkmk','99909','suka@hotmail.com',''),(29,'kmckdnck','kmkm|','jleo84@outlook.com','kmk'),(30,'kjkn','knkn','jleo84@outlook.com',''),(31,'dcd','233','suka@hotmail.com',''),(32,'Meche Cabrera','09373737','jleo84@outlook.com',''),(33,'llm','9898','franklin@hotmail.com',''),(34,'Ivon Solarte','09090','jleo84@outlook.com',''),(35,'Lilli|','090909|','jleo84@outlook.com','');


