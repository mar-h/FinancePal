package de.hska.financepal.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(foreignKeys = [
    ForeignKey(entity = Transaktion::class,
        parentColumns = ["id"],
        childColumns = ["transId"])
])data class Optionsschein(
    @PrimaryKey
    val isin: String,

    val transId: Transaktion,

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