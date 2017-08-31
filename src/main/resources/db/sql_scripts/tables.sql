CREATE TABLE `cars` (
  
`car_id` int(11) NOT NULL,
  
`plates` varchar(45) DEFAULT NULL,
  
`overview` datetime DEFAULT NULL,
  
`is_user_aver_of_overview_expiration` tinyint(4) DEFAULT '0',
  
`insurance` datetime DEFAULT NULL,
  
`is_user_aver_of_insurance_expiration` tinyint(4) DEFAULT '0',
  `
course` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  
`users_id` varchar(255) DEFAULT NULL,
  `last_oil_change` int(11) DEFAULT NULL,
  
`is_user_aver_of_oil_change` tinyint(4) DEFAULT '0',
  
PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  
`user_id` decimal(19,0) NOT NULL,
  
`name` varchar(45) DEFAULT NULL,
  
`surname` varchar(45) DEFAULT NULL,
  
`email` varchar(45) DEFAULT NULL,
  
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `carnotes` (
   
`note_id` int(11) NOT NULL,
  
`car_id` int(11) DEFAULT NULL,
  
`course` varchar(10) DEFAULT NULL,
  
`Description` varchar(1000) DEFAULT NULL,
  
`createdate` datetime DEFAULT NULL,
   
PRIMARY KEY (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tasks` (
   
`task_id` int(11) NOT NULL,
  
`name` varchar(100) DEFAULT NULL,
  
`description` varchar(1000) DEFAULT NULL,
  
`status` varchar(1000) DEFAULT NULL,
  
`create_date` datetime DEFAULT NULL,
  
`close_date` datetime DEFAULT NULL,
 
`customer` varchar(1000) DEFAULT NULL,
  
`customer_location` varchar(100) DEFAULT NULL,

`user_Id` int(6) DEFAULT NULL,
 
PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `kwantapp`.`holidays` (
  

`holiday_id` INT NOT NULL AUTO_INCREMENT,
  

`user_id` VARCHAR(4) NOT NULL,
  

`decision` VARCHAR(45) NULL,
  

`person_m_decisions_id` INT NULL,
  

`holiday_type` VARCHAR(45) NULL,
  

`creation_date` DATETIME NULL,
  

`decision_date` DATETIME NULL,
  

`begin_date` DATETIME NULL,
  

`end_date` DATETIME NULL,
  

PRIMARY KEY (`holiday_id`));
