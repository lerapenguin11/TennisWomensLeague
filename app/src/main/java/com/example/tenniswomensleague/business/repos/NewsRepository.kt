package com.example.tenniswomensleague.business.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tenniswomensleague.business.models.Constants
import com.example.tenniswomensleague.business.models.NewsModel

class NewsRepository {

    fun getNewsList() : LiveData<MutableList<NewsModel>> {
        val newsList = Constants.getNewsList()
        val mutableData = MutableLiveData<MutableList<NewsModel>>()
        val list = mutableListOf<NewsModel>()

        for (i in newsList){
            val title = i.title
            val desc = i.description
            val photo = i.photo

            val listMatchModel = NewsModel(
                title = title,
                description = desc,
                photo = photo
            )
            list.add(listMatchModel)
        }

        mutableData.value = list

        return mutableData
    }
}