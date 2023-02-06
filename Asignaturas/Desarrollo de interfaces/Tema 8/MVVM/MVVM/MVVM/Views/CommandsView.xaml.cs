using MVVM.MVVM.ViewModels;
namespace MVVM.MVVM.Views;


public partial class CommandsView : ContentPage
{
	public CommandsView()
	{
		InitializeComponent();
		BindingContext = new CommandsViewModel();
	}
}