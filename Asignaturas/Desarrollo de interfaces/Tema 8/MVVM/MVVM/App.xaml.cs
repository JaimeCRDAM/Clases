using MVVM.MVVM.Views;

namespace MVVM;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		MainPage = new CommandsView();
	}
}
