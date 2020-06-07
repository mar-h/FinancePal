package de.hska.financepal.db

import androidx.lifecycle.LiveData
import androidx.room.*
import de.hska.financepal.entity.Transaktion

@Dao
interface TransaktionDAO {
    @Query("SELECT * FROM T ORDER BY id")
    fun getTransaktionen(): LiveData<List<Transaktion>>

    @Query("SELECT * FROM T WHERE portId = :portId ORDER BY transDatum")
    fun getTransaktionenByPortId(portId: Int): LiveData<List<Transaktion>>

    @Query("SELECT * FROM T WHERE id = :transId")
    fun getTransaktionById(transId: Int): LiveData<Transaktion>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(transaktionen: List<Transaktion>)

    @Insert
    suspend fun insertTransaktion(transaktion: Transaktion)

    @Delete
    suspend fun deleteTransaktion(transaktion: Transaktion)
}