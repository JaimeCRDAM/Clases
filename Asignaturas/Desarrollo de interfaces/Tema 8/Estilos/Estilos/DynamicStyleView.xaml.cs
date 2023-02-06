namespace Estilos;

public partial class DynamicStyleView : ContentPage
{
	public DynamicStyleView()
	{
		InitializeComponent();
	}

    public void Button_Clicked(object sender, EventArgs e)
    {
		Resources["dynamicStyle"] = Resources["greenStyle"];
	}
}