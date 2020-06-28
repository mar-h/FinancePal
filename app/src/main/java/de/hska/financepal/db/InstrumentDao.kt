package de.hska.financepal.db

import androidx.lifecycle.LiveData
import androidx.room.*
import de.hska.financepal.entity.Instrument

@Dao
interface InstrumentDao {

    @Query("SELECT * FROM Inst")
    fun getAllInstruments(): List<Instrument>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(instrument: Instrument)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertALL(instruments: List<Instrument>)

    @Query("DELETE FROM INST")
    fun deleteAll()

    @Delete
    fun delete(instrument: Instrument)


}