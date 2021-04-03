package com.bookappointment.app.ui

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bookappointment.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val background: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(5 * 1000)
                    val i = Intent(baseContext, RegistrationActivity::class.java)
                    startActivity(i)
                    finish()
                } catch (e: Exception) {
                }
            }
        }
        background.start()
    }
}