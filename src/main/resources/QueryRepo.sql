CREATE SCHEMA `todomangement` DEFAULT CHARACTER SET latin1 ;

CREATE TABLE `todomangement`.`tb_task_details` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(45) NOT NULL,
  `taskDescription` VARCHAR(150) NOT NULL,
  `targetDate` DATE NOT NULL,
  `isActive` TINYINT NOT NULL,
  `createdBy` VARCHAR(45) NOT NULL,
  `CreatedOn` DATE NOT NULL,
  `updatedBy` VARCHAR(45) NULL,
  `updatedOn` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `todomangement`.`tb_task_details` 
ADD COLUMN `taskStatus` VARCHAR(9) NOT NULL AFTER `targetDate`;
