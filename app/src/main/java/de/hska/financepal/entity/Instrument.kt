package de.hska.financepal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.math.round

@Entity(tableName = "Inst")
data class Instrument(
    @ColumnInfo(name = "typ")
    val typ: String?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "anzahl")
    val anzahl: Int,

    @ColumnInfo(name = "kurs")
    var kurs: Double,

    @ColumnInfo(name = "waehrung")
    val curr: String?

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "kurswert")
    var kurswert: Double = round(kurs * anzahl *100)/100

    @ColumnInfo(name = "wert")
    var wert: Double = round(kurs * anzahl *100)/100

    @ColumnInfo(name = "gewinn")
    var gewinn: Double = round(kurswert-wert)

    @ColumnInfo(name = "rendite")
    var rendite: Double = round(gewinn/wert *100)/100*100

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
