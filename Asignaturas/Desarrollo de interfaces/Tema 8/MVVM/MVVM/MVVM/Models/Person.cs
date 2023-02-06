using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MVVM.MVVM.Models
{
    public class Person
    {
		private string name;

		public string Name
		{
			get { return name; }
			set { name = value; }
		}
		private int age;

		public int Age
		{
			get { return age; }
			set { age = value; }
		}
		private bool married;

		public bool Married
		{
			get { return married; }
			set { married = value; }
		}
		private DateTime birthDate;

		public DateTime BirthDate
		{
			get { return birthDate; }
			set { birthDate = value; }
		}
		private int weight;

		public int Weight
		{
			get { return weight; }
			set { weight = value; }
		}
		private TimeSpan lunchTime;

		public TimeSpan LunchTime
		{
			get { return lunchTime; }
			set { lunchTime = value; }
		}



	}
}
