using Maui_databinding.Modelos;

namespace Databinding;

public partial class MainPage : ContentPage
{
    int count = 0;
    Persona persona;
    public MainPage()
    {
        InitializeComponent();
        persona = new()
        {
            nombre = "Jaime",
            telefono = "123456789",
            domicilio = "Calle 123"
        };
        BindingContext = persona;
    }

    private void btnProbarOnClick(object sender, EventArgs e)
    {
        persona = new()
        {
            nombre = "Alfredo",
            telefono = "987654321",
            domicilio = "Calle 321"
        };
    }
}

