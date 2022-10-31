package com.example.ejemplorecycler2223

import Modelo.Personaje
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplorecycler2223.databinding.ActivityAddPersonajesBinding

class Add_Personajes : AppCompatActivity() {
    lateinit var binding: ActivityAddPersonajesBinding
    lateinit var bundle:Bundle
    lateinit var nombre:EditText
    lateinit var raza:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPersonajesBinding.inflate(layoutInflater)
        bundle = intent.extras!!
        nombre = binding.FieldNombre
        raza = binding.FieldRaza
        setContentView(binding.root)
        Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show()
        binding.BTNAnadirPersonaje.setOnClickListener{
            Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show()
            val personajesList:ArrayList<Personaje> = bundle.get("personajes") as ArrayList<Personaje>
            personajesList.add(Modelo.FactoriaPersonaje.generaPersonaje(nombre.text.toString(), raza.text.toString()))
            var data = Intent()
            data.putExtra("personajes", personajesList)
            setResult(RESULT_OK, data);
            finish()
        }
    }
}