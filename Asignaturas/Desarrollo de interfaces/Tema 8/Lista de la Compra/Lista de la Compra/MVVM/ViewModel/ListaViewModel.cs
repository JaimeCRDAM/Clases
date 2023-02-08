using Lista_de_la_Compra.MVVM.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lista_de_la_Compra.MVVM.ViewModel
{
    public class ListaViewModel
    {
        public ListaItems Items; 
        public ListaViewModel()
        {
            Items = App.Lista;
        }
        
    }
}
