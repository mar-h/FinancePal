package de.hska.financepal.db

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import de.hska.financepal.entity.Benutzer

class BenutzerRepository(private val benutzerDao: BenutzerDAO) {
    /*
    * Repository für Benutzer-Datenoperationen
    */
    val allBenutzer: LiveData<List<Benutzer>> = benutzerDao.getBenutzer()
    fun getBenutzerById(userId: Int) = benutzerDao.getBenutzerById(userId)
    fun getBenutzerByName(name: String) = benutzerDao.getBenutzerByName(name)

    @WorkerThread
    suspend fun insertBenutzer(benutzer: Benutzer) {
        benutzerDao.insertBenutzer(benutzer)
    }
}