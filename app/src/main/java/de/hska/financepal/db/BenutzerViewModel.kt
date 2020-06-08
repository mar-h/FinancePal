package de.hska.financepal.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import de.hska.financepal.entity.Benutzer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BenutzerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BenutzerRepository

    val allBenutzer: LiveData<List<Benutzer>>

    init {
        val benutzerDao = AppDatabase.getDatabase(application).benutzerDAO()
        repository = BenutzerRepository(benutzerDao)
        allBenutzer = repository.allBenutzer
    }

    fun insert(benutzer: Benutzer) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertBenutzer(benutzer)
    }
}