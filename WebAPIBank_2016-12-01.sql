# ************************************************************
# Sequel Pro SQL dump
# Version 4135
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: localhost (MySQL 5.5.38)
# Database: WebAPIBank
# Generation Time: 2016-12-01 19:32:19 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Account`;

CREATE TABLE `Account` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `sortCode` varchar(200) DEFAULT NULL,
  `accountNum` int(100) DEFAULT NULL,
  `currentBalance` double DEFAULT NULL,
  `accountType` varchar(200) DEFAULT NULL,
  `customerId` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;

INSERT INTO `Account` (`id`, `sortCode`, `accountNum`, `currentBalance`, `accountType`, `customerId`)
VALUES
	(1,'test232',1245,23100,'Savings',NULL),
	(2,'anothertes232',8154846,11000.76,'Current',NULL),
	(3,'test3!',648615612,58916.56,'Current',NULL),
	(4,'IEBICXX',7,0,'Current',1);

/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Customer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Customer`;

CREATE TABLE `Customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;

INSERT INTO `Customer` (`id`, `name`, `address`, `email`, `password`)
VALUES
	(1,'Eoin Sutton','swords, dublin','eoin.sutton@live.com','testpassword'),
	(2,'EoinTestNew','swords!','test@test.com','password');

/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

# Dump of table Transaction
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Transaction`;

CREATE TABLE `Transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `accountId` int(11) DEFAULT NULL,
  `cardNumber` varchar(200) DEFAULT NULL,
  `cardCVV` int(11) DEFAULT NULL,
  `cardExpiry` varchar(200) DEFAULT NULL,
  `processed` tinyint(1) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Transaction` WRITE;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
