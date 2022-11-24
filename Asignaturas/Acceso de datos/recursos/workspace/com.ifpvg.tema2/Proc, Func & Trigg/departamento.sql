delimiter//
CREATE OR REPLACE FUNCTION departamento(d int)
RETURNS varchar(15) deterministic
begin
declare n varchar(15);
select dnombre into n from departamentos where
dept_no=d;
return n;
End;//