package com.dim.roomexample.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ContactosRepositorio(application: Application) {
    private val contactosDao: ContactosDAO? = ContactosDatabase.getInstance(application)?.contactosDao()

    fun insert(contactos: Contactos){
        if(contactosDao != null) InsertAsyncTask(contactosDao).execute(contactos)
    }

    fun getContactos(): LiveData<List<Contactos>>{
        return contactosDao?.getAgendaOrdanada()?:MutableLiveData<List<Contactos>>()
    }

    private class InsertAsyncTask(private val contactosDAO: ContactosDAO):
            AsyncTask<Contactos, Void, Void>(){
        override fun doInBackground(vararg contactos: Contactos?): Void? {
            for (contacto in contactos){
                if(contacto != null) contactosDAO.insert(contacto)
            }
            return null
        }
    }
}