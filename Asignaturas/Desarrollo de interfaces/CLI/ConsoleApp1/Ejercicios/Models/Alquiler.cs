using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Ejercicios.Models
{
    public class Alquiler
    {
        public string dni { get; set; }
        public DateTime fechaInicial { get; set; }
        public DateTime fechaFinal { get; set; }
        public Barco barco { get; set; }
        public Alquiler(string dni, DateTime fechaInicial, DateTime fechaFinal, Barco barco)
        {
            this.dni = dni;
            this.fechaInicial = fechaInicial;
            this.fechaFinal = fechaFinal;
            this.barco = barco;
        }

        public float GetPrecio()
        {
            var dias = fechaFinal.Subtract(fechaInicial);
            return barco.Modulo()*(float)dias.TotalDays*12;
        }
    }
}
