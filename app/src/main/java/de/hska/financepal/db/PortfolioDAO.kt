package de.hska.financepal.db

import androidx.lifecycle.LiveData
import androidx.room.*
import de.hska.financepal.entity.Portfolio

@Dao
interface PortfolioDAO {
    @Query("SELECT * FROM P ORDER BY id")
    fun getPortfolios(): LiveData<List<Portfolio>>

    @Query("SELECT * FROM P WHERE id = :portId")
    fun getPortfolioById(portId: Int): LiveData<Portfolio>

    @Query("SELECT * FROM P WHERE besitzer = :userId")
    fun getPortfolioByBesitzer(userId: Int): LiveData<Portfolio>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(portfolios: List<Portfolio>)

    @Insert
    suspend fun insertPortfolio(portfolio: Portfolio)

    @Delete
    suspend fun deletePortfolio(portfolio: Portfolio)
}