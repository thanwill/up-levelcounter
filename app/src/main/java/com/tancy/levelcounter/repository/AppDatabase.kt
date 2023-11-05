package com.tancy.levelcounter.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun jogadorDao(): JogadorDao

    companion object{

        private lateinit var INSTANCE: AppDatabase

        fun getInstance(context: Context) : AppDatabase {

            // Se a INSTANCIA nao foi inicializada
            if (!::INSTANCE.isInitialized) {
                // inicializar a instancia:
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "jogo_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

    }
}