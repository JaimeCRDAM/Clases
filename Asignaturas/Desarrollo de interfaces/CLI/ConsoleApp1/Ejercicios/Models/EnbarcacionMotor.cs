using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Ejercicios.Models
{
    public class EnbarcacionMotor : Barco
    {
        public int potencia { get; set; }
        public EnbarcacionMotor(string matricula, int eslora, int anoFabricacion, int potencia) : base(matricula, eslora, anoFabricacion)
        {
            this.potencia = potencia;
        }

        public override float Modulo()
        {
            return potencia;
        }
    }
}
