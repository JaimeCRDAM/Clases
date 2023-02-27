using Maui.BindableProperty.Generator.Core;
namespace Controles_reutilizables;

public partial class ControlPersonalizado : ContentView
{
	public ControlPersonalizado()
	{
		InitializeComponent();
        BindingContext = this;
    }
    [AutoBindable(PropertyName = "Title")]
    private readonly string _t;
    [AutoBindable(PropertyName = "Description")]
    private readonly string _d;
    [AutoBindable(PropertyName = "BackgroundColorButton")]
    private readonly Color _c;
    //public static readonly BindableProperty TitleProperty
    //         = BindableProperty.Create(
    //         "Title",
    //         typeof(String),
    //         typeof(ControlPersonalizado));
    //public String Title
    //{
    //    get => (String)GetValue(TitleProperty);
    //    set => SetValue(TitleProperty, value);
    //}
    //public static readonly BindableProperty BackgroundColorButtonProperty
    //         = BindableProperty.Create(
    //         "BackgroundColorButton",
    //         typeof(Color),
    //         typeof(ControlPersonalizado));
    //public Color BackgroundColorButton
    //{
    //    get => (Color)GetValue(BackgroundColorButtonProperty);
    //    set => SetValue(BackgroundColorButtonProperty, value);
    //}
    //public static readonly BindableProperty DescripcionProperty
    //         = BindableProperty.Create(
    //         "Descripcion",
    //         typeof(String),
    //         typeof(ControlPersonalizado));
    //public String Descripcion
    //{
    //    get => (String)GetValue(DescripcionProperty);
    //    set => SetValue(DescripcionProperty, value);
    //}
}