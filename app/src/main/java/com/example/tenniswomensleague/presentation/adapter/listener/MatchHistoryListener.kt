package com.example.tenniswomensleague.presentation.adapter.listener

import com.example.tenniswomensleague.business.models.MatchModel

interface MatchHistoryListener {

    fun historyMatch(lastMatch : MatchModel)
}