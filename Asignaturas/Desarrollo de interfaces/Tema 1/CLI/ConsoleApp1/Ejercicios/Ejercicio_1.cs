using ConsoleApp1.Ejercicios.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Reflection;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Ejercicios
{
    public class Ejercicio_1 : Reflection
    {
        public Ejercicio_1()
        {
            bool preguntando = true;
            while (preguntando)
            {

                var methods = InfoMethods();
                var (eleccion, metodo) = SelectMethod(methods);

                if (eleccion == "Salir"){
                    preguntando = false;
                    continue;

                }

                if (metodo == null)
                {
                    Console.WriteLine("Nombre Equivocado");
                    continue;
                }
                metodo.Invoke(this, null);
            }
        }

        private void diaSemana()
        {
            Console.WriteLine("Escribe un dia y te digo a que semana pertenece (1-31)");
            string? input = Console.ReadLine();
            int inputAsInt;
            inputAsInt = Int32.Parse(input);
        }
        private void incrementarFecha()
        {
            Console.WriteLine("Dame una fecha formato dd/mm/aa");
            string input = Console.ReadLine();
            DateTime fechaIncrementar = Convert.ToDateTime(input);
            fechaIncrementar.AddDays(2);
            Console.WriteLine(fechaIncrementar.ToString());
        }
        private void diferenciaFechas()
        {
            Console.WriteLine("Dame una fecha formato dd/mm/aa");
            DateTime input = Convert.ToDateTime(Console.ReadLine());
            Console.WriteLine("Dame otra fecha (mayor a la anterior) formato dd/mm/aa");
            DateTime input2 = Convert.ToDateTime(Console.ReadLine());

            Console.WriteLine("{2}/{1}/{0}",
                     input2.Year - input.Year,
                     input2.Month - input.Month,
                     input2.Day - input.Day);
        }
        private void comparaFechas()
        {
            Console.WriteLine("Dame una fecha formato dd/mm/aa");
            DateTime input = Convert.ToDateTime(Console.ReadLine());
            Console.WriteLine("Dame otra fecha formato dd/mm/aa");
            DateTime input2 = Convert.ToDateTime(Console.ReadLine());
            string primeraOSegunda;
            if (input < input2)
            {
                Console.WriteLine("Es menor");
            }
            if (input > input2)
            {
                Console.WriteLine("Es mayor");
            }
            if (input == input2)
            {
                Console.WriteLine("Es igual");
            }
        }
        private void formatoLargo()
        {
            Console.WriteLine("Dame una fecha formato dd/mm/aa");
            DateTime input = Convert.ToDateTime(Console.ReadLine());
            Console.WriteLine(input.ToLongDateString());
        }
    }
}