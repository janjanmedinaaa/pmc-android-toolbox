package com.paulmarkcastillo.androidtoolbox.datetime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone
import java.util.Date

class WorldClockManager {

    companion object {
        const val WORLD_CLOCK_ROUTE = "http://worldtimeapi.org/api/timezone/Etc/UTC"
    }

    fun getCurrentDateTime(): LiveData<WorldClockResponse> {
        val worldClockResponse = MutableLiveData<WorldClockResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            worldClockResponse.postValue(getCurrentDateTimeSync())
        }
        return worldClockResponse
    }

    private fun getCurrentDateTimeSync(): WorldClockResponse {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(WORLD_CLOCK_ROUTE)
            .build()

        try {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val jsonResponse = JSONObject(response.body!!.string())
                val sdf = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.getDefault())
                sdf.timeZone = TimeZone.getTimeZone("UTC")
                val date = sdf.parse(jsonResponse.getString("utc_datetime"))
                return WorldClockResponse(date, NetworkStatus.SUCCESS)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return WorldClockResponse(Date(), NetworkStatus.ERROR)
    }

    data class WorldClockResponse(var responseContent: Date, var networkStatus: NetworkStatus)

    enum class NetworkStatus {
        SUCCESS,
        ERROR
    }
}