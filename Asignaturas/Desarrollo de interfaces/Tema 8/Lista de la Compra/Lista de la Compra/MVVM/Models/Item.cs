using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lista_de_la_Compra.MVVM.Models
{
    public class Item
    {
        public string Nombre { get; set; }
        public int Cantidad { get; set; }
        public bool Comprado { get; set; }
    }
}
