/*
SQLyog - Free MySQL GUI v5.19
Host - 5.1.54-community : Database - db_nfc_3level_atmnew
*********************************************************************
Server version : 5.1.54-community
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `db_nfc_3level_atmnew`;

USE `db_nfc_3level_atmnew`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `img_selected` */

DROP TABLE IF EXISTS `img_selected`;

CREATE TABLE `img_selected` (
  `s_no` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `img_name` varchar(20) DEFAULT NULL,
  `img_desc` varchar(500) DEFAULT NULL,
  `img_hash` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`s_no`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `img_selected` */

insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (1,'123456','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (2,'123456','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (3,'123456','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (4,'123456','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (5,'123456','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (6,'123456','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (7,'123456','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (8,'123456','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (9,'123456','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (10,'1234567','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (11,'1234567','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (12,'1234567','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (13,'123123','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (14,'123123','',NULL,NULL);
insert into `img_selected` (`s_no`,`user_id`,`img_name`,`img_desc`,`img_hash`) values (15,'123123','',NULL,NULL);

/*Table structure for table `m_acc_type` */

DROP TABLE IF EXISTS `m_acc_type`;

CREATE TABLE `m_acc_type` (
  `acc_type_code` varchar(15) DEFAULT NULL,
  `acc_type_name` varchar(15) DEFAULT NULL,
  `acc_type_description` varchar(100) DEFAULT NULL,
  `acc_trans_limit` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_acc_type` */

insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('100','Savings','Personal Acc for above 18 Age','20000');
insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('103','Salary','Employee Salaried Ac from Company','20000');
insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('104','Savings','Personal Acc for above 18 Age','20000');
insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('106','Pension','For Retired PPL above 60 Age','20000');
insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('107','Children\'s','Kids plan betweeen 0-17 Age','10000');

/*Table structure for table `m_account` */

DROP TABLE IF EXISTS `m_account`;

CREATE TABLE `m_account` (
  `acc_id` int(10) NOT NULL AUTO_INCREMENT,
  `acc_no` varchar(30) DEFAULT NULL,
  `acc_open_date` date DEFAULT NULL,
  `acc_name` varchar(200) DEFAULT NULL,
  `acc_type_code` varchar(15) DEFAULT NULL,
  `branch_code` varchar(15) DEFAULT NULL,
  `acc_closing_balance` varchar(200) DEFAULT NULL,
  `acc_referedby` varchar(200) DEFAULT NULL,
  `acc_status` varchar(50) DEFAULT NULL,
  `mobileno` varchar(15) DEFAULT NULL,
  `email_id` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `flag` varchar(10) NOT NULL,
  `img_code` int(10) NOT NULL,
  `session_code` int(10) DEFAULT NULL,
  PRIMARY KEY (`acc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `m_account` */

insert into `m_account` (`acc_id`,`acc_no`,`acc_open_date`,`acc_name`,`acc_type_code`,`branch_code`,`acc_closing_balance`,`acc_referedby`,`acc_status`,`mobileno`,`email_id`,`password`,`flag`,`img_code`,`session_code`) values (1,'123456','2020-04-17','ashwini','100','10','1000.0','vasu','Active','9620725674','ashwini@dhsinformatics.com','-null-','f',0,NULL);
insert into `m_account` (`acc_id`,`acc_no`,`acc_open_date`,`acc_name`,`acc_type_code`,`branch_code`,`acc_closing_balance`,`acc_referedby`,`acc_status`,`mobileno`,`email_id`,`password`,`flag`,`img_code`,`session_code`) values (2,'123123123','2020-04-18','vasudha','100','10','1000.0','ashwini','Active','9876543210','ashwini@dhsinformatics.com','-null-','f',0,NULL);

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `admin_id` varchar(30) NOT NULL,
  `admin_pwd` char(15) DEFAULT NULL,
  `admin_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`admin_id`,`admin_pwd`,`admin_name`) values ('admin','admin','admin');

/*Table structure for table `m_atm_login` */

DROP TABLE IF EXISTS `m_atm_login`;

CREATE TABLE `m_atm_login` (
  `atm_code` int(10) NOT NULL AUTO_INCREMENT,
  `atm_branch` varchar(30) DEFAULT NULL,
  `atm_macinie_num` int(10) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`atm_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `m_atm_login` */

insert into `m_atm_login` (`atm_code`,`atm_branch`,`atm_macinie_num`,`password`) values (1,'jayanagar',1,'atm1');
insert into `m_atm_login` (`atm_code`,`atm_branch`,`atm_macinie_num`,`password`) values (2,'jpnagar',2,'atm2');
insert into `m_atm_login` (`atm_code`,`atm_branch`,`atm_macinie_num`,`password`) values (3,'banashankari',3,'atm3');

/*Table structure for table `m_benificiary` */

DROP TABLE IF EXISTS `m_benificiary`;

CREATE TABLE `m_benificiary` (
  `b_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_acc_no` varchar(100) NOT NULL,
  `b_acc_no` varchar(100) NOT NULL,
  `b_acc_holder` varchar(100) NOT NULL,
  `b_urn` int(5) NOT NULL,
  `b_status` varchar(50) NOT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `m_benificiary` */

insert into `m_benificiary` (`b_id`,`user_acc_no`,`b_acc_no`,`b_acc_holder`,`b_urn`,`b_status`) values (1,'','123456','ashwini',1083,'Confirmed');
insert into `m_benificiary` (`b_id`,`user_acc_no`,`b_acc_no`,`b_acc_holder`,`b_urn`,`b_status`) values (2,'123123123','123123123','vasudha',1642,'Confirmed');

/*Table structure for table `m_branch` */

DROP TABLE IF EXISTS `m_branch`;

CREATE TABLE `m_branch` (
  `branch_code` int(15) NOT NULL AUTO_INCREMENT,
  `branch_name` varchar(30) DEFAULT NULL,
  `branch_remarks` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`branch_code`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `m_branch` */

insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (10,'Bangalore-Madivala','Fair');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (13,'Bangalore Ulsoor','Excellent');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (14,'Bangalore-Majestic','Fair');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (15,'Bangalore-HSR','Excellent');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (16,'Bangalore-Sarjapur','Excellent');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (17,'Bangalore-JP','Good');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (20,'Bangalore-JayaNagar','Good');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (21,'Bangalore-IndraNagar','Good');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (22,'JP Nagar','Good');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (23,'jayanagar 3rd block','good');
insert into `m_branch` (`branch_code`,`branch_name`,`branch_remarks`) values (24,'kadugodi','good');

/*Table structure for table `m_image` */

DROP TABLE IF EXISTS `m_image`;

CREATE TABLE `m_image` (
  `img_id` int(10) NOT NULL AUTO_INCREMENT,
  `img_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_image` */

/*Table structure for table `m_transaction` */

DROP TABLE IF EXISTS `m_transaction`;

CREATE TABLE `m_transaction` (
  `t_no` int(15) NOT NULL AUTO_INCREMENT,
  `t_date` date DEFAULT NULL,
  `acc_no` varchar(20) DEFAULT NULL,
  `t_type` varchar(30) DEFAULT NULL,
  `fund_trans_amount` varchar(20) DEFAULT NULL,
  `fund_trans_acc_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `m_transaction` */

insert into `m_transaction` (`t_no`,`t_date`,`acc_no`,`t_type`,`fund_trans_amount`,`fund_trans_acc_no`) values (1,'2020-04-17','123456','Credited','200','123456');
insert into `m_transaction` (`t_no`,`t_date`,`acc_no`,`t_type`,`fund_trans_amount`,`fund_trans_acc_no`) values (2,'2020-04-17','123456','Debited','200','123456');
insert into `m_transaction` (`t_no`,`t_date`,`acc_no`,`t_type`,`fund_trans_amount`,`fund_trans_acc_no`) values (3,'2020-04-18','123456','Credited','200','123123123');
insert into `m_transaction` (`t_no`,`t_date`,`acc_no`,`t_type`,`fund_trans_amount`,`fund_trans_acc_no`) values (4,'2020-04-18','123123123','Debited','200','123456');

/*Table structure for table `m_transactionone` */

DROP TABLE IF EXISTS `m_transactionone`;

CREATE TABLE `m_transactionone` (
  `trans_no` int(10) NOT NULL AUTO_INCREMENT,
  `atm_branch` varchar(30) DEFAULT NULL,
  `machine_code` int(10) DEFAULT NULL,
  `acc_no` varchar(40) DEFAULT NULL,
  `bank_name` varchar(30) DEFAULT NULL,
  `bank_branch` varchar(30) DEFAULT NULL,
  `acc_name` varchar(30) DEFAULT NULL,
  `acc_type` varchar(40) DEFAULT NULL,
  `phone_num` varchar(60) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  `status` varchar(10) DEFAULT 'pending',
  `userid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`trans_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `m_transactionone` */

insert into `m_transactionone` (`trans_no`,`atm_branch`,`machine_code`,`acc_no`,`bank_name`,`bank_branch`,`acc_name`,`acc_type`,`phone_num`,`email_id`,`status`,`userid`) values (1,'jayanagar',1,'123456','sbi','10','ashwini','100','9620725674','ashwini@dhsinformatics.com','pending','');
insert into `m_transactionone` (`trans_no`,`atm_branch`,`machine_code`,`acc_no`,`bank_name`,`bank_branch`,`acc_name`,`acc_type`,`phone_num`,`email_id`,`status`,`userid`) values (2,'jayanagar',1,'123123123','sbi','10','vasudha','100','9876543210','ashwini@dhsinformatics.com','done','');

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_no` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` varchar(50) DEFAULT NULL,
  `u_name` varchar(50) DEFAULT NULL,
  `u_pass` varchar(50) DEFAULT NULL,
  `acc_no` varchar(50) DEFAULT NULL,
  `card_no` varchar(50) DEFAULT NULL,
  `hash_code` varchar(50) DEFAULT NULL,
  `dash_matrix_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`u_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_no`,`u_id`,`u_name`,`u_pass`,`acc_no`,`card_no`,`hash_code`,`dash_matrix_code`) values (1,'1234567','ashwini','12345','123456','123456789','0','325698');
insert into `m_user` (`u_no`,`u_id`,`u_name`,`u_pass`,`acc_no`,`card_no`,`hash_code`,`dash_matrix_code`) values (2,'123123','vasudha','1234','123123123','123123123','0',' ');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
