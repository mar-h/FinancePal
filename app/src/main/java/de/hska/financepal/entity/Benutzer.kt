package de.hska.financepal.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "B")
data class Benutzer(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", index = true)
    val userId: Int,

    @ColumnInfo (name = "name")
    val nachname: String?,

    val vorname: String?
) {

}