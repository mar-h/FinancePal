package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rohstoff(
    @PrimaryKey
    val id: Int,

    @Embedded
    val TransId: Transaktion,

    val kurs: Double
) {
}