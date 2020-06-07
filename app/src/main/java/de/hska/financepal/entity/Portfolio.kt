package de.hska.financepal.entity

import androidx.room.*

@Entity(foreignKeys = [
    ForeignKey(entity = Benutzer::class,
        parentColumns = ["id"],
        childColumns = ["userId"])
])
data class Portfolio(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val portId: Int,

    val budget: Int,

    val userId: Int,

    val portfolioWert: Double,

    val rendite: Double
) {
}
