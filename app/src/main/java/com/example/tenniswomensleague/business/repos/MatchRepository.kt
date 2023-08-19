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
            val nameLeftResult = i.nameLeftResult
            val nameRightResult = i.nameRightResult
            val nameLeftMetrics = i.nameLeftMetrics
            val nameRightMetrics = i.nameRightMetrics
            val resultLeftOne = i.resultLeftOne
            val resultLeftTwo = i.resultLeftTwo
            val resultRightOne = i.resultRightOne
            val resultRightTwo = i.resultRightTwo
            val leftWtaSinglesRankings = i.leftWtaSinglesRankings
            val leftAge = i.leftAge
            val leftHeight = i.leftHeight
            val leftPlays = i.leftPlays
            val leftCoach = i.leftCoach
            val leftMatchesPlayed = i.leftMatchesPlayed
            val leftAces = i.leftAces
            val leftServiceGamesWon = i.leftServiceGamesWon
            val leftFeturnGamesWon = i.leftFeturnGamesWon
            val left1stServeWon = i.left1stServeWon
            val rightWtaSinglesRankings =i.rightWtaSinglesRankings
            val rightHeight = i.rightHeight
            val rightPlays = i.rightPlays
            val rightCoach = i.rightCoach
            val rightMatchesPlayed = i.rightMatchesPlayed
            val rightAces = i.rightAces
            val rightServiceGamesWon =i.rightServiceGamesWon
            val rightReturnGamesWon = i.rightReturnGamesWon
            val right1stServeWon = i.right1stServeWon
            val rightAge = i.rightAge
            val flagLeftHistory = i.flagLeftHistory
            val flagRightHistory = i.flagRightHistory

            val listMatchModel = MatchModel(
                date = date,
                nameLeft = nameLeft,
                nameRight = nameRight,
                flagLeft = flagLeft,
                flagRight = flagRight,
                nameLeftResult = nameLeftResult,
                nameRightResult = nameRightResult,
            nameLeftMetrics, nameRightMetrics, resultLeftOne,
                resultLeftTwo, resultRightOne, resultRightTwo,
                leftWtaSinglesRankings, leftAge, leftHeight, leftPlays,
                leftCoach, leftMatchesPlayed, leftAces, leftServiceGamesWon,
                leftFeturnGamesWon, left1stServeWon, rightWtaSinglesRankings,
                rightHeight, rightPlays, rightCoach, rightMatchesPlayed, rightAces,
                rightServiceGamesWon, rightReturnGamesWon, right1stServeWon,
                rightAge, flagLeftHistory, flagRightHistory
            )
            list.add(listMatchModel)
        }

        mutableData.value = list

        return mutableData
    }
}