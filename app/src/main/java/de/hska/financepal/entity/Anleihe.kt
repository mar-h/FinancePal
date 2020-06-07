package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity(tableName = "AL", foreignKeys = [
    ForeignKey(entity = Transaktion::class,
        parentColumns = ["id"],
        childColumns = ["transId"])
])data class Anleihe(
    @PrimaryKey
    val isin: String,

    val transId: Transaktion,

    val name: String,

    val wert: Double,

    val kupon: Double,

    val kurs: Double,

    val faelligkeit: Date,

    val stueckelung: Int
) {
}