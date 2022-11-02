package Modelo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRegistrarBinding

class registrar : AppCompatActivity() {

    lateinit var binding: ActivityRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var personaje:Personaje

        binding.BTNRegistrarse.setOnClickListener{
            personaje = FactoriaPersonaje.generaPersonaje(binding.TBNombre.text.toString(), binding.TBRaza.text.toString())
            var intent = Intent()
            intent.putExtra("personaje", personaje)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.BTNVolver.setOnClickListener {
            finish()
        }
    }
}