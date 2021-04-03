package com.bookappointment.app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bookappointment.R
import com.bookappointment.app.data.User
import com.bookappointment.app.data.UserDataModel
import com.bookappointment.app.db.DatabaseBuilder
import com.bookappointment.app.helper.DatabaseHelperImpl
import com.bookappointment.app.ui.viewmodel.LoginViewModel
import com.bookappointment.app.ui.viewmodel.RegistrationViewModel
import com.bookappointment.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    var loginViewModel: LoginViewModel? = null
    var activityLoginBinding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        activityLoginBinding!!.viewModel = loginViewModel
        initObservables()
    }

    private fun initObservables() {
        val dbHelper = DatabaseHelperImpl(
            DatabaseBuilder.getInstance(applicationContext)
        )
        loginViewModel?.userLogin?.observe(this, Observer { user ->
            GlobalScope.launch {
                var list = dbHelper.getUsers()
                if (list[0]?.email == user.email && list[0]?.password == user.password) {
                    startActivity(Intent(this@LoginActivity, DoctorListActivity::class.java))
                } else {
                    Snackbar.make(mainLayout, "You are trying to login with wrong credential", Snackbar.LENGTH_SHORT)
                        .show()
                }

                // var list1 = dbHelper.getUsers()
            }
        })
    }
}