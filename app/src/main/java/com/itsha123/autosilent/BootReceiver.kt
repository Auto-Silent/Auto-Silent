package com.itsha123.autosilent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.i("BootReceiver", "Boot completed")
        if (intent.action == Intent.ACTION_LOCKED_BOOT_COMPLETED) {
            val workRequest = OneTimeWorkRequest.Builder(BootWorker::class.java).build()
            WorkManager.getInstance(context).enqueue(workRequest)
        }
    }
}