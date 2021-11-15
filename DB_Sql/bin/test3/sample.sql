--javalink/javalink

--삭제
drop table product;

--테이블 만들기
create table product(
num number(10) primary key,
name VARCHAR2(20),
price number(10)
);


--sequence
drop sequence product_num_seq;
create sequence product_num_seq
start with 0 -- 시작값
increment by 1 --증가값
minvalue 0;k;