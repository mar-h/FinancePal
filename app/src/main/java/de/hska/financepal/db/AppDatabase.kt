package de.hska.financepal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import de.hska.financepal.entity.Instrument
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Instrument::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun instrumentDao(): InstrumentDao

    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var instrumentDao = database.instrumentDao()

                    instrumentDao.deleteAll()

                    var instrument = Instrument(
                        1, "881823", "Samsung",
                        "Aktie", 36500.00,50, 883.00,
                        44150.00,"EUR", 20.96)

                    instrument = Instrument(
                        2, "863186", "AMD",
                        "Aktie", 53928.00, 1400, 46.46,
                        65044.00, "EUR", 20.61)
                }
            }
        }
    }

    companion object {

        // Singleton, um mehrere Instanzen zu verhindern
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "FiPal"
                )
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}