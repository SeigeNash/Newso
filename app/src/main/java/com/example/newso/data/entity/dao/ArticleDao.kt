package com.example.newso.data.entity.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.newso.data.entity.entities.Article


@Dao
interface ArticleDao {

//    @Insert( onConflict =  OnConflictStrategy.REPLACE)
//    suspend fun insert( article:Article):Long;

    @Query( "SELECT * FROM articles ")       //this might generate some error
    fun getAllArticles() : LiveData <List <Article>>
}