--textbook / textbook
-- 데이터 베이스 생성 == 사용자 계정 생성
-- 1. STSTEM(시스템)에서 계정, 암호, 권한을 준다
--           새로만드는 계정             암호
--create user textbook IDENTIFIED BY textbook;
-- 자바랑 연결될 수 있도록 권한 설정
--GRANT CONNECT,resource TO textbook;
-- 2. 초록색 +를 만들어 생성한다.(제목만 대문자 나머지는 소문자, orcl)

-- Ch01. Oracle & DataBase
--Relation DtatBase : 테이블과 테이블 사이의 관계를 통해서 저장, 검색하는 것
--DBMS: Oracle,MySQL,MS-SQL

--------------------------------
--삭제 명령어
--테이블을 지울 때는 자식 테이블을 먼저 지우고, 다음에 부모를 지운다.
drop table employee;
drop table department;
drop table salgrade;

commit;
rollback;--실행취소, 철회

--확인 명령어
select * from employee;
select * from department;
select * from salgrade;

-- 테이블 만들 때 부모테이블을 먼저 만들고 다음에 자식 테이블을 만들어야 한다.
-- 부서정보(부모 테이블)
-- dno : 부서 넘버
-- dname : 부서 이름
-- loc : 부서 지역
create table department(
 dno number(2)  primary key,
 dname varchar2(14),
 loc varchar2(13)
 );
 
-- 사원정보(자식 테이블)
-- eno : 사원 번호
-- ename : 사원 이름
-- job :업무명
-- manager : 매니저(소속 직속 상사)
-- hiredate : 입사 날짜
-- salary : 급여
--commission : 커미션(보너스)
-- DNO : 부서번호(부서 테이블에서 날라옴)

create table employee(
  eno number(4) primary key,
  ename varchar2(10),
  job varchar2(9),
  manager number(4),
  hiredate date,
  salary number(7, 2),
  commission number(7, 2),
  --외부에서 날라오는 자료
  dno number(2)references department(dno)
  );

select * from employee;

-- 급여정보
--grade : 급여 등급
-- losal : 급여 하한값
-- hisal : 급여 상한값
create table salgrade(
 grade number,
 losal number,
 hisal number
);

--
insert into department values(10,' ACCOUNTING','NEW YORK');
insert into department values(20,'RESEARCH','DALLAS');
insert into department values(30 ,'SALES','CHICAGO');
insert into department values(40,' OPERATIONS','BOSTON');

--
insert into employee values (7369,'SMITH','CLERK',    7902,to_date('17-12-1980','dd-mm-yyyy'),800,null,20);
insert into employee values(7499,'ALLEN','SALESMAN', 7698,to_date('20-2-1981', 'dd-mm-yyyy'),1600,300,30);
insert into employee values(7521,'WARD','SALESMAN',  7698,to_date('22-2-1981', 'dd-mm-yyyy'),1250,500,30);
insert into employee values(7566,'JONES','MANAGER',  7839,to_date('2-4-1981',  'dd-mm-yyyy'),2975, null,20);
insert into employee values(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981', 'dd-mm-yyyy'),1250,1400,30);
insert into employee values(7698,'BLAKE','MANAGER',  7839,to_date('1-5-1981',  'dd-mm-yyyy'),2850, null,30);
insert into employee values(7782,'CLARK','MANAGER',  7839,to_date('9-6-1981',  'dd-mm-yyyy'),2450, null,10);
insert into employee values(7788,'SCOTT','ANALYST',  7566,to_date('13-07-1987', 'dd-mm-yyyy'),3000, null,20);
insert into employee values(7839,'KING','PRESIDENT', NULL,to_date('17-11-1981','dd-mm-yyyy'),5000, null,10);
insert into employee values(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981',  'dd-mm-yyyy'),1500,0,30);
insert into employee values(7876,'ADAMS','CLERK',    7788,to_date('13-07-1987', 'dd-mm-yyyy'),1100, null,20);
insert into employee values(7900,'JAMES','CLERK',    7698,to_date('3-12-1981', 'dd-mm-yyyy'),950, null,30);
insert into employee values(7902,'FORD','ANALYST',   7566,to_date('3-12-1981', 'dd-mm-yyyy'),3000, null,20);
insert into employee values(7934,'MILLER','CLERK',   7782,to_date('23-1-1982', 'dd-mm-yyyy'),1300, null,10);

select * from employee;
--추가
--primary kwy 제약조건(eno): not null, 중복값x
--foreign Key 제약조건(dno) : 부모 테이블의 기본키(dno)를 하나의 컬럼으로 놓은 것
--   : 그 컬럼은 domain(10,20,30,40), 중복된값, null
insert into employee values(1000,'MILLER','CLERK',   7782,to_date('23-1-1982', 'dd-mm-yyyy'),1300, null,10);
insert into employee values(2000,'MILLER','CLERK',   7782,to_date('23-1-1982', 'dd-mm-yyyy'),1300, null,null);

--
insert into salgrade values (1,700,1200);
insert into salgrade values (2,1201,1400);
insert into salgrade values (3,1401,2000);
insert into salgrade values (4,2001,3000);
insert into salgrade values (5,3001,9999);


commit;
--30--------------------------------------------
desc department;--describe

select * from employee;
select eno,ename from employee;
--연봉구하기
-- salary(급여) 는 한달기준이기에 연봉을 구할려면 12를 곱해야함
select ename,salary, salary*12 from employee;

select ename,salary, salary*12,salary*12+commission
from employee;

--null + 10 = null //nvl : null값일 경우 0으로 변환
select ename,salary,job,dno,nvl(commission,0) 보너스, salary*12,salary*12+nvl(commission, 0)"연 봉"
from employee;
-- || 연결 연산자
select ename || ' is a ' || job from employee;
select ename, ' is a ', job from employee;

--distinct : 중복제거
select dno from employee;
select distinct dno from employee;

--직급 중복하지 않고 한번씩 출력 (distinct 활용)
select distinct job from employee;

--dual(듀얼) table가상 테이블
--dual : 한 행으로 결과를 출력하기 위해 제공되는 테이블
desc dual
select * from employee;
-- sysdate : 오늘이 몇칠인지 알아보는 함수
--employee : 14로우 만큼 14개가 출력
select sysdate from employee;
-- dual : 1로우만 출력
select sysdate from dual;