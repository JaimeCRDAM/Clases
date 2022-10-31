package Models

class Civilizacion(var rey: String, var civilizacion: String) {

    var aldeanos = ArrayList<Aldeanos>()

    var recursos = 0

    fun recibirAldeanos(aldeano: Aldeanos){
        aldeanos.add(aldeano)
    }

    fun perderAldeanos():Aldeanos{
        var aldeanoPerdido = aldeanos.random()
        aldeanos.remove(aldeanoPerdido)
        return aldeanoPerdido
    }

    fun getCantidadAldeanos():Int{
        return aldeanos.size
    }

    fun getRecursos(cantidad:Int){
        recursos += cantidad
    }

}