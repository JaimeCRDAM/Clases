import Factories.*
import Models.*
val espanol = civFactory("Isabel I", "espanol")
val bizantinos = civFactory(" Constantino II", "bizantino")

fun main(args: Array<String>) {
    Factories
    var cont = 1
    var mina = minaFactory()
    while (cont != 61){
        getRecursos(espanol, mina)
        getRecursos(bizantinos, mina)
        if (cont%2 == 0){
            genAldeano()
        }
        if (cont%5 == 0){
            WOLOLOLOLO()
        }
        cont++
        Thread.sleep(500)
    }
    println("Los espanoles han conseguido ${espanol.recursos} unidades")
    println("Los espanoles han conseguido ${bizantinos.recursos} unidades")
}

fun getRecursos(civilizacion: Civilizacion, mina: Mina){
    var cantidad = mina.cantidad
    var cantidadAldeanos = civilizacion.getCantidadAldeanos()
    if (cantidad > cantidadAldeanos){
        civilizacion.getRecursos(cantidadAldeanos)
        mina.reducirMina(cantidadAldeanos)
        println("${civilizacion.civilizacion} ha conseguido ${cantidadAldeanos} unidades de ${mina.tipo}\n")
        return
    }
    civilizacion.getRecursos(cantidad)
    mina.reducirMina(cantidad)
    println("${civilizacion.civilizacion} ha conseguido ${cantidad} unidades de ${mina.tipo}\n")

}

fun genAldeano(){
    var espanolB = Math.random() < 0.4
    var bizantinoB = Math.random() < 0.2
    if (espanolB){
        espanol.recibirAldeanos(aldeanoFactory("espanol"))
        println("los espanoles han recibido un aldeano\n")
    }
    if (bizantinoB){
        bizantinos.recibirAldeanos(aldeanoFactory("bizantino"))
        println("los bizantinos han recibido un aldeano\n")
    }
}

fun WOLOLOLOLO(){
    var espanolA = if(espanol.getCantidadAldeanos() > 0) espanol.perderAldeanos() else null
    if (espanolA != null){
        bizantinos.recibirAldeanos(espanolA)
        println("Los bizantinos han robado un aldeano\n")
    }
}
