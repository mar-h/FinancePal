package de.hska.financepal.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.hska.financepal.entity.Instrument

@Dao
interface InstrumentDao {

    @Query("SELECT * FROM INST ORDER BY id ASC")
    fun getAllInstruments(): List<Instrument>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(instrument: Instrument)

    @Insert
    fun insertALL(instruments: List<Instrument>)

    @Query("DELETE FROM INST")
    fun deleteAll()
}