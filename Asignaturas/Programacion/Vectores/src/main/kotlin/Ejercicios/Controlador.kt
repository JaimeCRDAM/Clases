package Ejercicios
import Ejercicios.Controlador_Models.*
import kotlin.reflect.KClass
import kotlin.reflect.safeCast

class Controlador {
    var centros:HashMap<String, Centro> = HashMap()
    init{
        println("No tienes ningun centro todavia, dime el nombre de uno")
        var centro = readLine().toString()
        centroFactory(centro)
        while(true){
            var eleccion = preguntarInt("Dame un numero\n 1 -> Crear centro\n 2 -> Crear Aula\n 3 -> Crear Ordenador")
            when(eleccion){
                1 -> centroFactory()
                2 -> claseFactory()
                3 -> ordenadorFactory()
                else -> println("Opcion no valida")
            }
        }
    }

    private fun centroFactory(centroNombre:String = ""){
        var preguntando = true
        var centroNombre = centroNombre
        if (centroNombre.equals("")){
            while(preguntando){
                println("Estos son los centros disponibles")
                centros.map {
                    print("${it.key}, ")
                }
                centroNombre = preguntarString("Nombre del centro a crear")
                if (centros.containsKey(centroNombre)){
                    println("Ya existe un centro con ese nombre")
                    continue
                }
                centros.set(centroNombre, Centro(centroNombre))
                preguntando = false
            }
            return
        }
        centros.set(centroNombre, Centro(centroNombre))

    }

    private fun claseFactory(){
        var preguntando = true
        var aulaNombre = ""
        var centro:Centro = preguntarHash(arrayOf(
            "Estos son los centros disponibles",
            "\nDime el nombre del centro",
            "No existe un centro con ese nombre"), centros)
        var aulas:HashMap<String, Clase> = centro.clases

        while(preguntando){
            println("Estos son las aulas disponibles")
            aulas.map {
                print("${it.key}, ")
            }
            aulaNombre = preguntarString("\nNombre del aula")
            if(aulas.containsKey(aulaNombre)) {
                println("Ya existe un aula con ese nombre")
                continue
            }
            preguntando = false
        }
        aulas.set(aulaNombre, Clase(aulaNombre))
    }

    private fun ordenadorFactory(){
        var preguntando = true
        var idOrdenador = ""
        var centro:Centro = preguntarHash(arrayOf(
            "Estos son los centros disponibles",
            "\nDime el nombre del centro",
            "No existe un centro con ese nombre"), centros)

        var aula:Clase = preguntarHash(arrayOf(
            "Estos son las clases disponibles",
            "Dime el nombre de la clase",
            "No existe una clase con ese nombre"), centro.clases)

        while(preguntando){
            println("Estos son los ordenadores disponibles")
            aula.ordenadores.map {
                print("${it.key}, ")
            }
            idOrdenador = preguntarString("Id del ordenador")
            if(aula.ordenadores.containsKey(idOrdenador)) {
                println("Ya existe un ordenador con ese id")
                continue
            }
            preguntando = false
        }
        aula.ordenadores.set(idOrdenador, Ordenador(idOrdenador))

    }

    private fun preguntarString(aPreguntar:String):String{
        var preguntando = true
        var toReturn = ""
        while(preguntando) {
            try {
                println(aPreguntar)
                toReturn = toReturn.plus(readln())
                preguntando = false
            } catch (e: Exception) {
                println("Has escrito mal el dato pedido")
            }
        }
        return toReturn
    }

    private fun preguntarInt(aPreguntar:String):Int{
        var preguntando = true
        var toReturn = 0
        while(preguntando) {
            try {
                println(aPreguntar)
                toReturn = readln().toInt()
                preguntando = false
            } catch (e: Exception) {
                println("Has escrito mal el dato pedido")
            }
        }
        return toReturn
    }
    private fun <T> preguntara(aPreguntar:String):T{
        var preguntando = true
        var toReturn:T? = null
        while(preguntando) {
            try {
                println(aPreguntar)
                toReturn = readLine() as T
                preguntando = false
            } catch (e: Exception) {
                println("Has escrito mal el dato pedido")
            }
        }
        return toReturn!!
    }

    private fun <T, K> preguntarHash(arrayString:Array<String>, classObject:HashMap<String, K>):T{
        var preguntando = true
        var objectNombre = ""
        var objectToReturn:Any
        while(preguntando){
            println(arrayString[0])
            classObject.map {
                print("${it.key}, ")
            }
            objectNombre = preguntarString(arrayString[1])
            if (!classObject.containsKey(objectNombre)) {
                println(arrayString[2])
                continue
            }
            preguntando = false
        }
        objectToReturn = classObject.get(objectNombre)!!
        return objectToReturn as T
    }

}