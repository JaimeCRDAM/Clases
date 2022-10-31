package Models

class Mina(var tipo:String, var cantidad:Int) {
    fun reducirMina(cantidad:Int){
        this.cantidad -= cantidad
    }

}