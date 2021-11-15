-- 연동DB : javalink / javalink
-- 테이블을 생성
create table mms_member(
 id NUMBER PRIMARY KEY,
 name VARCHAR2(12) UNIQUE NOT NULL,
 Addr VARCHAR2(50) NOT NULL,
 nation VARCHAR2(12) NOT NULL,
 email VARCHAR2(30) NOT NULL,
 age NUMBER null

);

--sequence(시퀸스 생성)
create sequence member_id_seq;