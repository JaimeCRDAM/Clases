using MVVM.MVVM.ViewModels;

namespace MVVM.MVVM.Views;

public partial class ConvertersView : ContentPage
{
	public ConvertersView()
	{
		InitializeComponent();
        BindingContext = new ConvertersViewModel();
    }
}