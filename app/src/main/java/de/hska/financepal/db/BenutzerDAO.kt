package de.hska.financepal.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.hska.financepal.entity.Benutzer
import de.hska.financepal.entity.Transaktion

@Dao
interface BenutzerDAO {
    @Query("SELECT * FROM B ORDER BY name")
    fun getBenutzer(): LiveData<List<Benutzer>>

    @Query("SELECT * FROM B WHERE name = :name ORDER BY vorname")
    fun getBenutzerByName(name: String): LiveData<Benutzer>

    @Query("SELECT * FROM B WHERE id = :userId")
    fun getBenutzerById(userId: Int): LiveData<Benutzer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(benutzer: List<Benutzer>)

    @Insert
    suspend fun insertBenutzer(benutzer: Benutzer)
}