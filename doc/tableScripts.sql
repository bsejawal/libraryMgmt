CREATE TABLE `library`.`user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `userType` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `library`.`user` CHANGE COLUMN `password` `password` VARCHAR(32) NULL DEFAULT NULL;
ALTER TABLE `library`.`user` CHANGE COLUMN `phone` `phone` VARCHAR(15) NULL DEFAULT NULL;
INSERT INTO `library`.`user` (`username`,`password`,`name`,`phone`,`email`,`userType`) VALUE('bsejawal',md5('123'), 'Bhesh Raj Sejawal','9841729762','sejawalbraj@gmail.com','admin')
INSERT INTO `library`.`user` (`username`,`password`,`name`,`phone`,`email`,`userType`) VALUE('gparajuli',md5('123'), 'Ganesh Prasad Parajuli','9849467690','gparajuli@gmail.com','normal');