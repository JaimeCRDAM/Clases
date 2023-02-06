using MVVM.MVVM.ViewModels;
namespace MVVM.MVVM.Views;

public partial class PeopleView : ContentPage
{
	public PeopleView()
	{
		InitializeComponent();
        BindingContext = new PeopleViewModel();
    }
}