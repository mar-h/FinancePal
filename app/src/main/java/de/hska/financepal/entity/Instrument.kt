package de.hska.financepal.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Inst")
data class Instrument(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val isin: String?,

    val name: String?,

    val typ: String?,

    val kaufwert: Double,

    val anzahl: Int?,


    val kurs: Double?,

    val wert: Double? = 0.00,

    val curr: String?,

    val rendite: Double?
) {
}