package com.bookappointment.app.ui.interfaces

import com.bookappointment.app.data.DoctorModel

interface SetOnItemClickListener {
    fun onItemSelectListener(doctorModel: DoctorModel)
}