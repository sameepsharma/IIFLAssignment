package com.sameep.iiflassignment.workmanager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.shaadiassignment.rest.FetchService
import com.example.shaadiassignment.rest.RetrofitProvider
import com.sameep.iiflassignment.db.ArticlesDb
import com.sameep.iiflassignment.utils.isInternetAvailable
import java.text.SimpleDateFormat

class UpdateDataRecurringWorker(val context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {

        val apiClient = RetrofitProvider.retrofit!!.create(FetchService::class.java)
        if (context.isInternetAvailable()) {
            Log.e("DoingWork : ", "Yes")
            ArticlesDb.getDatabase(context).articleDao().insertArticles(apiClient.getArticles())
            return Result.success()
        }
        return Result.failure()
    }
}