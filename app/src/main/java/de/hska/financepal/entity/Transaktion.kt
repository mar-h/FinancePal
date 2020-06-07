package de.hska.financepal.entity

import androidx.room.*
import java.util.*

@Entity(foreignKeys = [
    ForeignKey(entity = Portfolio::class,
        parentColumns = ["id"],
        childColumns = ["portId"])
])
data class Transaktion(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val transId: Int,

    val portId: Int,

    val type: TransakType,

    val menge: Int,

    val transDatum: Date,

    val transWert: Double
) {
}

enum class TransakType(val value: String) {
    KAUF("K"),

    VERKAUF("V")
}