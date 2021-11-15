

create or replace PROCEDURE member2 (
  a_num IN number,
  a_exponent IN OUT number,
  a_power OUT number

)
IS
BEGIN
	IF(a_exponent<0) THEN
      a_exponent := 0;
	END if;
	a_power := 1;
	
	for i IN 1..a_exponent loop
	a_power := a_power*a_num;
	END loop;
	
END ;