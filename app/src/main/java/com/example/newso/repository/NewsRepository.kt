package com.example.newso.repository

import com.example.newso.data.entity.Instance.RetrofitInstance
import com.example.newso.data.entity.database.ArticleDatabase

class NewsRepository( val db : ArticleDatabase) {

    suspend fun getBreakingNews( countryCode : String, pageNumber : Int ){

        RetrofitInstance.api.getBreakingNews( countryCode, pageNumber )

    }
}