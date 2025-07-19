package com.example.outcomeschool

import android.content.ComponentCallbacks2
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),ComponentCallbacks2 {
    private val idList = arrayListOf<Int>()
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        logCurrentMemoryProfile("experiment started")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logCurrentMemoryProfile("onCreate after setContent View")

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        logCurrentMemoryProfile("onCreate after default codes")

        Thread{
            Thread.sleep(10000)
            logCurrentMemoryProfile("onCreate inside thread")
        }.start()
    }

    private fun logCurrentMemoryProfile(src:String){
        val maxMemoryInMB = Runtime.getRuntime().maxMemory() / 1024 / 1024
        val totalMemoryInMB = Runtime.getRuntime().totalMemory() /1024 /1024
        val freeMemoryInMB = Runtime.getRuntime().freeMemory() /1024/1024
        val usedMemoryInMB = totalMemoryInMB - freeMemoryInMB
        Log.d(TAG,"******************")
        Log.d(TAG,src)
        Log.d(TAG,"maxMemoryInMB: $maxMemoryInMB")
        Log.d(TAG,"totalMemoryInMB: $totalMemoryInMB")
        Log.d(TAG,"freeMemoryInMB: $freeMemoryInMB")
        Log.d(TAG,"usedMemoryInMB: $usedMemoryInMB")

    }

     fun onExecuteClick(view:View) {
        for (i in 0..10_00_000){
            idList.add(i)
        }
         logCurrentMemoryProfile("execute btn: ")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.d(TAG,"onTrimMemory: $level")
    }
}