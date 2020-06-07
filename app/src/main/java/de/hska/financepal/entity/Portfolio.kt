package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Portfolio(
    @PrimaryKey
    val id: Int,

    val budget: Int,

    @Embedded
    val besitzer: Benutzer,

    val portfolioWert: Int,

    val rendite: Double
) {
}
