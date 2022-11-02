package com.example.myapplication

import Adaptadores.MiAdaptadorRecycler
import Modelo.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var personajes:ArrayList<Personaje> = FactoriaListaPersonaje.generaLista(12)
    lateinit var miRecyclerView : RecyclerView
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        var SQLitedb = FeedReaderDbHelper(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("Fernando", personajes.toString())

        miRecyclerView = binding.listaPersonajesRecycler as RecyclerView
        miRecyclerView.setHasFixedSize(true)
        miRecyclerView.layoutManager = LinearLayoutManager(this)
        var miAdapter = MiAdaptadorRecycler(personajes, this)
        miRecyclerView.adapter = miAdapter

        var resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data = result.data?.extras?.get("personaje") as Personaje
                    personajes.add(data)
                    miAdapter.notifyItemInserted(personajes.lastIndex)
                }
            }


        binding.btDetalle.setOnClickListener {
            if (MiAdaptadorRecycler.seleccionado >= 0) {
                val pe = personajes.get(MiAdaptadorRecycler.seleccionado)
                Log.e("Fernando",pe.toString())
            }
            else {
                Toast.makeText(this,"Selecciona algo previamente", Toast.LENGTH_SHORT).show()
            }
        }

        binding.BTNRegistrar.setOnClickListener{
            val intent = Intent(this, registrar::class.java)
            resultLauncher.launch(intent)
        }

    }
}