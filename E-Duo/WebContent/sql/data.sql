SELECT * FROM ALL_TABLES;
DROP TABLE NOTICE;
DROP TABLE PRODUCT;
DROP TABLE CONTACT;
DROP TABLE BOARD;
DROP TABLE MEMBER;
DROP TABLE STUDENT;
DROP TABLE UNIVERSITY;
DROP TABLE subject;
DROP TABLE my_subject;
DROP TABLE login_info;
DROP TABLE bulletin;
DROP TABLE reply;
CREATE TABLE login_info(
   stu_id   varchar(20)   PRIMARY KEY,
   password varchar(20) NOT NULL,
   auth   char(1)   DEFAULT 's'
);

SELECT * FROM login_info;
INSERT INTO login_info(stu_id, password) values('xvsgxv', 'wjdals159!');
INSERT INTO login_info(stu_id, password) values('student1', 'student1!');

CREATE TABLE student(
   stu_id   varchar(20) PRIMARY KEY,
   name varchar(30) NOT NULL,
   nickname varchar(30) NOT NULL,
   cellphone varchar(11) NOT NULL,
   postcode int NOT NULL,
   address varchar(300),
   detail_address varchar(300) NOT NULL,
   reference varchar(300),
   uni_id   int,
   email varchar(300) NOT NULL,
   gender varchar(1)
   CONSTRAINT student_gender_ck CHECK(gender IN('M', 'F')),
   birth   DATE NOT NULL,
   grade   int NOT NULL,
   semester int NOT NULL,
   obj_credit NUMBER(2, 1),
   graduate_credit int,
   CONSTRAINT student_id_fk FOREIGN KEY(stu_id) REFERENCES login_info(stu_id) ON DELETE CASCADE,
   CONSTRAINT student_uni_id_fk FOREIGN KEY(uni_id) REFERENCES university(uni_id) ON DELETE CASCADE
);
Insert into STUDENT values('xvsgxv', '장정민', '장사장비서', '01066387338', 16328, '경기 수원시 장안구 천천로 74번길 92', '822동 702호', '참조', 2, 'xvsgxv@gmail.com', 'M', '1998-01-23', 4, 2,'3.0',130);

SELECT * FROM student;

CREATE TABLE subject(
   sub_id   int   PRIMARY KEY,
   academic_number int NOT NULL,
   uni_id   int NOT NULL,
   subject_name varchar(100) NOT NULL,
   professor varchar(50),
   credit_num int,
   classroom varchar(100),
   start_time DATE NOT NULL,
   end_time DATE NOT NULL,
   CONSTRAINT subject_fk FOREIGN KEY(uni_id) REFERENCES university(uni_id) ON DELETE CASCADE
);
Insert into SUBJECT(sub_id, academic_number, uni_id, subject_name, professor, credit_num, classroom, start_time, end_time) values (1, 333, 2, '미적분학', '홍창훈', 3, '청운관', '2002-05-3', '2002-05-04');
Insert into SUBJECT(sub_id, academic_number, uni_id, subject_name, professor, credit_num, classroom, start_time, end_time) values (2, 433, 2, '미적분학2', '홍창훈', 3, '청운관2', '2002-05-3', '2002-05-04');
Insert into SUBJECT(sub_id, academic_number, uni_id, subject_name, professor, credit_num, classroom, start_time, end_time) values (3, 533, 2, '해석학', '홍창훈', 3, '청운관3', '2002-05-3', '2002-05-04');

Insert into SUBJECT values(1, 1000, 2, '한국어', '태보냥', 3, '청운관612호', );

CREATE TABLE university(
   uni_id   int PRIMARY KEY,
   uni_name varchar(100) NOT NULL UNIQUE
);
INSERT INTO university VALUES(1, '가천대학교');
INSERT INTO university VALUES(2, '경희대학교');

SELECT * FROM my_subject;
SELECT * FROM UNIVERSITY WHERE uni_name = '가천대학교';

CREATE TABLE my_subject(
   my_sub_id   int PRIMARY KEY,
   academic_number int NOT NULL UNIQUE,
   stu_id   varchar(20) NOT NULL,
   credit   NUMBER(2, 1) NOT NULL,
   grade   int NOT NULL,
   semester int NOT NULL,
   CONSTRAINT my_subject_fk FOREIGN KEY(stu_id) REFERENCES student(stu_id) ON DELETE CASCADE
);

