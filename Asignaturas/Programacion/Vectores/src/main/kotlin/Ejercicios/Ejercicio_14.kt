package Ejercicios

import java.lang.Exception
import kotlin.random.Random

class Ejercicio_14 {
    init{
        val arrayMosca = Array(10){false}
        generarOMoverMosca(arrayMosca)
        var estaViva = true
        var casillaElegida = 0
        while(estaViva){
            try {
                println("¿Donde crees que esta la mosca? (1 - ${arrayMosca.size})")
                casillaElegida = readln().toInt()-1
                if(casillaElegida < 0 || casillaElegida > arrayMosca.size-1){
                    throw Exception("numero invalido")
                }
            } catch (e: Exception) {
                println("Has dado un numero invalido, prueba otra vez")
                continue
            }
            estaViva = golpearMosca(arrayMosca, casillaElegida)
            if(estaViva ){
                println("No has golpeado a la mosca")
                if(rozarMosca(arrayMosca, casillaElegida)){
                    generarOMoverMosca(arrayMosca, casillaElegida)
                    println("¡Pero la has rozado!")
                    continue
                }
                continue
            }
            println("¡Has matado a la mosca!")
        }
    }

    private fun generarOMoverMosca(
        arrayMosca:Array<Boolean>,
        currentIndex:Int = Random.nextInt(0, arrayMosca.size-1)
    ){
        val index = Random.nextInt(0,arrayMosca.size-1)
        arrayMosca[currentIndex] = false
        arrayMosca[index] = true
    }

    private fun golpearMosca(arrayMosca:Array<Boolean>, index:Int):Boolean{
        var viva = true
        if (arrayMosca[index]){
            viva = false
        }
        return viva
    }

    private fun rozarMosca(arrayMosca:Array<Boolean>, index:Int):Boolean{
        var rozada = false
        if(index-1 >= 0 && arrayMosca[index-1]){
            rozada = true
            arrayMosca[index-1] = false
        }
        if(index+1 < arrayMosca.size && arrayMosca[index+1]){
            rozada = true
            arrayMosca[index+1] = false
        }
        return rozada
    }
}