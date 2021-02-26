package com.example.androiddevchallenge.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.preference.PreferenceManager

fun Context.isOnline(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork

    if (network != null) {
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
        if (networkCapabilities != null) {
            return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        }
    }

    return false
}

fun Context.setBooleanPreference(key: String, value: Boolean) =
    PreferenceManager.getDefaultSharedPreferences(this)
        .edit()
        .putBoolean(key, value)
        .apply()

fun Context.getBooleanPreference(key: String) =
    PreferenceManager.getDefaultSharedPreferences(this)
        .getBoolean(key, false)