insert into MY_SUBJECT(my_sub_id, academic_number, stu_id, credit, grade, semester) values(1, 333, 'xvsgxv', 3.3, 4, 2);
insert into MY_SUBJECT(my_sub_id, academic_number, stu_id, credit, grade, semester) values(2, 433, 'xvsgxv', 4.3, 4, 2);
insert into MY_SUBJECT(my_sub_id, academic_number, stu_id, credit, grade, semester) values(3, 533, 'xvsgxv', 3.7, 4, 2);

CREATE TABLE bulletin(
   bul_id   int PRIMARY KEY,
   stu_id   varchar(20) NOT NULL,
   nickname varchar(30) NOT NULL,
   category varchar(100) NOT NULL,
   title varchar(300) NOT NULL,
   content varchar(3000) NOT NULL,
   image varchar(1000),
   regDate   DATE DEFAULT SYSDATE,
   CONSTRAINT bulletin_fk FOREIGN KEY(stu_id) REFERENCES student(stu_id) ON DELETE CASCADE
);
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(1, 'xvsgxv', '장사자비서', 'info','안녕하세요1', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(2, 'xvsgxv', '장사자비서', 'info', '안녕하세요2', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(3, 'xvsgxv', '장사자비서', 'info', '안녕하세요3', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(4, 'xvsgxv', '장사자비서', 'fresh', '안녕하세요4', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(5, 'xvsgxv', '장사자비서', 'fresh', '안녕하세요5', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(6, 'xvsgxv', '장사자비서', 'fresh', '안녕하세요6', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(7, 'xvsgxv', '장사자비서', 'free', '안녕하세요7', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(8, 'xvsgxv', '장사자비서', 'free', '안녕하세요8', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(9, 'xvsgxv', '장사자비서', 'free', '안녕하세요9', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(10, 'xvsgxv', '장사자비서', 'ad', '안녕하세요10', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(11, 'xvsgxv', '장사자비서', 'ad', '안녕하세요11', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(12, 'xvsgxv', '장사자비서', 'ad', '안녕하세요12', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(13, 'xvsgxv', '장사자비서', 'job', '안녕하세요13', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(14, 'xvsgxv', '장사자비서', 'job', '안녕하세요14', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(15, 'xvsgxv', '장사자비서', 'job', '안녕하세요15', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(16, 'xvsgxv', '장사자비서', 'market', '안녕하세요16', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(17, 'xvsgxv', '장사자비서', 'market', '안녕하세요17', '반갑습니다1', '아모른직다');
INSERT into bulletin(bul_id, stu_id, nickname, category, title, content, image) values(18, 'xvsgxv', '장사자비서', 'market', '안녕하세요18', '반갑습니다1', '아모른직다');

SELECT * FROM bulletin;
CREATE TABLE reply(
   rep_id   int PRIMARY KEY,
   stu_id   varchar(20) NOT NULL,
   nickname varchar(30) NOT NULL,
   bul_id   int NOT NULL,
   content varchar(1000) NOT NULL,
   regDate   DATE DEFAULT SYSDATE,
   CONSTRAINT reply_id_fk FOREIGN KEY(stu_id) REFERENCES student(stu_id) ON DELETE CASCADE,
   CONSTRAINT reply_bul_id_fk FOREIGN KEY(bul_id) REFERENCES bulletin(bul_id) ON DELETE CASCADE
);
select * from Reply where bul_id = 7 order by regDate desc;
INSERT INTO reply(rep_id, stu_id, nickname, bul_id, content) values(1, 'xvsgxv', '장사자비서', 7, '오태호 바보');
INSERT INTO reply(rep_id, stu_id, nickname, bul_id, content) values(2, 'xvsgxv', '장사자비서', 7, '태보는 냥이');
INSERT INTO reply(rep_id, stu_id, nickname, bul_id, content) values(3, 'xvsgxv', '장사자비서', 7, '코딩 즐겁다');
DELETE from reply where bul_id = 7;
SELECT * FROM reply;
CREATE TABLE notice(
   not_id   int PRIMARY KEY,
   title varchar(300) NOT NULL,
   content varchar(3000) NOT NULL,
   regDate   DATE DEFAULT SYSDATE
);

CREATE TABLE enquiry(
   enq_id   int PRIMARY KEY,
   category varchar(100) NOT NULL,
   title varchar(300) NOT NULL,
   content varchar(1000) NOT NULL
);

CREATE TABLE FAQ(
   faq_id   int PRIMARY KEY,
   category varchar(100) NOT NULL,
   title varchar(300) NOT NULL,
   content varchar(1000) NOT NULL
);