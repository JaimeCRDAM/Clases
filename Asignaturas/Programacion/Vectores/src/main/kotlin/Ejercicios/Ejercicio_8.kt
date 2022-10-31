package Ejercicios

import kotlin.random.Random

class Ejercicio_8 {
    init {
        val arrayInt: Array<Int> = Array(5){ Random.nextInt(0, 50)}
        val arrayIntInverso: Array<Int> = Array(5){ arrayInt[arrayInt.size-1-it]}
        arrayInt.forEach { print("$it ") }
        print("\n")
        arrayIntInverso.forEach { print("$it ") }
    }
}