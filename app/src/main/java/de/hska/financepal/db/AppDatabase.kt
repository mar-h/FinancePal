package de.hska.financepal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import de.hska.financepal.entity.Benutzer
import de.hska.financepal.entity.Portfolio
import de.hska.financepal.entity.Transaktion

@Database(entities = [Benutzer::class, Portfolio::class, Transaktion::class],
                        version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun benutzerDAO(): BenutzerDAO
    abstract fun portfolioDAO(): PortfolioDAO
    abstract fun transationDAO(): TransaktionDAO

    companion object {

        // Singleton, um mehrere Instanzen zu verhindern
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "FiPal-DB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

        /*private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "FiPal-DB")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<FiPalDatabaseWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })
                .build()
        }*/
    }
}