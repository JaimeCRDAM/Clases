delimiter //
CREATE OR REPLACE FUNCTION iva(precio double, iva double)
	RETURNS double
begin
    return precio * 1 + (iva/100);

End;//