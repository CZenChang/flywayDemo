CREATE TABLE `stay_time` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`date` DATE NOT NULL,
	`source` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`stay_time` DOUBLE(22,0) NOT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COMMENT='測試'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=0
;
