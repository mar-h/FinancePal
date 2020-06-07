package de.hska.financepal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Benutzer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val userId: Int,

    @ColumnInfo (name = "Vorname")
    val name: String,

    val vorname: String
) {

}