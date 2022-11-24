delimiter //
CREATE OR REPLACE FUNCTION nomina(salario double, comision double, irpf double)
	RETURNS double
begin
    return (salario + comision) - ((salario + comision)*irpf)/100;
End;//