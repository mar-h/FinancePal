package de.hska.financepal.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "P", foreignKeys = [
    ForeignKey(entity = Benutzer::class,
        parentColumns = ["id"],
        childColumns = ["besitzer"])
])
data class Portfolio(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", index = true)
    val portId: Int,

    val budget: Double?,

    val besitzer: Int,

    val portfolioWert: Double?,

    val rendite: Double?
) {
}
