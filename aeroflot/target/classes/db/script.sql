CREATE SCHEMA `aeroflot` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE `aeroflot`.`pilot`
(
    `id`            INT          NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(60)  NULL,
    `mail`          VARCHAR(100) NULL,
    `telephone`     VARCHAR(60)  NULL,
    `dayofbirthday` VARCHAR(60)  NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `aeroflot`.`manager`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `name`      VARCHAR(60) NULL,
    `telephone` VARCHAR(60) NULL,
    `mail`      VARCHAR(60) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `aeroflot`.`plane`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `brand`         VARCHAR(45) NULL,
    `class`         VARCHAR(45) NULL,
    `numberofseats` INT         NULL,
    `planecol`      VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `aeroflot`.`archive`
(
    `id`         INT NOT NULL AUTO_INCREMENT,
    `id_pilot`   INT NULL,
    `id_manager` INT NULL,
    `id_plane`   INT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_pilot`
        FOREIGN KEY (`id_pilot`)
            REFERENCES `aeroflot`.`pilot` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_manager`
        FOREIGN KEY (`id_manager`)
            REFERENCES `aeroflot`.`manager` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_plane`
        FOREIGN KEY (`id_plane`)
            REFERENCES `aeroflot`.`plane` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

INSERT INTO `aeroflot`.`plane` (`brand`, `class`, `numberofseats`) VALUES ('boing', 'super', '20');
INSERT INTO `aeroflot`.`plane` (`brand`, `class`, `numberofseats`) VALUES ('aero', 'comfort', '30');


INSERT INTO `aeroflot`.`pilot` (`name`, `mail`, `telephone`, `dayofbirthday`) VALUES ('Pavel', 'fghjk@.com', '7654457654', '13.12.1998');

INSERT INTO `aeroflot`.`manager` (`name`, `telephone`, `mail`) VALUES ('Kate', '87654567890', 'dfghjhg@.com');
INSERT INTO `aeroflot`.`manager` (`name`, `telephone`, `mail`) VALUES ('Alice', '656789', '45678@.com');


INSERT INTO `aeroflot`.`archive` (`id_pilot`, `id_manager`, `id_plane`) VALUES ('4', '1', '1');
INSERT INTO `aeroflot`.`archive` (`id_pilot`, `id_manager`, `id_plane`) VALUES ('6', '2', '2');
INSERT INTO `aeroflot`.`archive` (`id_pilot`, `id_manager`, `id_plane`) VALUES ('4', '2', '2');
INSERT INTO `aeroflot`.`archive` (`id_pilot`, `id_manager`, `id_plane`) VALUES ('6', '1', '1');
