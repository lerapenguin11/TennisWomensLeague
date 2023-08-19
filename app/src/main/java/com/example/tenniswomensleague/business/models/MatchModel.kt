package com.example.tenniswomensleague.business.models

import android.widget.ImageView
import android.widget.TextView

data class MatchModel(
    val date : String,
    val nameLeft : String,
    val nameRight : String,
    val flagLeft : String,
    val flagRight : String,
    val nameLeftResult : String,
    val nameRightResult : String,
    val nameLeftMetrics : String,
    val nameRightMetrics : String,
    val resultLeftOne : Int,
    val resultLeftTwo : Int,
    val resultRightOne : Int,
    val resultRightTwo : Int,
    val leftWtaSinglesRankings : String,
    val leftAge : String,
    val leftHeight : String,
    val leftPlays : String,
    val leftCoach : String,
    val leftMatchesPlayed : String,
    val leftAces : String,
    val leftServiceGamesWon : String,
    val leftFeturnGamesWon : String,
    val left1stServeWon : String,
    val rightWtaSinglesRankings : String,
    val rightHeight : String,
    val rightPlays : String,
    val rightCoach : String,
    val rightMatchesPlayed : String,
    val rightAces : String,
    val rightServiceGamesWon : String,
    val rightReturnGamesWon : String,
    val right1stServeWon : String,
    val rightAge : String,
    val flagLeftHistory : String,
    val flagRightHistory : String
)
