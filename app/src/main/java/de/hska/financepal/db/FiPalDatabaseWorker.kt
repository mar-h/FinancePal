package de.hska.financepal.db

import android.content.Context
import android.util.JsonReader
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope

/*
class FiPalDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) :CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open().use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val
                }
            }

        }
    }
}*/
