package com.example.newso.data.entity.api

import com.example.newso.data.entity.entities.NewsResponse
import com.example.newso.ui.Utils.ConstUtils.Companion.api_key
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET( "v2/everything" )
    suspend fun getBreakingNews(

        @Query( "country" )
        countryCode : String = "in",
        @Query("page")
        pageNumber : Int = 1,
        @Query( "apikey")
        apiKey : String = api_key

    ): Response<NewsResponse>
}