//Una vez ejecutada la consulta sobre la tabla médicos, y cargado el DataSet correspondiente
//1º Se comprueba si en esa tabla devuelta con la consulta sobre los médicos hay algún registro
if (dsBD.Medicos.Rows.Count > 0)
{
	//Inicializamos una fila de datos en la cual se almacenaran todos los datos de la fila seleccionada
	//En este ejemplo nos quedamos con la primera
	DataRow myRow = dsBD.Medicos.Rows[0];

	//Se almacena el campo foto de la tabla en el array de bytes
	MyData = (byte[])myRow["foto"];
	//Se inicializa un flujo en memoria del array de bytes
	MemoryStream stream = new MemoryStream(MyData);
	//En el picture box se muestra la imagen que esta almacenada en el flujo en memoria 
	//el cual contiene el array de bytes
	picFoto.Image = Image.FromStream(stream);
}