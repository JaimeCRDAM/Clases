using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Ejercicios.Models
{
    public class YateLujo : Barco
    {
        public int potencia { get; set; }
        public int camarote { get; set; }
        public YateLujo(string matricula, int eslora, int anoFabricacion, int potencia, int camarote) : base(matricula, eslora, anoFabricacion)
        {
            this.potencia = potencia;
            this.camarote = camarote;
        }

        public override float Modulo()
        {
            return potencia + camarote;
        }
    }
}
