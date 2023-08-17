package com.example.tenniswomensleague.business.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tenniswomensleague.business.models.Constants
import com.example.tenniswomensleague.business.models.MatchModel

class MatchRepository {

    fun getMatchList() : LiveData<MutableList<MatchModel>> {
        val matchList = Constants.getMatchList()
        val mutableData = MutableLiveData<MutableList<MatchModel>>()
        val list = mutableListOf<MatchModel>()

        for (i in matchList){
            val date = i.date
            val nameLeft = i.nameLeft
            val nameRight = i.nameRight
            val flagLeft = i.flagLeft
            val flagRight = i.flagRight

            val listMatchModel = MatchModel(
                date = date,
                nameLeft = nameLeft,
                nameRight = nameRight,
                flagLeft = flagLeft,
                flagRight = flagRight
            )
            list.add(listMatchModel)
        }

        mutableData.value = list

        return mutableData
    }
}