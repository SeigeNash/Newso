package com.example.newso.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newso.MainActivity
import com.example.newso.R
import com.example.newso.adapterPackage.NewsAdapter
import com.example.newso.ui.Utils.Resource
import com.example.newso.viewmodel.NewsViewModel

class BreakingNewsFragment : Fragment() {

    lateinit var viewModel : NewsViewModel
    lateinit var newsadapter : NewsAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breaking_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
        setupRV()

        viewModel.breakingNews.observe( viewLifecycleOwner, Observer {

            when(it){
                is Resource.Success -> {
                    it.data?.let {
                        newsadapter.differ.submitList( it.articles)
                    }
                }

                is Resource.Error -> {

                    it.message?.let {
                        Toast.makeText( activity, "$(it.toString()}", Toast.LENGTH_SHORT).show()

                    }
                }

                else -> {}
            }


        })

    }

    private fun setupRV() {

        newsadapter = NewsAdapter()
        rv.apply {
            var adapter = newsadapter
            var layoutManager = LinearLayoutManager(activity)

        }
    }
}