/*
 * Execute this script before before run the app 
 * Database: MySQL
 * 
 * Author: Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */

DROP TABLE IF EXISTS `blog`.`contact`;
CREATE TABLE  `blog`.`contact` (
  `CONTACT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTACT_EMAIL` varchar(255) NOT NULL,
  `CONTACT_NAME` varchar(255) NOT NULL,
  `CONTACT_PHONE` varchar(255) NOT NULL,
  PRIMARY KEY (`CONTACT_ID`)
) 
ENGINE=InnoDB;

insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact0','(000) 000-0000', 'contact0@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact1', '(000) 000-0000', 'contact1@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact2', '(000) 000-0000', 'contact2@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact3', '(000) 000-0000', 'contact3@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact4', '(000) 000-0000', 'contact4@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact5', '(000) 000-0000', 'contact5@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact6', '(000) 000-0000', 'contact6@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact7', '(000) 000-0000', 'contact7@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact8', '(000) 000-0000', 'contact8@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact9', '(000) 000-0000', 'contact9@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact10', '(000) 000-0000', 'contact10@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact11', '(000) 000-0000', 'contact11@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact12', '(000) 000-0000', 'contact12@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact13', '(000) 000-0000', 'contact13@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact14', '(000) 000-0000', 'contact14@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact15', '(000) 000-0000', 'contact15@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact16', '(000) 000-0000', 'contact16@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact17', '(000) 000-0000', 'contact17@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact18', '(000) 000-0000', 'contact18@loianetest.com');
insert into CONTACT (CONTACT_NAME, CONTACT_PHONE, CONTACT_EMAIL) values ('Contact19', '(000) 000-0000', 'contact19@loianetest.com');
