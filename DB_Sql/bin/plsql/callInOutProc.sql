--[결과]
--p2 :ab
--p3 :a


create or replace PROCEDURE javatest(
  p1 IN varchar2,
  p2 IN out varchar2,
  p3 out varchar2) as
BEGIN
	p2 := p1 || p2;
	p3 := p2;

END ;