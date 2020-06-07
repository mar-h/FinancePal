package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity(foreignKeys = [
            ForeignKey(entity = Transaktion::class,
                       parentColumns = ["id"],
                       childColumns = ["transId"])
])
data class Aktie(
    @PrimaryKey
    val isin: String,

    val transId: Transaktion,

    val name: String,

    val kurs: Double,

    val hauptversammlung: Date,

    val dividende: Double
) {
}