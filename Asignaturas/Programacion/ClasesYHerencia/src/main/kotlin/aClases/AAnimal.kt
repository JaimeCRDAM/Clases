package aClases

import modelos.Gato


abstract class AAnimal {
    abstract var nombre:String
    abstract var raza:String
    abstract var peso:Int
    abstract var color:String
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

    fun vacunar(){
        println("$nombre de raza $raza ha sido vacunado")
    }
    fun comer(){
        println("$nombre de raza $raza esta comiendo")
    }
    fun dormir(){
        println("$nombre de raza $raza esta durmiendo")
    }
    abstract fun hacerRuido()
    abstract fun hacerCaso()


}