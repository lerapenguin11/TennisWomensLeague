package com.example.tenniswomensleague.business.models

object Constants {

    fun getMatchList() : MutableList<MatchModel> {
        val matchList = mutableListOf<MatchModel>()

        val match1 = MatchModel("US Open. 09.11.22, 12 p.m", "G. Mereza", "O. Fretova", "https://cdn-icons-png.flaticon.com/512/206/206626.png",
            "https://cdn-icons-png.flaticon.com/512/555/555417.png")

        matchList.add(match1)

        return matchList
    }

    fun getNewsList() : MutableList<NewsModel> {
        val newsList = mutableListOf<NewsModel>()

        val news1 = NewsModel("Ostrava Open first results", "", "https://miracleballmethod.com/wp-content/uploads/2019/05/Screen-Shot-2019-05-21-at-10.06.00-AM-300x198.png")

        newsList.add(news1)

        return newsList
    }
}