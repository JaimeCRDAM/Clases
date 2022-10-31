package Ejercicios

import java.lang.Exception

class Ejercicio_9 {
    init {
        var numeroElegido: Int? = null
        while (numeroElegido == null) {
            try {
                numeroElegido = readln().toInt()
            } catch (e: Exception) {
                println("Has dado un numero invalido, prueba otra vez")
            }
        }
        val numeroArray = numeroToArray(numeroElegido)
        val numeroArrayInvertido = numeroArray.reversedArray()
        var esCapicua = true
        for (i in numeroArray.indices){
            if(numeroArray[i] != numeroArrayInvertido[i]){
                esCapicua = false
            }
        }
        if(esCapicua){
            println("Es capicua")
        } else{
            println("No es capicua")
        }
    }


    private fun numeroToArray(numero:Int): Array<Int> {
        val numero = numero.toString()
        val arrayToReturn = Array(numero.length) {
            numero[it].toString().toInt()
        }
        return arrayToReturn
    }
}