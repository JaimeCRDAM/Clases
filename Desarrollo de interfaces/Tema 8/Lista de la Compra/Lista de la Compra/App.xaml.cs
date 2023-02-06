namespace Lista_de_la_Compra;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		MainPage = new NavigationPage(new MainPage());
	}
}
