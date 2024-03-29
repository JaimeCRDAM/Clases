using Maui.BindableProperty.Generator.Core;

namespace CONTRO_REUSABLE_Jaime_Cano;

public partial class PersonalCard : ContentView
{
    [AutoBindable(PropertyName = "StudyCenter")]
    private readonly string _SC;
    [AutoBindable(PropertyName = "AlumnName")]
    private readonly string _AN;
    [AutoBindable(PropertyName = "BornDate")]
    private readonly string _BD;
    [AutoBindable(PropertyName = "ImgSource")]
    private readonly string _IS;
    public PersonalCard()
	{
		InitializeComponent();
		BindingContext = this;
	}

}