use ssafydb;
drop table if exists `restaurant`; 
drop table if exists `user`; 
drop table if exists `review`; 

-- -----------------------------------------------------
-- Table `restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE IF NOT EXISTS `restaurant` (
  `resId` INT NOT NULL,
  `resName` VARCHAR(45) NOT NULL,
  `resAddress` VARCHAR(45) NOT NULL,
  `signatureMenu` VARCHAR(45) NOT NULL,
  `resRate` INT NOT NULL,
  `fileName` VARCHAR(200) NULL,
  `fileUri` VARCHAR(200) NULL,
  PRIMARY KEY (`resId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userId` VARCHAR(45) NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `userPass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `reviewId` INT AUTO_INCREMENT NOT NULL,
  `resId` INT NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`reviewId`)
) ENGINE = InnoDB;


INSERT INTO restaurant
VALUES
(101, "을밀대", "서울", "물냉면", 9, NULL, NULL),
(102, "도꼭지", "서울", "도미솥밥", 8, NULL, NULL),
(401, "도마29", "대구", "연어초밥", 8, NULL, NULL),
(601, "성심당", "대전", "튀김소보로", 8, NULL, NULL);

INSERT INTO review
VALUES
(1, 101, "김싸피", "맛있어요~!"),
(2, 101, "박싸피", "깔끔합니다!!"),
(3, 401, "이싸피", "역시 연어초밥 최고"),
(4, 601, "최싸피", "대전갈 때 마다 꼭 들리는 곳!");


INSERT INTO user
VALUES
("ssafy", "김싸피", "1234"),
("park", "박싸피", "1357"),
("lee", "이싸피", "2468"),
("choi", "최싸피", "4321");


