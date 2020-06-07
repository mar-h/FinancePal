package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity
data class Aktie(
    @PrimaryKey
    val isin: String,

    @Embedded
    val transID: Transaktion,

    val name: String,

    val kurs: BigDecimal,

    val hauptversammlung: Date,

    val dividende: Double
) {
}