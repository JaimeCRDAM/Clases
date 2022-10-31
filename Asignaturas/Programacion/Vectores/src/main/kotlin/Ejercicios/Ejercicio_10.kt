package Ejercicios

class Ejercicio_10 {
    init {
        val listaNumeros: ArrayList<Int> = ArrayList(49)
        val arrayLoteria: Array<Int> = Array(6){0}
        listaNumeros.addAll(1..49)
        for (i in arrayLoteria.indices){
            val numero = listaNumeros.random()
            arrayLoteria[i] = numero
            listaNumeros.remove(numero)
            print(1)
        }
        print("Los numeros de la loteria son:")
        arrayLoteria.map {
            print(" $it")
        }
    }
}