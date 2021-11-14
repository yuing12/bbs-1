--ch02. 데이터 조회하기
-- 테이블 이름 조회
select * from tab; --table

-- 문자열 데이터 조회
--오라클 자체에선 대소문자 구분을 안하는데 딱 두군데만 구분함(문자열/날짜, 데이터베이스 비밀번호)
--문자열,날짜 : 작은따옴표('') 사용, 대소문자 구분
--whrer : 조건
--       나타날 칼럼명들 from 테이블이름 where(어디) 검색할 칼럼='명';
SELECT eno,ename,salary from employee where ename ='ford'; --X 대문자로 해야함
SELECT eno,ename,salary from employee where ename ='FORD';
-- 해석 : 테이블에 ford이라는 ename이 있는데 이게 맞으면 eno,ename,salary자료를 출력하라
SELECT eno,ename,salary from employee where ename ="FORD"; --X "(큰따움표)안됨
--hiredate : 입사 날짜; '1982/01/01보다 이전에 입사한 사람을 출력하시오.
select * from employee where hiredate <= '1982/01/01';

--논리연산자(AND,OR,NOT)
--예)2000~3000 급여를 받는 사원에 대한 정보 출력?
select *
from employee
where salary >= 2000 and salary <= 3000;

select *
from employee
where salary between  2000 and  3000;

--예)2000이하 이거나 3000이상 급여를 받는 사원에 대한 정보 출력?
select *
from employee
where salary <= 2000 or salary >= 3000;

--예) 200이하 이거나(or) 3000이상의 급여를 받는 사원에 대한 정보 출력
select * -- *는 모든정보를 말함. 
from employee 
where salary<=2000 or salary>=3000;

--예) 200이하 이거나(or) 3000이상의 급여를 받는 사원에 대한 정보 출력
select * -- *는 모든정보를 말함. 
from employee 
where salary between 2000 and 3000;

--in: 특정값이 하나라도 일치하면 참
select * from employee where commission in(300,500,1400);
--commission이 300,500,1400아닌 사원검색?
select * from employee where commission not in(300,500,1400);

--<> : 같지 않다라는 의미로 쓰이는 연산자
select * 
from employee 
where commission <>300 and commission <> 500 and commission <>1400;
--Like(%,_)
--%:여러문자를 포함, _ : 하나의 문자만을 포함
 select * from employee where ename='F';
 select * from employee where ename LIKE'F%';
select * from employee where ename LIKE'%A%';
select * from employee where ename not LIKE'%A%';
select * from employee where ename  LIKE'_A%';

--null : 0도 아니고 공백도 아닌, 알수없는 어떤 값(=unknown)
-- 연산,할당,비교 불가능(null+10, null = 10, null>10)
select * from employee where commission = null;--X
select * from employee where commission is null;--
select * from employee where commission is not null;--
select * from employee where commission <> null;--X

--order by
--ascending(오름차순)-null은 가장 나중에, descending(내림차순)-null이 가장 먼저
select * from employee order by commission desc;
select * from employee order by commission desc, eno asc;

--(예)상관(상사)이 없는 사원 검색?
select *from employee where manager is null;