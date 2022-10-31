package modelos

import aClases.AAnimal

class Gato(override var nombre: String = "", override var raza: String = "", override var peso: Int = 0, override var color: String = ""): AAnimal() {
    init{
        incrementar()
    }
    data class Builder( var nombre: String = "",  var raza: String = "",  var peso: Int = 0,  var color: String = ""){
        fun  nombre(nombre: String):Builder{
            this.nombre = nombre
            return this
        }
        fun  raza(raza: String):Builder{
            this.raza = raza
            return this
        }
        fun  peso(peso: Int):Builder{
            this.peso = peso
            return this
        }
        fun  color(color: String):Builder{
            this.nombre = color
            return this
        }
        fun build(): Gato {
            return Gato(nombre, raza, peso, color)
        }
    }


    override fun hacerRuido(){
        println("$nombre dice Meow uwu")
    }
    override fun hacerCaso(){
        var ignorar = Math.random() < 0.05
        if(ignorar){
            println("$nombre de raza $raza esta durmiendo (otra vez)")
        }
    }
    fun toserBolaPelo(){
        println("$nombre ha escupido una bola de pelo")
    }
    companion object {
        var nombreStatic = 0
        fun incrementar(){
            nombreStatic++
        }
    }
}