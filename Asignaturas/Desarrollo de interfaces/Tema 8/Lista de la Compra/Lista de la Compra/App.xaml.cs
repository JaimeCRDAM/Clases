using Lista_de_la_Compra.MVVM.Models;

namespace Lista_de_la_Compra;

public partial class App : Application
{
    public static ListaItems Lista { get; private set; }
    public App(ListaItems listaItems)
	{
		InitializeComponent();
        Lista = listaItems;
        MainPage = new AppShell();
	}
}
