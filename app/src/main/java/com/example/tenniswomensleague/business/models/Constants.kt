package com.example.tenniswomensleague.business.models

object Constants {

    fun getMatchList() : MutableList<MatchModel> {
        val matchList = mutableListOf<MatchModel>()

        val match1 = MatchModel("US Open. 09.11.22, 12 p.m", "G. Mereza", "O. Fretova", "https://cdn-icons-png.flaticon.com/512/206/206626.png",
            "https://cdn-icons-png.flaticon.com/512/555/555417.png")

        matchList.add(match1)

        return matchList
    }
}