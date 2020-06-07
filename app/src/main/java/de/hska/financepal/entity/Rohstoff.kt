package de.hska.financepal.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(entity = Transaktion::class,
        parentColumns = ["id"],
        childColumns = ["transId"])
])data class Rohstoff(
    @PrimaryKey(autoGenerate = true)
    val RohId: Int,

    val transId: Transaktion,

    val kurs: Double
) {
}