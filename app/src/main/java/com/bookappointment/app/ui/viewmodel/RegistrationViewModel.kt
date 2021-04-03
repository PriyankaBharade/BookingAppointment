package com.bookappointment.app.ui.viewmodel

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bookappointment.app.data.User
import com.bookappointment.app.util.Util

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
    var btnSelected: ObservableBoolean? = null
    var userName: ObservableField<String>? = null
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var userLogin: MutableLiveData<User>? = null

    init {
        btnSelected = ObservableBoolean(false)
        userName = ObservableField("")
        email = ObservableField("")
        password = ObservableField("")
        userLogin = MutableLiveData<User>()
    }

    fun onEmailChange(s: CharSequence, start: Int, before: Int, count: Int) {
        email?.set(s.toString())
        btnSelected?.set(
            Util.isEmailValid(s.toString()) && userName?.get()!!.isNotEmpty()
                    && password?.get()!!.isNotEmpty()
        )
    }

    fun onNameChange(s: CharSequence, start: Int, before: Int, count: Int) {
        userName?.set(s.toString())
        btnSelected?.set(
            Util.isEmailValid(email?.get().toString()) && s.isNotEmpty()
                    && password?.get()!!.isNotEmpty()
        )
    }

    fun onPasswordChange(s: CharSequence, start: Int, before: Int, count: Int) {
        password?.set(s.toString())
        btnSelected?.set(
            Util.isEmailValid(email?.get().toString()) && userName?.get()!!.isNotEmpty()
                    && s?.isNotEmpty()
        )
    }

    fun register() {
        userLogin!!.value = User( name = userName!!.get().toString(),
            email = email!!.get().toString(),
            id = 0,
            password =password!!.get().toString())
    }
}