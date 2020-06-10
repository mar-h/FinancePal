package de.hska.financepal.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Inst")
data class Instrument(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int,

   // val isin: String?,
    @ColumnInfo(name = "typ")
    val typ: String?,

    @ColumnInfo(name = "name")
    val name: String?,

   // val kaufwert: Double?,

   // val anzahl: Int?,

    @ColumnInfo(name = "kurs")
    val kurs: Double?,

    @ColumnInfo(name = "wert")
    val wert: Double?

   // val curr: String?,

    // val rendite: Double?
) {

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
