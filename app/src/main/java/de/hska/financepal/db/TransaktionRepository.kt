package de.hska.financepal.db

import de.hska.financepal.entity.Transaktion

class TransaktionRepository(private val transaktionDAO: TransaktionDAO) {
    /*
    * Repository für Transaktion-Datenoperationen
    */
    fun getTransaktionen() = transaktionDAO.getTransaktionen()
    fun getTransaktionenByPort(portId: Int) = transaktionDAO.getTransaktionenByPortId(portId)
    fun getTransaktionById(id: Int) = transaktionDAO.getTransaktionById(id)
    suspend fun insertTransaktion(transaktion: Transaktion) {
        transaktionDAO.insertTransaktion(transaktion)
    }
}