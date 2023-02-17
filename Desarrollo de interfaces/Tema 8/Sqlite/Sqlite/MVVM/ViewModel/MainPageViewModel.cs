using Bogus;
using MVVM.Models;
using PropertyChanged;
using Sqlite.MVVM.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Sqlite.MVVM.ViewModel
{
    [AddINotifyPropertyChangedInterface]
    public class MainPageViewModel
    {
        public List<Customer> Customers { get; set; }
        public Customer CurrentCustomer { get; set; }
        public ICommand AddOrUpdateCommand { get; set; }
        public ICommand DeleteCommand { get; set; }

        public MainPageViewModel()
        {
            RefreshCustomers();
            GenerateNewCustomer();
            AddOrUpdateCommand = new Command(async () =>
            {
                App.CustomerRepo.SaveItemWithChildren(CurrentCustomer);
                GenerateNewCustomer();
                RefreshCustomers();
            });
            DeleteCommand = new Command(async () =>
            {
                App.CustomerRepo.DeleteItemWithChildren(CurrentCustomer);
                RefreshCustomers();
                GenerateNewCustomer();
            });
        }
        private void GenerateNewCustomer()
        {
            CurrentCustomer = new Faker<Customer>()
                .RuleFor(x => x.Name, f => f.Person.FullName)
                .RuleFor(x => x.Address, f => f.Person.Address.Street)
                .Generate();
            CurrentCustomer.Passport = new List<Passport>
            {
                new Faker<Passport>()
                .RuleFor(x => x.ExpirationDate, f => f.Date.Future())
                .Generate(),
                new Faker<Passport>()
                .RuleFor(x => x.ExpirationDate, f => f.Date.Future())
                .Generate()
        };
        }
        private void RefreshCustomers()
        {
            //Customers = App.CustomerRepo.GetItems();
            Customers = App.CustomerRepo.GetItemsWithChildren();
        }
    }
}
