package de.hska.financepal.db

import androidx.lifecycle.LiveData
import de.hska.financepal.entity.Instrument

class InstrumentRepository(private val instrumentDao: InstrumentDao) {

    val allInstruments: LiveData<List<Instrument>> = instrumentDao.getAllInstruments()

    suspend fun insert(instrument: Instrument) {
        instrumentDao.insert(instrument)
    }
}