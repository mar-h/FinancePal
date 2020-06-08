package de.hska.financepal.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import de.hska.financepal.entity.Transaktion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransaktionViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TransaktionRepository

    val transaktionen: LiveData<List<Transaktion>>

    init {
        val transaktionDao = AppDatabase.getDatabase(application).transaktionDAO()
        repository = TransaktionRepository(transaktionDao)
        transaktionen = repository.getTransaktionen()
    }

    fun insert(transaktion: Transaktion) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertTransaktion(transaktion)
    }
}