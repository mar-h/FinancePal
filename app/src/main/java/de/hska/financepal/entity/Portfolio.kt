package de.hska.financepal.entity

import androidx.annotation.NonNull
import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = "P", foreignKeys = [
    ForeignKey(entity = Benutzer::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = CASCADE)
])
data class Portfolio(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", index = true)
    val portId: Int,

    val budget: Double?,

    val userId: Int,

    val portfolioWert: Double?,

    val rendite: Double?
) {
}
