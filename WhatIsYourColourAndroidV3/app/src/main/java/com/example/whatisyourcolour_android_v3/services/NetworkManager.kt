package com.example.whatisyourcolour_android_v3.services

import android.content.Context
import java.net.HttpURLConnection
import java.net.URL

class NetworkManager(private val context: Context) {
    fun sendData(data: String, ipAddress: String, port: Int) {
        val url = URL("http://$ipAddress:$port")
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"
        conn.setRequestProperty("Content-Type", "application/json")
        conn.doOutput = true

        val json = "{\"data\": \"$data\"}"
        val os = conn.outputStream
        os.write(json.toByteArray(Charsets.UTF_8))
        os.close()

        val responseCode = conn.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Data sent successfully
        } else {
            // Error sending data
        }
    }
}