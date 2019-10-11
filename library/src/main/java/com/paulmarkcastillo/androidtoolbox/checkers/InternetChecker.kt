package com.paulmarkcastillo.androidtoolbox.checkers

import android.net.TrafficStats
import kotlinx.coroutines.*
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

open class InternetChecker {
    private lateinit var internetCheckJob: Job

    open fun hasInternetAccess(callback: InternetAccessCallback) {
        internetCheckJob = GlobalScope.launch {
            withContext(Dispatchers.Main) {
                callback.onInternetAccessResult(checkInternetAccess().await())
            }
        }
    }

    fun cancelChecking() {
        if (::internetCheckJob.isInitialized && internetCheckJob.isActive) {
            internetCheckJob.cancel()
        }
    }

    private fun checkInternetAccess(): Deferred<Boolean> {
        return checkInternetAccess("8.8.8.8")
    }

    private fun checkInternetAccess(dns: String): Deferred<Boolean> {
        val socket = Socket()

        return GlobalScope.async {
            try {
                val googleDns = dns
                val dnsPort = 53
                val timeout = 5000
                val socketAddress = InetSocketAddress(googleDns, dnsPort)
                TrafficStats.tagSocket(socket)
                socket.connect(socketAddress, timeout)
                true
            } catch (e: IOException) {
                e.printStackTrace()
                false
            } finally {
                socket.close()
            }
        }
    }

    interface InternetAccessCallback {
        fun onInternetAccessResult(hasInternetAccess: Boolean)
    }
}