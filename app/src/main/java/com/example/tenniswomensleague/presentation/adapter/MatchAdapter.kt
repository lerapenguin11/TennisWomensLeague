package com.example.tenniswomensleague.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.business.models.MatchModel
import com.example.tenniswomensleague.presentation.adapter.listener.MatchHistoryListener

class MatchAdapter(val listener : MatchHistoryListener) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>(){

    private val matchList = mutableListOf<MatchModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)

        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int = matchList.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match : MatchModel = matchList[position]

        holder.date.text = match.date
        holder.nameLeft.text = match.nameLeft
        holder.nameRight.text = match.nameRight

        Glide.with(holder.itemView)
            .load(match.flagLeft)
            .override(22, 12)
            .into(holder.flagLeft)

        Glide.with(holder.itemView)
            .load(match.flagRight)
            .override(22, 12)
            .into(holder.flagRight)

        holder.btHistory.setOnClickListener {
            listener.historyMatch(match)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(list : List<MatchModel>){
        this.matchList.clear()
        this.matchList.addAll(list)
        notifyDataSetChanged()
    }

    class MatchViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val date : TextView = view.findViewById(R.id.tv_match_date)
        val nameLeft : TextView = view.findViewById(R.id.tv_name_left)
        val nameRight : TextView = view.findViewById(R.id.tv_name_right)
        val flagLeft : ImageView = view.findViewById(R.id.iv_flag_left)
        val flagRight : ImageView = view.findViewById(R.id.iv_flag_right)
        val btHistory : ConstraintLayout = view.findViewById(R.id.bt_match_history)
    }
}