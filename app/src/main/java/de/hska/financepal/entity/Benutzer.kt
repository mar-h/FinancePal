package de.hska.financepal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Benutzer(
    @PrimaryKey
    val id: Int,

    @ColumnInfo (name = "Vorname")
    val name: String,

    val vorname: String
) {

}