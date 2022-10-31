using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Ejercicios.Models
{
    static class Globals
    {
        static public T PreguntarInput<T>(string output)
        {
            T toReturn;
            bool preguntando = true;
            string input;

            Console.WriteLine(output);
            input = Console.ReadLine();

            while (true)
            {
                try
                {
                    toReturn = (T)Convert.ChangeType(input, typeof(T))!;
                    return toReturn;
                }
                catch (Exception)
                {
                    Console.WriteLine("Has escrito mal el dato pedido");
                }
            }
        }
    }
}
