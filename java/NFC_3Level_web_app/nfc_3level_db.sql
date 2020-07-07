/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - db_nfc_3level_atmnew
*********************************************************************
Server version : 5.0.15-nt
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
  `s_no` int(11) NOT NULL auto_increment,
  `user_id` varchar(50) default NULL,
  `img_name` varchar(20) default NULL,
  `img_desc` varchar(500) default NULL,
  `img_hash` varchar(100) default NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `img_selected` */

/*Table structure for table `m_acc_type` */

DROP TABLE IF EXISTS `m_acc_type`;

CREATE TABLE `m_acc_type` (
  `acc_type_code` varchar(15) default NULL,
  `acc_type_name` varchar(15) default NULL,
  `acc_type_description` varchar(100) default NULL,
  `acc_trans_limit` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_acc_type` */

insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('100','Savings','Personal Acc for above 18 Age','20000');
insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('103','Salary','Employee Salaried Ac from Company','15000');
insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('104','Savings','Personal Acc for above 18 Age','20000');
insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('106','Pension','For Retired PPL above 60 Age','20000');
insert into `m_acc_type` (`acc_type_code`,`acc_type_name`,`acc_type_description`,`acc_trans_limit`) values ('107','Children\'s','Kids plan betweeen 0-17 Age','10000');

/*Table structure for table `m_account` */

DROP TABLE IF EXISTS `m_account`;

CREATE TABLE `m_account` (
  `acc_id` int(10) NOT NULL auto_increment,
  `acc_no` varchar(15) default NULL,
  `acc_open_date` date default NULL,
  `acc_name` varchar(200) default NULL,
  `acc_type_code` varchar(15) default NULL,
  `branch_code` varchar(15) default NULL,
  `acc_closing_balance` varchar(200) default NULL,
  `acc_referedby` varchar(200) default NULL,
  `acc_status` varchar(50) default NULL,
  `mobileno` varchar(15) default NULL,
  `email_id` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `flag` varchar(10) NOT NULL,
  `img_code` int(10) NOT NULL,
  `session_code` int(10) default NULL,
  PRIMARY KEY  (`acc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_account` */

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `admin_id` varchar(30) NOT NULL,
  `admin_pwd` char(15) default NULL,
  `admin_name` varchar(50) default NULL,
  PRIMARY KEY  (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`admin_id`,`admin_pwd`,`admin_name`) values ('priya','priya','priya');

/*Table structure for table `m_benificiary` */

DROP TABLE IF EXISTS `m_benificiary`;

CREATE TABLE `m_benificiary` (
  `b_id` int(10) NOT NULL auto_increment,
  `user_acc_no` varchar(100) NOT NULL,
  `b_acc_no` varchar(100) NOT NULL,
  `b_acc_holder` varchar(100) NOT NULL,
  `b_urn` int(5) NOT NULL,
  `b_status` varchar(50) NOT NULL,
  PRIMARY KEY  (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_benificiary` */

/*Table structure for table `m_branch` */

DROP TABLE IF EXISTS `m_branch`;

CREATE TABLE `m_branch` (
  `branch_code` int(15) NOT NULL auto_increment,
  `branch_name` varchar(30) default NULL,
  `branch_remarks` varchar(20) default NULL,
  PRIMARY KEY  (`branch_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

/*Table structure for table `m_image` */

DROP TABLE IF EXISTS `m_image`;

CREATE TABLE `m_image` (
  `img_id` int(10) NOT NULL auto_increment,
  `img_name` varchar(50) default NULL,
  PRIMARY KEY  (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_image` */

insert into `m_image` (`img_id`,`img_name`) values (1,'image0.jpg');
insert into `m_image` (`img_id`,`img_name`) values (2,'image1.jpg');
insert into `m_image` (`img_id`,`img_name`) values (3,'image2.jpg');
insert into `m_image` (`img_id`,`img_name`) values (4,'image3.jpg');
insert into `m_image` (`img_id`,`img_name`) values (5,'image4.jpg');
insert into `m_image` (`img_id`,`img_name`) values (6,'image5.jpg');
insert into `m_image` (`img_id`,`img_name`) values (7,'image6.jpg');
insert into `m_image` (`img_id`,`img_name`) values (8,'image7.jpg');
insert into `m_image` (`img_id`,`img_name`) values (9,'image8.jpg');
insert into `m_image` (`img_id`,`img_name`) values (10,'image9.jpg');
insert into `m_image` (`img_id`,`img_name`) values (11,'image10.jpg');

/*Table structure for table `m_transaction` */

DROP TABLE IF EXISTS `m_transaction`;

CREATE TABLE `m_transaction` (
  `t_no` int(15) NOT NULL auto_increment,
  `t_date` date default NULL,
  `acc_no` varchar(20) default NULL,
  `t_type` varchar(30) default NULL,
  `fund_trans_amount` varchar(20) default NULL,
  `fund_trans_acc_no` varchar(20) default NULL,
  PRIMARY KEY  (`t_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_transaction` */

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_no` int(10) NOT NULL auto_increment,
  `u_id` varchar(50) default NULL,
  `u_name` varchar(50) default NULL,
  `u_pass` varchar(50) default NULL,
  `acc_no` varchar(50) default NULL,
  `card_no` varchar(50) default NULL,
  `hash_code` varchar(50) default NULL,
  PRIMARY KEY  (`u_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
