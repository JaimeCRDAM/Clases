using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MVVM.MVVM.Models;

namespace MVVM.MVVM.ViewModels
{


	public class PersonViewModel
    {
        private Person person;

        public Person Person
        {
            get { return person; }
            set { person = value; }
        }
        public PersonViewModel()
        {
            Person = new()
            {
                Name = "John",
                Age = 30,
                Married = true,
                BirthDate = new DateTime(2000, 08, 05),
                Weight = 100,
                LunchTime = new TimeSpan(10, 0, 0)
            };
        }
    }
}
