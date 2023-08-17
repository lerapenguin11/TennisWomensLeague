package com.example.tenniswomensleague.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tenniswomensleague.business.models.MatchModel
import com.example.tenniswomensleague.business.repos.MatchRepository

class MatchViewModel : ViewModel() {

    private val repository = MatchRepository()

    fun getResultMatch() : LiveData<MutableList<MatchModel>> {
        val MatchMutableData = MutableLiveData<MutableList<MatchModel>>()
        repository.getMatchList().observeForever {matchList ->
            MatchMutableData.value = matchList
        }

        return MatchMutableData
    }
}