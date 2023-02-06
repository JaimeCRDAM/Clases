using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Maui_databinding.Modelos
{
    public class Persona : INotifyPropertyChanged
    {
        private string Nombre;

        public string nombre
        {
            get { return Nombre; }
            set { Nombre = value; }
        }
        private string Telefono;

        public string telefono
        {
            get { return Telefono; }
            set { Telefono = value; }
        }
        private string Domicilio;

        public string domicilio
        {
            get { return Domicilio; }
            set { Domicilio = value; }
        }


        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged([CallerMemberName] string propName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propName));
        }
    }
}
