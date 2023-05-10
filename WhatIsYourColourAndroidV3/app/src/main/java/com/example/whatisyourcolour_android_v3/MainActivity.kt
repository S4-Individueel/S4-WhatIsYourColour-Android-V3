package com.example.whatisyourcolour_android_v3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatisyourcolour_android_v3.services.NetworkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkManager = NetworkManager(this)
        networkManager.sendData("sender sends data", "", "")
    }
}