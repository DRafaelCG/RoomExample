package com.dim.roomexample.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactosDAO {
    @Insert
    fun insert(contacto: Contactos)

    @Update
    fun update(vararg contacto: Contactos)

    @Delete
    fun delete(vararg contacto: Contactos)

    @Query("SELECT * FROM " + Contactos.TABLE_NAME + " ORDER BY primer_nombre, ap_paterno")
    fun getAgendaOrdanada(): LiveData<List<Contactos>>
}