package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InstrumentStatus(
    @PrimaryKey
    @Embedded
    val transak: Transaktion,

    val status: StatusType,

    val gesamtWert: Int,

    val rendite: Double,

    val link: String
) {
}

enum class StatusType(val value: String) {
    INBESITZ("IB"),

    VERKAUFT("VK")
}