package Modelo

import android.text.Editable
import com.example.ejemplorecycler2223.R

object FactoriaPersonaje {

    /**
     * Aquíe ponéis lo que sea.
     */
    fun generaPersonaje(nombrePersonaje: String = "", raza: String = "" ) : Personaje {
        var nombres = listOf<String>("Gandalf", "Frodo", "Legolas", "Aragorn", "Sauron")
        var razas = listOf<String>("Orco", "Hombre", "Hobbit", "Elfo")
        var imagenes = listOf<String>("https://loremflickr.com/g/320/240/paris","https://loremflickr.com/320/240/dog","https://loremflickr.com/320/240","https://loremflickr.com/320/240/brazil,rio", "https://loremflickr.com/320/240/paris,girl/all");
        var nombrePersonajeFinal = if(nombrePersonaje == "") nombres[(nombres.indices).random()] else nombrePersonaje
        var razaFinal = if(raza == "") razas[(razas.indices).random()] else raza
        var p = Personaje(nombrePersonajeFinal, razaFinal,imagenes[(imagenes.indices).random()])
        if (p.nombre.equals("Gandalf")) p.imagen="gandalf"
        return p
    }
}