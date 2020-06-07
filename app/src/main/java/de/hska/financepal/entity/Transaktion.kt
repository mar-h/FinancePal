package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Transaktion(
    @PrimaryKey
    val id: Int,

    @Embedded
    val portfolio: Portfolio,

    val type: TransakType,

    val menge: Int,

    val transDatum: Date,

    val transWert: Int
) {
}

enum class TransakType(val value: String) {
    KAUF("K"),

    VERKAUF("V")
}