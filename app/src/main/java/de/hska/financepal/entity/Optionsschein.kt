package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Optionsschein(
    @PrimaryKey
    val isin: String,

    @Embedded
    val TransId: Transaktion,

    val typ: Optionstyp,

    val name: String,

    val kurs: Double,

    val bezugsverhaeltnis: String,

    val faelligkeit: Date,

    val basiswert: Double
) {
}

enum class Optionstyp(val value: String) {
    CALL("C"),

    PUT("P")
}