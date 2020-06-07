package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(entity = Transaktion::class,
        parentColumns = ["id"],
        childColumns = ["transId"])
])data class Kryptowaehrung(
    @PrimaryKey(autoGenerate = true)
    val KryptId: Int,

    val transId: Transaktion,

    val kurs: Double
) {
}