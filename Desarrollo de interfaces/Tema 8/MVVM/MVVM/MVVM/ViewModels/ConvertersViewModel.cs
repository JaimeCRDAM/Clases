using MVVM.MVVM.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MVVM.MVVM.ViewModels
{


	public class ConvertersViewModel
    {
        private Data data;

        public Data Data
        {
            get { return data; }
            set { data = value; }
        }
        public ConvertersViewModel()
        {
            Data = new Data { Married = "Yes" };
        }

    }
}
