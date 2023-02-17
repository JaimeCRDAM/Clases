using Sqlite.MVVM.ViewModel;
using Sqlite;
using System.Windows.Input;

namespace Sqlite.MVVM.Views;

public partial class MainPage : ContentPage
{
	public MainPage()
	{

        InitializeComponent();
        BindingContext = new MainPageViewModel();
    }


}