package com.example.newso.data.entity.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
//import androidx.room.vo.Entity
//import androidx.room.vo.PrimaryKey

@Entity(
    tableName = "articles"
)

data class Article(
    @PrimaryKey( autoGenerate = true )
    val id :Int ?= null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)