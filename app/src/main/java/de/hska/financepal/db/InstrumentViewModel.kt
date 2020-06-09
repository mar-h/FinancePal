package de.hska.financepal.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import de.hska.financepal.entity.Instrument
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InstrumentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: InstrumentRepository

    val allInstruments: LiveData<List<Instrument>>

    init {
        val instrumentDao = AppDatabase.getDatabase(application, viewModelScope).instrumentDao()
        repository = InstrumentRepository(instrumentDao)
        allInstruments = repository.allInstruments
    }

    fun insert(instrument: Instrument) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(instrument)
    }
}