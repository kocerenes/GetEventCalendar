package com.ekocer.geteventcalendar.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun <R> CoroutineScope.executeAsyncTask(
    onStart: () -> Unit,
    doInBackground: () -> R,
    onPostExecute: (R) -> Unit,
    onCancelled: () -> Unit
) = launch {
    onStart()
    val result = withContext(Dispatchers.IO) {
        doInBackground() // runs in background thread without blocking the Main Thread
    }
    onPostExecute(result) // runs in Main Thread
    onCancelled()
}