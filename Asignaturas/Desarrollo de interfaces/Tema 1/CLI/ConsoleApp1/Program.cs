using System;
using System.ComponentModel;
using System.Dynamic;
using System.Reflection;

internal class Program
{
    private static void Main(string[] args)
    {
        Console.WriteLine("Ejercicios Disponibles:");
        Assembly assembly = Assembly.GetExecutingAssembly();
        Type[] listaTipos = GetTypesInNamespace(assembly, "ConsoleApp1.Ejercicios");

        foreach (Type t in listaTipos)
        {
            Console.WriteLine(t.Name);
        }

        var ejercicio = Console.ReadLine();
        var ejercicioReflection = listaTipos.Where<Type>(
            t => String.Equals(t.Name, ejercicio, StringComparison.Ordinal)
            ).First();

        Type? tipo = Type.GetType(ejercicioReflection.FullName!);

        Activator.CreateInstance(tipo!);


        Type[] GetTypesInNamespace(Assembly assembly, string nameSpace)
        {
            return
              assembly.GetTypes()
                      .Where(t => String.Equals(t.Namespace, nameSpace, StringComparison.Ordinal))
                      .ToArray();
        }
    }
}