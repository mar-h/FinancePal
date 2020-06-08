package de.hska.financepal.entity

import androidx.annotation.NonNull
import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import java.util.*

@Entity(tableName = "T",foreignKeys = [
    ForeignKey(entity = Portfolio::class,
        parentColumns = ["id"],
        childColumns = ["portId"],
        onDelete = CASCADE)
])
data class Transaktion(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", index = true)
    val transId: Int,

    val portId: Int,

    val type: String?,

    val menge: Int,

    val transDatum: String?,

    val transWert: Double?
) {
}
