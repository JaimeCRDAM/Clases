namespace Lista_de_la_Compra.MVVM.Views;

public partial class BaseContentPage : ContentPage
{
	public BaseContentPage()
	{
		InitializeComponent();
		
		BindingContext = App.Lista;
	}
}