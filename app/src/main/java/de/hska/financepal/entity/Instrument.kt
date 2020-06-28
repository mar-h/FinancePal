package de.hska.financepal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Inst")
data class Instrument(
    // val isin: String?,
    @ColumnInfo(name = "typ")
    val typ: String?,

    @ColumnInfo(name = "name")
    val name: String?,

    // val kaufwert: Double?,

    @ColumnInfo(name = "anzahl")
    val anzahl: Int,

    @ColumnInfo(name = "kurs")
    var kurs: Double,

    @ColumnInfo(name = "waehrung")
    val curr: String?

    // val rendite: Double?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "wert")
    var wert: Double = kurs * anzahl

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}
