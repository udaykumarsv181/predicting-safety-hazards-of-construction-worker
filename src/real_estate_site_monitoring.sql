/*
MySQL Data Transfer
Source Host: localhost
Source Database: real_estate_site_monitoring
Target Host: localhost
Target Database: real_estate_site_monitoring
Date: 02-06-2025 21:08:17
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for employee_current_site
-- ----------------------------
DROP TABLE IF EXISTS `employee_current_site`;
CREATE TABLE `employee_current_site` (
  `eid` varchar(20) default NULL,
  `site_id` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for employee_details
-- ----------------------------
DROP TABLE IF EXISTS `employee_details`;
CREATE TABLE `employee_details` (
  `eid` varchar(20) NOT NULL,
  `ename` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `mobile` varchar(13) NOT NULL,
  `tag` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `doj` varchar(20) NOT NULL,
  `dept` varchar(40) NOT NULL,
  PRIMARY KEY  (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for equipment_current_site
-- ----------------------------
DROP TABLE IF EXISTS `equipment_current_site`;
CREATE TABLE `equipment_current_site` (
  `eid` int(10) NOT NULL,
  `site_id` int(10) NOT NULL,
  PRIMARY KEY  (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for equipment_details
-- ----------------------------
DROP TABLE IF EXISTS `equipment_details`;
CREATE TABLE `equipment_details` (
  `eid` int(10) NOT NULL auto_increment,
  `equipment_name` varchar(30) NOT NULL,
  `equipment_description` varchar(200) NOT NULL,
  `rfid_tag` varchar(20) default NULL,
  `status` varchar(20) default NULL,
  `manufacturer` varchar(100) default NULL,
  `vendor` varchar(100) default NULL,
  `date_of_manufacturing` varchar(20) default NULL,
  `date_of_introduction` varchar(20) default NULL,
  `date_of_expiry` varchar(20) default '',
  PRIMARY KEY  (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for equipment_issues_details
-- ----------------------------
DROP TABLE IF EXISTS `equipment_issues_details`;
CREATE TABLE `equipment_issues_details` (
  `id` int(10) NOT NULL auto_increment,
  `supervisor` varchar(40) default NULL,
  `eid` varchar(20) default NULL,
  `name` varchar(40) default NULL,
  `Manufacturer` varchar(50) default NULL,
  `Vendor` varchar(40) default NULL,
  `msg` varchar(200) default NULL,
  `idate` varchar(20) default NULL,
  `itime` varchar(20) default NULL,
  `status` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for insurance_request
-- ----------------------------
DROP TABLE IF EXISTS `insurance_request`;
CREATE TABLE `insurance_request` (
  `id` int(5) NOT NULL auto_increment,
  `eid` varchar(30) default NULL,
  `name` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `mobile` varchar(20) default NULL,
  `dept` varchar(100) default NULL,
  `vid` varchar(200) default NULL,
  `adate` varchar(200) default NULL,
  `atime` varchar(40) default NULL,
  `status` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for issues_details
-- ----------------------------
DROP TABLE IF EXISTS `issues_details`;
CREATE TABLE `issues_details` (
  `id` int(10) NOT NULL auto_increment,
  `supervisor` varchar(40) default NULL,
  `eid` varchar(20) default NULL,
  `name` varchar(40) default NULL,
  `mob` varchar(50) default NULL,
  `dept` varchar(40) default NULL,
  `msg` varchar(200) default NULL,
  `idate` varchar(20) default NULL,
  `itime` varchar(20) default NULL,
  `status` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `email` varchar(40) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `utype` varchar(15) NOT NULL,
  PRIMARY KEY  (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for track_employee
-- ----------------------------
DROP TABLE IF EXISTS `track_employee`;
CREATE TABLE `track_employee` (
  `tid` int(10) NOT NULL auto_increment,
  `eid` int(19) default NULL,
  `site_id` int(19) default NULL,
  `in_date` varchar(20) default NULL,
  `in_time` varchar(20) default NULL,
  `out_date` varchar(20) default NULL,
  `out_time` varchar(20) default '',
  `status` varchar(20) default NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for track_eqipment
-- ----------------------------
DROP TABLE IF EXISTS `track_eqipment`;
CREATE TABLE `track_eqipment` (
  `tid` int(10) NOT NULL auto_increment,
  `eid` int(19) default NULL,
  `site_id` int(19) default NULL,
  `in_date` varchar(20) default NULL,
  `in_time` varchar(20) default NULL,
  `out_date` varchar(20) default NULL,
  `out_time` varchar(20) default '',
  `status` varchar(20) default NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `employee_details` VALUES ('emp1', 'Sam', 'sam@gmail.com', '9887766882', '32456789', '2023-03-02', '2023-03-06', 'Safety Engineer');
INSERT INTO `employee_details` VALUES ('emp3', 'sam', 'ansprotech@gmail.com', '9886832434', '1234567887', '2023-03-25', '2023-06-24', 'Accounts');
INSERT INTO `equipment_current_site` VALUES ('1', '8');
INSERT INTO `equipment_details` VALUES ('1', 'Device 1', 'ffffffg', '5500E91C6ECE', 'Active', 'Philips', 'ABC', '2023-02-01', '2023-02-13', '2024-04-27');
INSERT INTO `equipment_details` VALUES ('2', 'Device 2`', 'dddd', '430077BD9910', 'Active', 'LG', 'xyz', '2023-02-01', '2023-02-13', '2023-02-26');
INSERT INTO `equipment_details` VALUES ('3', 'Device 3', 'mri', '0000519D1AD6', 'Active', 'Sony', 'pqr', '2023-02-03', '2023-02-14', '2024-05-25');
INSERT INTO `equipment_details` VALUES ('4', 'dddd', 'sacdsac ', '21331312312', 'Active', 'ddqa', 'dscc', '2023-02-17', '2023-03-02', '2023-04-01');
INSERT INTO `equipment_details` VALUES ('9', 'dfdsfsfds', '', '32424432432', 'Active', 'dgffdgdfsgf', 'vbdfbgfdshg', '2023-03-03', '2023-03-09', '2023-03-29');
INSERT INTO `equipment_details` VALUES ('10', 'Concrete Pump', 'pump', '34256789000', 'Active', 'GE', 'xyz', '2023-03-03', '2023-03-23', '2023-04-02');
INSERT INTO `equipment_details` VALUES ('11', 'scanner', 'to scan the devices', '24356475', 'Active', 'yes', 'yes', '2023-04-06', '2023-07-23', '2024-06-27');
INSERT INTO `equipment_issues_details` VALUES ('1', 'Ansprotech@gmail.com', '10', 'Concrete Pump', 'xyz', '2023-03-03', 'power issue', '12-06-2023', '03-54-58', 'Pending');
INSERT INTO `equipment_issues_details` VALUES ('2', 'Ansprotech@gmail.com', '10', 'Concrete Pump', 'xyz', '2023-03-03', 'no power', '12-07-2023', '12-12-22', 'Pending');
INSERT INTO `equipment_issues_details` VALUES ('3', 'Ansprotech@gmail.com', '11', 'scanner', 'yes', '2023-04-06', 'not working', '31-07-2023', '02-34-58', 'Pending');
INSERT INTO `insurance_request` VALUES ('1', 'emp1', 'Sam', 'sam@gmail.com', '9887766882', 'Safety Engineer', '1.jpg', '01-06-2025', '11-02-38', 'Denied');
INSERT INTO `issues_details` VALUES ('1', 'Ansprotech@gmail.com', 'emp1', 'Sam', '9887766882', 'Safety Engineer', 'not working properly ', '07-02-2025', '01-53-30', 'Pending');
INSERT INTO `issues_details` VALUES ('2', 'ansprotech@gmail.com', 'emp1', 'Sam', '9887766882', 'Safety Engineer', 'not working ', '11-02-2025', '02-00-41', 'Pending');
INSERT INTO `issues_details` VALUES ('3', 'Ansprotech@gmail.com', 'emp3', 'sam', '9886832434', 'Accounts', 'no issues', '12-02-2025', '03-46-43', 'Pending');
INSERT INTO `issues_details` VALUES ('4', 'Ansprotech@gmail.com', 'emp3', 'sam', '9886832434', 'Accounts', 'no id card', '12-02-2025', '12-11-18', 'Pending');
INSERT INTO `login` VALUES ('admin', '123456', 'admin');
INSERT INTO `login` VALUES ('ansprotech@gmail.com', '123456', 'Supervisor');
INSERT INTO `login` VALUES ('insurance@gmail.com', '123456', 'insurance');
INSERT INTO `track_eqipment` VALUES ('1', '1', '2', '01-08-2023', '02-27-36', '01-08-2023', '02-28-13', 'off_track');
INSERT INTO `track_eqipment` VALUES ('2', '1', '2', '01-08-2023', '02-28-13', '01-08-2023', '02-49-51', 'off_track');
INSERT INTO `track_eqipment` VALUES ('3', '1', '1', '01-08-2023', '02-49-51', '01-08-2023', '02-50-10', 'off_track');
INSERT INTO `track_eqipment` VALUES ('4', '1', '8', '01-08-2023', '02-50-10', null, '', 'on_track');
