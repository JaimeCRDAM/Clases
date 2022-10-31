//AVISO: TODO ESTE CÓDIGO SE PUEDE ESTRUCTURAR MEJOR EN DISTINTOS MÉTODOS

//Se inicailiza un flujo de archivo con la imagen seleccionada desde el disco, suponiendo que esa ruta se muestra en el campo txtRutaFichero
FileStream stream = new FileStream(txtRutaFichero.Text, FileMode.Open, FileAccess.Read);
//Se inicializa un vector de Bytes del tamaño de la imagen
byte[] binData = new byte[stream.Length];
//Lee el bloque de bytes del flujo y escribe los datos en un búfer dado.
stream.Read(binData, 0, Convert.ToInt32(stream.Length));

//Si tuviésemos un pictureBox, podríamos mostrar la imagen obtenida desde el flujo de datos
picFoto.Image = Image.FromStream(stream);

//AHORA LLEGA LA PARTE DE INSERCIÓN EN LA BD

MySqlConnection miconexion;
//Se coge la conexión guardada en el fichero app.xml del Proyecto
string cs = Settings.Default.HospitalConnectionString;
miconexion = new MySqlConnection(cs);
miconexion.Open();

MySqlCommand command = new MySqlCommand();
string SQL = "INSERT INTO `medicos` (`nombre`, `apellidos`, `movil`, `especialidad`, `foto`) VALUES (@nombre, @apellidos, @movil, @especialidad, @foto )";
command.CommandText = SQL;

//Se rellenan los parámetros que se van a pasar al INSERT con los valores correspondientes
command.Parameters.AddWithValue("@nombre", txtNombre.Text);
command.Parameters.AddWithValue("@apellidos", txtApellidos.Text);
command.Parameters.AddWithValue("@movil", txtMovil.Text);
command.Parameters.AddWithValue("@especialidad", txtEspecialidad.Text);
command.Parameters.AddWithValue("@foto", binData);

command.Connection = miconexion;
//Se ejecuta el comando, y se almacena el resultado por si ha habido un error
int result = command.ExecuteNonQuery();
if (result > 0)
	MessageBox.Show("Médico grabado con Exito", "Info Hospital", MessageBoxButtons.OK, MessageBoxIcon.Asterisk);
else
	MessageBox.Show("EL médico NO FUE GRABADO", "Info Hospital", MessageBoxButtons.OK, MessageBoxIcon.Error);

//Al final, se cierra siempre la conexión con la BD
miconexion.Close();