package com.example.repasapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tractors")
data class Tractors(

    @ColumnInfo(name = "year")
    var any: Int,
    @ColumnInfo(name = "brand")
    var marca: String,
    @ColumnInfo(name = "cv")
    var cavalls: Int
) {
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}