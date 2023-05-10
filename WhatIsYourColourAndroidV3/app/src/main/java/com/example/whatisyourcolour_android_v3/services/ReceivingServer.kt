package com.example.whatisyourcolour_android_v3.services

import android.util.Log
import org.json.JSONObject
import java.io.IOException

class ReceivingServer(port: Int) : NanoHTTPD(port) {
    override fun serve(session: IHTTPSession): Response {
        val inputStream = session.inputStream
        val buffer = ByteArray(1024)
        var read: Int
        val builder = StringBuilder()
        while (inputStream.read(buffer).also { read = it } != -1) {
            builder.append(String(buffer, 0, read))
        }

        val data = JSONObject(builder.toString()).getString("data")
        // Do something with the data

        return newFixedLengthResponse("OK")
    }
}