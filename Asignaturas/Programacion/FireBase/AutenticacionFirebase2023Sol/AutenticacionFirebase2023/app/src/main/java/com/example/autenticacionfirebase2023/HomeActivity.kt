package com.example.autenticacionfirebase2023

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.autenticacionfirebase2023.databinding.ActivityHomeBinding
import com.example.autenticacionfirebase2023.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding


    //Esto se lanza cuando se descarga la app. Aquí también podemos poner el borrado de los datos de sesión.
    override fun onStop() {
        super.onStop()
        Log.e("Fernando","Stop app")
//        val prefs: SharedPreferences.Editor? = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
//        prefs?.clear() //Al cerrar sesión borramos los datos
//        prefs?.apply ()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle:Bundle? = intent.extras
        binding.txtEmail.text = bundle?.getString("email")
        val prov:String = bundle?.getString("provider").toString()
        binding.txtProveedor.text = bundle?.getString("provider").toString()


        //Guardado de datos para toda la aplicación en la sesión.
        val prefs: SharedPreferences.Editor? = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs?.putString("email",bundle?.getString("email").toString())
        prefs?.putString("provider",bundle?.getString("provider").toString())
        prefs?.apply () //Con estos datos guardados en el fichero de sesión, aunque la app se detenga tendremos acceso a los mismos.


        binding.btCerrarSesion.setOnClickListener {
            val prefs: SharedPreferences.Editor? = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs?.clear() //Al cerrar sesión borramos los datos
            prefs?.apply ()
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}