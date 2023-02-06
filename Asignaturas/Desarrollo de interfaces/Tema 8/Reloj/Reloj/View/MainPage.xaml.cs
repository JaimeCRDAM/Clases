using Reloj.ViewModel;
using System.Runtime.InteropServices.ObjectiveC;

namespace Reloj;

public partial class MainPage : ContentPage
{

	public MainPage()
	{
		
        InitializeComponent();
        MainPageViewModel cosa = new MainPageViewModel();
        BindingContext = cosa;

    }

	public void Button_Clicked(object sender, EventArgs e)
	{
		
	}
}

