package com.bookappointment.app.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bookappointment.R
import com.bookappointment.app.db.DatabaseBuilder
import com.bookappointment.app.helper.DatabaseHelperImpl
import com.bookappointment.app.data.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}