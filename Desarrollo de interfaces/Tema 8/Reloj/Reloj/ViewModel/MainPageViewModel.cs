using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Reloj.ViewModel
{

    public class MainPageViewModel:INotifyPropertyChanged
    {

        private List<string> days = new();

        public event PropertyChangedEventHandler PropertyChanged;

        public List<string> Days
        {
            get { return days; }
            set {
                days = value;
                OnPropertyChanged();
            }
        }
        
        public MainPageViewModel()
        {
            days.Add("Lunes");
            days.Add("Martes");
            days.Add("Miercoles");
            days.Add("Jueves");
            days.Add("Viernes");
            days.Add("Sabado");
            days.Add("Domingo");
            
        }
        
        protected void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
