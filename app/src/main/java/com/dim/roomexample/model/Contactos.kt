package com.dim.roomexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = Contactos.TABLE_NAME)
data class Contactos (
    @ColumnInfo(name = "telefono") @NotNull val telefono: String,
    @ColumnInfo(name = "primer_nombre") @NotNull val primerNombre: String,
    @ColumnInfo(name = "ap_paterno") val apellidoPaterno: String? = null
){
    companion object{
        const val TABLE_NAME = "contactos"
    }
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_contacto")
    var  idContacto: Int = 0
}