package de.hska.financepal.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
            ForeignKey(entity = Transaktion::class,
                       parentColumns = ["id"],
                       childColumns = ["transId"])
])
data class InstrumentStatus(
    @PrimaryKey
    val transId: Int,

    val status: StatusType,

    val gesamtWert: Double,

    val rendite: Double,

    val link: String
) {
}

enum class StatusType(val value: String) {
    INBESITZ("IB"),

    VERKAUFT("VK")
}