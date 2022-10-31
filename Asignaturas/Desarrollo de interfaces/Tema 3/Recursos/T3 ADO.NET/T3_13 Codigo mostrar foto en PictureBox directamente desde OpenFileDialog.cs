private void btnExaminar_Click(object sender, EventArgs e)
{
	//Suponemos que ofdExaminar es un OpenFileDialog incorporado al formuylario
	ofdExaminar.Filter = "image files|*.jpg;*.png;*.gif;*.ico;.*;";
	
	DialogResult dres = ofdExaminar.ShowDialog();
	
	if (dres == DialogResult.Abort)
		return;
	if (dres == DialogResult.Cancel)
		return;
	
	//para guardar la ruta al fichero con la imagen en un TextBox (por si se quiere mostrar)
	txtRutaFichero.Text = ofdExaminar.FileName;
	
	//Se muestra la imagen en el PictureBox directamente de la ruta devuelta por el OpenFileDialog
	picFoto.Image = Image.FromFile(ofdExaminar.FileName);
}