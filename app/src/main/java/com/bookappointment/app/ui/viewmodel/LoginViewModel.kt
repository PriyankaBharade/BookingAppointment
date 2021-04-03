package com.bookappointment.app.ui.viewmodel

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bookappointment.app.data.User
import com.bookappointment.app.data.UserDataModel
import com.bookappointment.app.util.Util

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    var btnSelected: ObservableBoolean? = null
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var userLogin: MutableLiveData<UserDataModel>? = null

    init {
        btnSelected = ObservableBoolean(false)
        email = ObservableField("")
        password = ObservableField("")
        userLogin = MutableLiveData<UserDataModel>()
    }

    fun onEmailChange(s: CharSequence, start: Int, before: Int, count: Int) {
        email?.set(s.toString())
        btnSelected?.set(
            Util.isEmailValid(s.toString())
                    && password?.get()!!.isNotEmpty()
        )
    }


    fun onPasswordChange(s: CharSequence, start: Int, before: Int, count: Int) {
        password?.set(s.toString())
        btnSelected?.set(
            Util.isEmailValid(email?.get().toString())
                    && s?.isNotEmpty()
        )
    }

    fun login() {
        userLogin!!.value = UserDataModel(
            email = email!!.get().toString(),
            password = password!!.get().toString()
        )
    }
}