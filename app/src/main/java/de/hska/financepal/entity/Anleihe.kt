package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity
data class Anleihe(
    @PrimaryKey
    val isin: String,

    @Embedded
    val TransId: Transaktion,

    val name: String,

    val wert: BigDecimal,

    val kupon: Double,

    val kurs: Double,

    val faelligkeit: Date,

    val stueckelung: Int
) {
}