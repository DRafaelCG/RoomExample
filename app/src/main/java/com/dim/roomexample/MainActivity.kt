package com.dim.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dim.roomexample.model.Contactos
import com.dim.roomexample.viewmodel.ContactosViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var contactosViewModel: ContactosViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactosViewModel = kotlin.run {
            ViewModelProviders.of(this).get(ContactosViewModel::class.java)
        }

        bttn_agregarContacto.setOnClickListener { agregarContacto() }
        addObserver()
    }

    private fun addObserver(){
        val oberver = Observer<List<Contactos>>{contactos ->
            if(contactos != null){
                var text = ""
                for (contacto in contactos){
                    text += contacto.primerNombre + " " +  contacto.apellidoPaterno + " - " + contacto.telefono + "\n"
                }
                tv_contactos.text = text
            }
        }
        contactosViewModel.contactos.observe(this, oberver)
    }

    private fun agregarContacto(){
        val tel = et_telefono.text.toString()
        val nombre = et_primer_nombre.text.toString()
        val apPaterno =
            if(et_ap_paterno.text.toString() != ""){
                et_ap_paterno.text.toString()
            }else{
                null
            }
        if(nombre != "" && tel != ""){
            contactosViewModel.guardarContactos(Contactos(tel, nombre, apPaterno))
            et_telefono.setText("")
            et_primer_nombre.setText("")
            et_ap_paterno.setText("")
        }
    }
}