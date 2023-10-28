package com.example.newso.data.entity.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newso.data.entity.entities.Article
import com.example.newso.data.entity.dao.ArticleDao

@Database( entities = [Article :: class], version = 1, exportSchema = false)
@TypeConverters( Converter :: class )

abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getDao():ArticleDao

    companion object{

        @Volatile
        private var INSTANCE : ArticleDatabase ?= null;
        private val LOCK = Any()

        operator fun invoke(context : Context) = INSTANCE ?: synchronized(LOCK){
            INSTANCE ?:createDatabase(context).also{
                INSTANCE = it
            }
        }


        // taken from the Room Database video

        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, ArticleDatabase::class.java, "article_db").build()

    }
}


