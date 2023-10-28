package com.example.newso.data.entity.entities

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int


)