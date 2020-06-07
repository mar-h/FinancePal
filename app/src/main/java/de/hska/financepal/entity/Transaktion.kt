package de.hska.financepal.entity

import androidx.annotation.NonNull
import androidx.room.*
import java.util.*

@Entity(tableName = "T",foreignKeys = [
    ForeignKey(entity = Portfolio::class,
        parentColumns = ["id"],
        childColumns = ["portId"])
])
data class Transaktion(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", index = true)
    val transId: Int,

    val portId: Int,

    val type: String?,

    val menge: Int,

    val transDatum: Date?,

    val transWert: Double?
) {
}
