using MVVM.MVVM.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace MVVM.MVVM.ViewModels
{
    public class PeopleViewModel : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        private List<Person> people = new();

        public List<Person> People
        {
            get { return people; }
            set {
                
                people = value;
                OnPropertyChanged();
            }
        }


        public PeopleViewModel()
        {
            People.Add(new Person { Name = "John", Age = 30, Married = true, BirthDate = new DateTime(2000, 08, 05), Weight = 100, LunchTime = new TimeSpan(10, 0, 0) });
            People.Add(new Person { Name = "Jane", Age = 25, Married = false, BirthDate = new DateTime(2005, 08, 05), Weight = 90, LunchTime = new TimeSpan(10, 0, 0) });
            People.Add(new Person { Name = "Jack", Age = 20, Married = false, BirthDate = new DateTime(2010, 08, 05), Weight = 80, LunchTime = new TimeSpan(10, 0, 0) });
            People.Add(new Person { Name = "Jill", Age = 15, Married = false, BirthDate = new DateTime(2015, 08, 05), Weight = 70, LunchTime = new TimeSpan(10, 0, 0) });
            People.Add(new Person { Name = "Joe", Age = 10, Married = false, BirthDate = new DateTime(2020, 08, 05), Weight = 60, LunchTime = new TimeSpan(10, 0, 0) });
        }

        
        protected void OnPropertyChanged([CallerMemberName] string propName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propName));
        }
    }
}
