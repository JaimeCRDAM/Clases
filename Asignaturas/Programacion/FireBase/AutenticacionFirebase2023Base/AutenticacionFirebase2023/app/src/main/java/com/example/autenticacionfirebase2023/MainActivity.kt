package com.example.autenticacionfirebase2023

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.autenticacionfirebase2023.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val RC_SIGN_IN = 1
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val analy: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","Integración completada")
        analy.logEvent("InitScreen",bundle)

        title = "Autenticación"
        binding.btRegistrar.setOnClickListener {
            if (binding.edEmail.text.isNotEmpty() && binding.edPass.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.edEmail.text.toString(),binding.edPass.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        irHome(it.result?.user?.email?:"",ProviderType.BASIC)  //Esto de los interrogantes es por si está vacío el email, que enviaría una cadena vacía.
                    } else {
                        showAlert()
                    }
                }
            }
        }

        binding.btLogin.setOnClickListener {
            if (binding.edEmail.text.isNotEmpty() && binding.edPass.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.edEmail.text.toString(),binding.edPass.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        irHome(it.result?.user?.email?:"",ProviderType.BASIC)  //Esto de los interrogantes es por si está vacío el email.
                    } else {
                        showAlert()
                    }
                }
            }
        }
        binding.btGoogle.setOnClickListener {
            //Configuración
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.request_id_token)) //Esto se encuentra en el archivo google-services.json: client->oauth_client -> client_id.
                .requestEmail()
                .build()

            val googleClient = GoogleSignIn.getClient(this,googleConf) //Este será el cliente de autenticación de Google.
            googleClient.signOut() //Con esto salimos de la posible cuenta  de Google que se encuentre logueada.
            val signInIntent = googleClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
        session()
    }
    //******************************* Para el login con contraseña y pass ******************************
    //*********************************************************************************
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    //*********************************************************************************
    private fun irHome(email:String, provider:ProviderType){
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email",email)
            putExtra("provider",provider.name)
        }
        startActivity(homeIntent)
    }
    private fun session(){
        Log.e("Fernando","Pasamos a la segunda ventana con los datos de la sesión.")
        val prefs: SharedPreferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE) //Aquí no invocamos al edit, es solo para comprobar si tenemos datos en sesión.
        val email:String? = prefs.getString("email",null)
        val provider:String? = prefs.getString("provider", null)
        if (email != null){
            //Tenemos iniciada la sesión.
            irHome(email, ProviderType.valueOf(provider.toString()))
            //irHome(email, ProviderType.BASIC)
        }
    }
}