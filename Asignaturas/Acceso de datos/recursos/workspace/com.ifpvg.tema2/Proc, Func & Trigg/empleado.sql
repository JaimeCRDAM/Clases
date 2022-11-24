delimiter //
CREATE OR REPLACE FUNCTION empleado(d int)
	RETURNS varchar(15) deterministic
begin
	declare n varchar(15);
	select count(*) into n from empleados where
	dept_no=d;
	return n;

End;//