using Maui_databinding.Modelos;

namespace MauiDataBinding;

public partial class MainPage : ContentPage
{
	int count = 0;

	public MainPage()
	{
		InitializeComponent();
	}

    private void btnProbarOnClick(object sender, EventArgs e)
    {
        Persona persona = new()
        {
            nombre = "Jaime",
            telefono = "123456789",
            domicilio = "Calle 123"
        };
        Binding personaBinding = new Binding();
        personaBinding.Source = persona;
        personaBinding.Path = "nombre";
        txtNombre.SetBinding(Label.TextProperty, personaBinding);
    }
}

