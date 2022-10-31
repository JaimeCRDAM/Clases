package Ejercicios

import java.lang.Exception
import kotlin.random.Random

class Ejercicio_7 {
    init {
        val arrayInt: Array<Int> = Array(10){ Random.nextInt(0, 50)}
        var numeroElegido: Int? = null
        while (numeroElegido == null) {
            try {
                numeroElegido = readln().toInt()
            } catch (e: Exception) {
                println("Has dado un numero invalido, prueba otra vez")
            }
        }
        println("El index del numero es ".plus(arrayInt.indexOf(numeroElegido)))
    }
}