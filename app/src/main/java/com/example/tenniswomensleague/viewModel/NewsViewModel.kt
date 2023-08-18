package com.example.tenniswomensleague.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tenniswomensleague.business.models.NewsModel
import com.example.tenniswomensleague.business.repos.NewsRepository

class NewsViewModel : ViewModel(){

    private val repository = NewsRepository()

    fun getResultMatch() : LiveData<MutableList<NewsModel>> {
        val newsMutableData = MutableLiveData<MutableList<NewsModel>>()
        repository.getNewsList().observeForever {newsList ->
            newsMutableData.value = newsList
        }

        return newsMutableData
    }
}