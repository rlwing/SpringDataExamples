create database jokes;

CREATE TABLE `jokes`.`jokes` (
    `joke_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `category` varchar(50),
    `joke` longtext,
    `source` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`joke_id`)
);

INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('KIDJOKES','Why did the chicken cross the road?\nTo get to the other side!','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('KIDJOKES','Dirty Joke: The boy fell into the mud.\nClean Joke: He took a shower!','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('DADJOKES','My wife is so negative. I remembered the car seat, the stroller, AND the diaper bag. Yet all she can talk about is how I forgot the baby.!','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('DADJOKES','Q. Why did the scarecrow win an award?\nA. Because he was outstanding in his field.','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('MOMJOKES','Don’t wake up mom! There are at least seven species who eat their young. Your mom may be one of them.','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('MOMJOKES','You know you’re a mom when…\n\n…picking up another human to smell their butt is not only normal but totally necessary','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('KNOCKKNOCK','Knock! Knock!\nWho’s there?\nSays.\nSays who?\nSays me, that’s who!','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('TECHNOLOGY','Q. How did the programmer die in the shower?\nA. He read the shampoo bottle instructions: Lather. Rinse. Repeat.','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('TECHNOLOGY','How many programmers does it take to change a light bulb?\nNone – It’s a hardware problem','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('TECHNOLOGY','Why do programmers always mix up Halloween and Christmas?\nBecause Oct 31 equals Dec 25.','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('TECHNOLOGY','Knock, knock.\nWho’s there?\nvery long pause….\nJava.','Postman');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('DADJOKES','test-joke','test-source');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('KIDJOKES','Why did the chicken cross the road? To get to the other side!','JunitTest');
INSERT INTO `jokes`.`jokes` (`category`,`joke`,`source`) VALUES ('KIDJOKES','Why did the chicken cross the road? To get to the other side!','JunitTest');
