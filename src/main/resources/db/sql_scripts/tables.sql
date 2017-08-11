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

CREATE TABLE `notes` (
   
`note_id` int(11) NOT NULL,
  
`card_id` int(11) DEFAULT NULL,
  
`course` varchar(10) DEFAULT NULL,
  
`Description` varchar(1000) DEFAULT NULL,
  
`createdate` datetime DEFAULT NULL,
  
`notes_id` decimal(19,0) NOT NULL,
  
PRIMARY KEY (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



