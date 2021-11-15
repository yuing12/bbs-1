

--삭제
drop table mebmer2;

--테이블 만들기
create table member2(
id VARCHAR2(15) primary key,
password varchar2(10),
name varchar2(10),
age number,
gender varchar2(5),
email varchar2(30)
);

--테이블에 데이터 넣기
--아이디, 비밀번호, 이름, 나이, 성별, 이메일
-- 한글을 표현하는데 3바이트?(오라클 버전에 따라 다름)
insert into member2 values('hong2','1234','hongkil',20,'남','hong@hong.com');
-- 자동 커밋

select * from member2;


--------------------------------------------------

create table goodsinfo(
  code char(5) not null primary key,
  name varchar2(30) not null, 
  price number(8) not null,
  maker varchar2(20)
);

insert into goodsinfo values('10001', '디지털 TV', 35000, 'LG');
insert into goodsinfo values('10002', 'LCD TV', 135000, '삼성');
insert into goodsinfo values('10003', 'LED TV', 235000, 'LG');
insert into goodsinfo values('10004', 'UHD TV', 335000, '삼성');
insert into goodsinfo values('10005', 'OLED TV',435000, 'LG');

commit;
