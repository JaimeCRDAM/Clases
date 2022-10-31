using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Ejercicios.Models
{
    public abstract class Barco {
        public string matricula { get; set; }
        public int eslora { get; set; }
        public int anoFabricacion { get; set; }
        public Barco(string matricula, int eslora, int anoFabricacion)
        {
            this.matricula = matricula;
            this.eslora = eslora;
            this.anoFabricacion = anoFabricacion;
        }

        public abstract float Modulo();
    }
}
