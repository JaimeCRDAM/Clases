using MVVM.MVVM.ViewModels;
namespace MVVM.MVVM.Views;



public partial class PersonView : ContentPage
{
	public PersonView()
	{
		InitializeComponent();
		BindingContext = new PersonViewModel();
	}
}