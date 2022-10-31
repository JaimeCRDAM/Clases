using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Ejercicios.Models
{
    public class Velero : Barco
    {
        public int mastiles { get; set; }
        public Velero(string matricula, int eslora, int anoFabricacion, int mastiles) : base(matricula, eslora, anoFabricacion)
        {
            this.mastiles = mastiles;
        }

        public override float Modulo()
        {
            return mastiles+eslora*10;
        }
    }
}
