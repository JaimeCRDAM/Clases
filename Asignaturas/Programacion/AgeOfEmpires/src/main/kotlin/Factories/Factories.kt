package Factories

import Models.*

var vida = HashMap<String, Int>()
object Factories {
    init{
        setLife()
    }
}


fun aldeanoFactory(civilizacion: String):Aldeanos{
    return Aldeanos(vida[civilizacion]!!)
}

fun civFactory(rey:String, civilizacion:String):Civilizacion{
    return Civilizacion(rey,civilizacion)
}

fun minaFactory(tipo:String = "Oro", cantidad:Int = 500):Mina{
    return Mina(tipo, cantidad)
}

fun setLife(){
    vida.set("espanol", 200)
    vida.set("bizantino", 250)
}