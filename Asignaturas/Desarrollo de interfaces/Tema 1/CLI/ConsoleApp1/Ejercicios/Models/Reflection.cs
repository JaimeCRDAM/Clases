using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1.Ejercicios.Models
{
    public class Reflection
    {
        public MethodInfo[] InfoMethods()
        {
            Console.WriteLine("Estos son los metodos disponibles, escribe Salir para salir de este ejercicio");
            Type type = GetType();
            MethodInfo[] methods = type.GetMethods(BindingFlags.NonPublic | BindingFlags.Instance | BindingFlags.DeclaredOnly);
            foreach (var method in methods)
            {
                Console.WriteLine(method.Name);
            }
            return methods;
        }
        public (string, MethodInfo) SelectMethod(MethodInfo[] methods)
        {
            Console.WriteLine("Selecciona un metodo\n");
            string metodo = Console.ReadLine();
            var eleccion = methods.Where(
                m => string.Equals(m.Name, metodo, StringComparison.Ordinal)
                ).First();
            return (metodo, eleccion);
        }

        public PropertyInfo[] InfoProperties()
        {
            Console.WriteLine("Estos son los atributos disponiblesm, escribe Salir para salir del metodo");
            Type type = GetType();
            PropertyInfo[] properties = type.GetProperties(BindingFlags.DeclaredOnly);
            foreach (var property in properties)
            {
                Console.WriteLine(property.Name);
            }
            return properties;
        }

        public (string, PropertyInfo) SelectProperty(PropertyInfo[] properties)
        {
            Console.WriteLine("Selecciona un atributo\n");
            string property = Console.ReadLine();
            var eleccion = properties.Where(
                m => string.Equals(m.Name, property, StringComparison.Ordinal)
                ).First();
            return (property, eleccion);

        }
    }
}
