using Maui.BindableProperty.Generator.Core;

namespace MauiLib1;

public partial class PersonalCard : ContentView
{
	public PersonalCard()
	{
		InitializeComponent();
		BindingContext = this;
	}
	[AutoBindable(PropertyName = "StudyCenter")]
	private readonly string _SC;
    [AutoBindable(PropertyName = "AlumnName")]
    private readonly string _AN;
    [AutoBindable(PropertyName = "BornDate")]
    private readonly string _BD;
}