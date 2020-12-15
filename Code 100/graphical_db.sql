# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             graphical_password_db
# Server version:       5.5.29
# Server OS:            Win32
# Target-Compatibility: Standard ANSI SQL
# HeidiSQL version:     3.2 Revision: 1129
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1;*/
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'graphical_password_db'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "graphical_password_db" /*!40100 DEFAULT CHARACTER SET latin1 */;

USE "graphical_password_db";


#
# Table structure for table 'user_table'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "user_table" (
  "user_id" int(10) unsigned NOT NULL AUTO_INCREMENT,
  "name" varchar(50) DEFAULT NULL,
  "dob" varchar(100) DEFAULT NULL,
  "email_id" varchar(100) DEFAULT NULL,
  "mobile" varchar(100) DEFAULT NULL,
  "password" varchar(100) DEFAULT NULL,
  "password_color" varchar(50) DEFAULT NULL,
  PRIMARY KEY ("user_id")
) AUTO_INCREMENT=18 /*!40100 DEFAULT CHARSET=latin1*/;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
