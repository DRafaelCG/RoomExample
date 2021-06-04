package com.dim.roomexample.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext


@Database(entities = [Contactos::class], version = 1)
abstract class ContactosDatabase: RoomDatabase() {
    abstract fun contactosDao(): ContactosDAO

    companion object{
        private const val DATABASE_NAME = "score_database"
        @Volatile
        private var INSTANCE: ContactosDatabase? = null

        fun getInstance(context: Context): ContactosDatabase?{
            INSTANCE ?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ContactosDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}