using layouts.controles;

namespace layouts;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		MainPage = new boxView();
	}
}
