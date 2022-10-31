import aClases.AAnimal
import modelos.*
import kotlin.random.Random

fun main(args: Array<String>) {
    simulacion()
}

fun simulacion(){
    var parque:Array<Array<AAnimal?>> = Array(10) {
            fila ->
                Array(10) { columna ->
                    null
                }
            }
    var cont = 1
    while(true){
        if (cont%10 == 0){
            llegaAnimalOSeVa(parque)
        }

        if (cont%2 == 0){
            animalesRealizanAcciones(parque)
        }

        if (cont%15 == 0){
            var animalPos = cogerAnimalAleatorio(parque)
            var celdas = celdasAdyacentes(animalPos, parque)
            if(celdas.size > 0){
                moverAnimal(celdas.first(), animalPos, parque)
            }
        }

        if (cont%20 == 0){
            var animalPos = cogerAnimalAleatorio(parque)
            var animal =  parque[animalPos.first][animalPos.second]!!
            println("${animal.nombre} de raza ${animal.raza} se ha ido")
            parque[animalPos.first][animalPos.second] = null
        }

        cont++
        Thread.sleep(500)
    }
}

fun moverAnimal(celda:Pair<Int, Int>, pos:Pair<Int, Int>, parque:Array<Array<AAnimal?>>){
    var animal = parque[pos.first][pos.second]!!
    parque[celda.first][celda.second] = animal
    parque[pos.first][pos.second] = null
    println("${animal.nombre} de raza ${animal.raza} ha sido movido a ${celda.first},${celda.second}")

}
fun sectorLibre(parque:Array<Array<AAnimal?>>):Pair<Int, Int>{
    for (i in 0..parque.size-1){
        for (j in 0..parque.size-1){
            if(parque[i][j] == null){
                return Pair(i, j)
            }
        }
    }
    return Pair(-1, -1)
}
fun cogerAnimalAleatorio(parque:Array<Array<AAnimal?>>):Pair<Int, Int>{
    var preguntando = true
    lateinit var result:Pair<Int, Int>
    while (preguntando){
        var pos1 = Random.nextInt(0, parque.size)
        var pos2 = Random.nextInt(0, parque.size)
        if(parque[pos1][pos2] != null){
            result = Pair(pos1, pos2)
            preguntando = false
        }
    }
    return result

}
fun llegaAnimalOSeVa(parque:Array<Array<AAnimal?>>){
    var sector = sectorLibre(parque)
    var animal = llegaAnimal()
    if (sector.first != -1){
        parque[sector.first][sector.second] = animal
        println("${animal.nombre} de raza ${animal.raza} ha llegado")
        return
    }
    println("${animal.nombre} de raza ${animal.raza} ha llegado pero no habia hueco")
}

fun celdasAdyacentes(celda:Pair<Int, Int>, parque:Array<Array<AAnimal?>>):List<Pair<Int, Int>>{
    var listaCeldas = ArrayList<Pair<Int, Int>>()
    for(i in -1..1){
        for (j in -1..1){
            var fila = i+celda.first
            var columna = j+celda.second
            if(fila > 0 && columna > 0 && fila < parque.size && columna < parque.size){
                if(parque[fila][columna] == null){
                    listaCeldas.add(Pair(fila,columna))
                }
            }
        }
    }
    return listaCeldas
}

fun animalesRealizanAcciones(parque:Array<Array<AAnimal?>>){
    parque.map {
        fila ->
        fila.map {
            columna ->
            if(columna != null){
                var random = Random.nextInt(1,4)
                when(random){
                    1 -> columna.comer()
                    2 -> columna.dormir()
                    3 -> columna.hacerCaso()
                }
            }
        }
    }
}

fun llegaAnimal():AAnimal{
    var number = Math.random()
    if(number < 0.5){
        return Gato.Builder().nombre(Gato.nombreStatic.toString()).raza("Felina").build()
    }else {
        return Perro.Builder().nombre(Perro.nombreStatic.toString()).raza("Canina").build()
    }
}

