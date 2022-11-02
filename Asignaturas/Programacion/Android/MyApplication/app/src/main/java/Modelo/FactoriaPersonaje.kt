package Modelo

object FactoriaPersonaje {
    fun generaPersonaje(nombre:String = "", raza:String = "") : Personaje {
        var nombres = listOf<String>("Gandalf", "Frodo", "Legolas", "Aragorn", "Sauron")
        var razas = listOf<String>("Orco", "Hombre", "Hobbit", "Elfo")
        var imagenes = listOf<String>("https://loremflickr.com/g/320/240/paris","https://loremflickr.com/320/240/dog","https://loremflickr.com/320/240","https://loremflickr.com/320/240/brazil,rio", "https://loremflickr.com/320/240/paris,girl/all");
        var nombrePersonaje = if (nombre != "") nombre else nombres[(nombres.indices).random()]
        var raza = if (nombre != "") raza else razas[(razas.indices).random()]
        var p = Personaje(nombrePersonaje, raza, imagenes[(imagenes.indices).random()])
        if (p.nombre.equals("Gandalf")) p.imagen="gandalf"
        return p
    }
}