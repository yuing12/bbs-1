--[결과]
--2^3 = 8
--I I = OUT
------ a_exponent가 음수이면 값을 0으로 변경하고, 1을 반환한다.

create or replace PROCEDURE compute_power(
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
