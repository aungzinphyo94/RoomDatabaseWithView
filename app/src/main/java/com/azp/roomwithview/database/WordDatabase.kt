package com.azp.roomwithview.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.azp.roomwithview.dao.WordDao
import com.azp.roomwithview.entity.Word
import com.azp.roomwithview.repository.WordRepository

@Database(entities = arrayOf(Word::class), version = 1)
abstract class WordDatabase : RoomDatabase(){
    abstract fun wordDao(): WordDao

    companion object{
        //Singleton prevents multiple instance of database
        //opening at the same time

        private var INSTANCE : WordDatabase? = null

        fun getDatabase(
            context: Context
        ): WordDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    WordDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}