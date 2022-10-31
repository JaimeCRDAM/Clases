using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;
using ConsoleApp1.Ejercicios.Models;

namespace ConsoleApp1.Ejercicios
{
    public class Ejercicio_2 : Reflection
    {
        public Dictionary<int, Libro> biblioteca { get; set; }
        public Ejercicio_2()
        {
            biblioteca = new Dictionary<int,Libro>();
            bool preguntando = true;
            while (preguntando)
            {

                var methods = InfoMethods();
                var (eleccion, metodo) = SelectMethod(methods);

                if (eleccion == "Salir")
                {
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



        private void InsertarLibro()
        {
            var titulo = Globals.PreguntarInput<string>("Titulo del libro");
            var autor = Globals.PreguntarInput<string>("Autor del libro");
            var estilo = Globals.PreguntarInput<string>("Estilo del libro");
            var editorial = Globals.PreguntarInput<string>("Editorial del libro");
            biblioteca.Add(Libro.cantidad, new Libro(titulo, autor, estilo, editorial, Libro.cantidad));
        }

        private void VerListadoLibros()
        {
            foreach (var libro in biblioteca)
            {
                Console.WriteLine(libro.ToString());
            }
        }

        private void ModificarLibro()
        {
            int numeroLibro = 0;
            bool preguntando = true;
            Libro? libroSeleccionado = null;
            while (preguntando)
            {
                try
                {
                    VerListadoLibros();
                    numeroLibro = Globals.PreguntarInput<int>("Numero del libro");
                    preguntando = false;
                }
                catch (Exception)
                {
                }
            }

            biblioteca.TryGetValue(numeroLibro, out libroSeleccionado);
            libroSeleccionado.ModificarLibro();

        }
        private void EliminarLibro()
        {
            int numeroLibro = 0;
            bool preguntando = true;

            while (preguntando)
            {
                try
                {
                    VerListadoLibros();
                    numeroLibro = Globals.PreguntarInput<int>("Numero del libro a eliminar");
                    preguntando = false;
                }
                catch (Exception)
                {
                }
            }

            biblioteca.Remove(numeroLibro);
        }
    }

}
