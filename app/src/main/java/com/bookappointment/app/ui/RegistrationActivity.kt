package com.bookappointment.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bookappointment.R
import com.bookappointment.app.data.User
import com.bookappointment.app.db.DatabaseBuilder
import com.bookappointment.app.helper.DatabaseHelperImpl
import com.bookappointment.app.ui.viewmodel.RegistrationViewModel
import com.bookappointment.databinding.ActivityRegistrationBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegistrationActivity : AppCompatActivity() {
    var registrationViewModel: RegistrationViewModel? = null
    var activityRegistrationBinding: ActivityRegistrationBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegistrationBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_registration)
        registrationViewModel = ViewModelProviders.of(this).get(RegistrationViewModel::class.java)
        activityRegistrationBinding!!.viewModel = registrationViewModel
        initObservables()
    }

    private fun initObservables() {
        val dbHelper = DatabaseHelperImpl(
            DatabaseBuilder.getInstance(applicationContext)
        )
        registrationViewModel?.userLogin?.observe(this, Observer { user ->
            var list = ArrayList<User>()
            list.add(user)
            GlobalScope.launch {
                if (dbHelper.isRowIsExist(user.email.toString())) {
                    startActivity(Intent(this@RegistrationActivity, LoginActivity::class.java))
                } else {
                    dbHelper.insertAll(list)
                    startActivity(Intent(this@RegistrationActivity, LoginActivity::class.java))

                }
            }
        })
    }
}