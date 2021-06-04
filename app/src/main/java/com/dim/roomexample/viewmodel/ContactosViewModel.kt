package com.dim.roomexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.dim.roomexample.model.Contactos
import com.dim.roomexample.model.ContactosRepositorio

class ContactosViewModel(application: Application): AndroidViewModel(application) {
    private val repository = ContactosRepositorio(application)
    val contactos = repository.getContactos()

    fun guardarContactos(contactos: Contactos){
        repository.insert(contactos)
    }
}