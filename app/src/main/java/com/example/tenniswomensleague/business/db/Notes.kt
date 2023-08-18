package com.example.tenniswomensleague.business.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    @ColumnInfo(name = "title")
    val title : String,

    @ColumnInfo(name = "text")
    val textNote : String
)