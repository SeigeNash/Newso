package com.example.newso

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newso.data.entity.database.ArticleDatabase
import com.example.newso.repository.NewsRepository
import com.example.newso.viewmodel.NewsViewModel
import com.example.newso.viewmodel.NewsViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsrepositoru = NewsRepository(ArticleDatabase.getDatabase(this))
        val viewModelProviderFactory = NewsViewModelProvider(newsrepositoru)
        viewModel =  ViewModelProvider( this, viewModelProviderFactory).get(NewsViewModel :: class.java)

    }
}