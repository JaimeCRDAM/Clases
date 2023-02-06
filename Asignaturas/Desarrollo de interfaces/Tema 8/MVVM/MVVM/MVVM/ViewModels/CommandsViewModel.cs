using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace MVVM.MVVM.ViewModels
{
    public class CommandsViewModel
    {
        public ICommand ClickCommand =>
            new Command(() => App.Current.MainPage.DisplayAlert("Alert", "Clicked", "OK"));
        public ICommand SearchCommand => (
            
          new Command((s) => App.Current.MainPage.DisplayAlert("Alert", s.ToString(), "OK"))
        );
    }
}
