package com.example.newso.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newso.data.entity.entities.NewsResponse
import com.example.newso.repository.NewsRepository
import com.example.newso.ui.Utils.Resource
import kotlinx.coroutines.launch
import okhttp3.Response

//import okhttp3.Response
//import retrofit2.Response


class NewsViewModel(val newsRepository: NewsRepository) : ViewModel() {

    val breakingNews : MutableLiveData<Resource<NewsResponse>> = MutableLiveData();
    var breakingNewsPage = 1;

    val searchNews : MutableLiveData<Resource<NewsResponse>> = MutableLiveData();
    var searchNewsPage = 1;


    init {
        getBreakingNews("in")
    }


    fun getBreakingNews( countryCode : String ) = viewModelScope.launch {

        breakingNews.postValue( Resource.Loading() )
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handlerBreakingNewsResponse(response))       // this gives an error

    }


    private fun handlerBreakingNewsResponse( response : Response<NewsResponse>) : Resource<NewsResponse>{

        if( response.isSuccessful)
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }

        return Resource.Error(response.message())
    }


}