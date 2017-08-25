INSERT INTO `kwantapp`.`users`
(`user_id`,
`name`,
`surname`,
`email`)
VALUES
(1,
'Maciek',
'G',
'mg@kwant.com.pl');



INSERT INTO `kwantapp`.`users`
(`user_id`,
`name`,
`surname`,
`email`)
VALUES
(2,
'Adrian',
'Sadowski',
'adrian.sadowski@kwant.com.pl');



INSERT INTO `kwantapp`.`users`
(`user_id`,
`name`,
`surname`,
`email`)
VALUES
(3,
'Marcin',
'S',
'sm@kwant.com.pl');



INSERT INTO `kwantapp`.`users`
(`user_id`,
`name`,
`surname`,
`email`)
VALUES
(4,
'Pawel',
'S',
'pd@kwant.com.pl');

 

INSERT INTO `kwantapp`.`users`
(`user_id`,
`name`,
`surname`,
`email`)
VALUES
(5,
'Mariusz',
'F',
'mf@kwant.com.pl');



INSERT INTO `kwantapp`.`users`
(`user_id`,
`name`,
`surname`,
`email`)
VALUES
(6,
'Bartek',
'Szczepaniak',
'bartosz.szczepaniak@kwant.com.pl');

 

INSERT INTO `kwantapp`.`users`
(`user_id`,
`name`,
`surname`,
`email`)
VALUES
(7,
'Patryk',
'Sudzinski',
'patryk.sudzinski@kwant.com.pl');

 

INSERT INTO `kwantapp`.`users`
(`user_id`,
`name`,
`surname`,
`email`)
VALUES
(8,
'Sylwia',
'Skowron',
'sylwia.skowron@kwant.com.pl');

 

INSERT INTO `kwantapp`.`users`
(`user_id`,
`name`,
`surname`,
`email`)
VALUES
(9,
'Ksero',
'Ksero',
'ksero@kwant.com.pl');



INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(1,
'TKIYU32',
'2017-07-16 00:00:00',
'2017-06-28 00:00:00',
150060,
'Sprawny',
2,
125000);



INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(2,
'TK9528L',
'2017-09-14 00:00:00',
'2017-08-11 00:00:00',
137588,
'Sprawny',
3,
116640);



INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(3,
'TK1434N',
'2018-01-26 00:00:00',
'2017-12-09 00:00:00',
126424,
'Sprawny',
4,
121600);



INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(4,
'TK8740M',
'2018-05-05 00:00:00',
'2018-05-04 00:00:00',
42990,
'Sprawny',
5,
38400);



INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(5,
'TK3740H',
'2017-09-05 00:00:00',
'2017-09-06 00:00:00',
209131,
'Sprawny',
6,
189407);



INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(6,
'TK9242J',
'2018-01-20 00:00:00',
'2018-01-20 00:00:00',
127109,
'Sprawny',
7,
127109);



INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(7,
'TK3619R',
'2018-05-20 00:00:00',
'2018-05-31 00:00:00',
154167,
'Sprawny',
8,
139800);

INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(8,
'TKI 04544',
'2017-11-28 00:00:00',
'2017-09-16 00:00:00',
182850,
'Sprawny',
9,
182850);



INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(9,
'TK 3831M',
'2018-01-26 00:00:00',
'2017-12-09 00:00:00',
227162,
'Sprawny',
9,
227162);



INSERT INTO `kwantapp`.`cars`
(`car_id`,
`plates`,
`overview`,
`insurance`,
`course`,
`description`,
`users_id`,
`last_oil_change`)
VALUES
(10,
'TK6332K',
'2018-07-25 00:00:00',
'2017-07-25 00:00:00',
175200,
'Sprawny',
9,
161296);

INSERT INTO `kwantapp`.`carnotes`
(`note_id`,
`car_id`,
`course`,
`Description`,
`createdate`)
VALUES
(
1,
1,
150000,
"wymiana oleju",
'2017-07-25 00:00:00'
);

INSERT INTO `kwantapp`.`carnotes`
(`note_id`,
`car_id`,
`course`,
`Description`,
`createdate`)
VALUES
(
2,
1,
150000,
"wymiana hamulcow",
'2017-07-25 00:00:00'
);

INSERT INTO `kwantapp`.`carnotes`
(`note_id`,
`car_id`,
`course`,
`Description`,
`createdate`)
VALUES
(
3,
1,
150000,
"wymiana sprzegla",
'2017-07-25 00:00:00'
);

INSERT INTO `kwantapp`.`tasks`
(`task_Id`,
`name`,
`description`,
`status`,
`close_date`,
`create_date`,
`customer`,
`customer_Location`,
`user_Id`
)
VALUES
(1,
"Task1",
"Description task1",
"open",
'2017-09-05 00:00:00',
'2017-09-05 00:00:00',
"kwanttest",
"Kielce",
1
);

INSERT INTO `kwantapp`.`tasks`
(`task_Id`,
`name`,
`description`,
`status`,
`close_date`,
`create_date`,
`customer`,
`customer_Location`,
`user_Id`
)
VALUES
(2,
"Task2",
"Description task2",
"open",
'2017-09-05 00:00:00',
'2017-09-05 00:00:00',
"kwanttest",
"Kielce",
1
);


INSERT INTO `kwantapp`.`tasks`
(`task_Id`,
`name`,
`description`,
`status`,
`close_date`,
`create_date`,
`customer`,
`customer_Location`,
`user_Id`
)
VALUES
(3,
"Task3",
"Description task3",
"open",
'2017-09-05 00:00:00',
'2017-09-05 00:00:00',
"kwanttest",
"Kielce",
1
);