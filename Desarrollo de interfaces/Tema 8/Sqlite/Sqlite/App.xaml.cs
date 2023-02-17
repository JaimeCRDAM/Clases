using MVVM.Models;
using Sqlite.MVVM.Models;
using Sqlite.MVVM.Views;
using Sqlite.Repositories;

namespace Sqlite;

public partial class App : Application
{
    public static BaseRepository<Customer> CustomerRepo { get; private set; }
    public static BaseRepository<Order> OrderRepo { get; private set; }
    public static BaseRepository<Passport> PassportRepo { get; private set; }
	
    public App(BaseRepository<Customer> repo,
				BaseRepository<Order> ordersRepo,
                BaseRepository<Passport> passportRepo)
    {
		
	
		InitializeComponent();
		
		CustomerRepo = repo;
        OrderRepo = ordersRepo;
        PassportRepo = passportRepo;

        MainPage = new MainPage();
	}
}
