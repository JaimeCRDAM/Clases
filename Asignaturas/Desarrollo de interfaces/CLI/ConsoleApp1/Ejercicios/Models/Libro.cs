using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace ConsoleApp1.Ejercicios.Models
{
    public class Libro : Reflection
    {
        static public int cantidad = 0;
        public string titulo { get; set; }
        public string autor { get; set; }
        public string estilo { get; set; }
        public string editorial { get; set; }
        private int id { get; set; }

        public Libro(string titulo, string autor, string estilo, string editorial, int id)
        {
            this.titulo = titulo;
            this.autor = autor;
            this.estilo = estilo;
            this.editorial = editorial;
            this.id = id;
            Libro.cantidad++;
        }

        public void ModificarLibro()
        {
            bool preguntando = true;
            PropertyInfo[] properties;
            string eleccion;
            PropertyInfo property = null;
            Type propertyType;

            while (preguntando)
            {

                properties = InfoProperties();
                (eleccion, property) = SelectProperty(properties);

                if (eleccion == "Salir")
                {
                    preguntando = false;
                    continue;
                }

                if (property == null)
                {
                    Console.WriteLine("Nombre Equivocado");
                    continue;
                }
                preguntando = false;
            }

            var newValue = Globals.PreguntarInput<string> ($"{property.Name} del libro");
            property.SetValue(this, newValue);
        }
        public override string ToString()
        {
            return JsonSerializer.Serialize(this);
        }
    }
}
