package com.bookappointment.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bookappointment.R
import com.bookappointment.app.data.DoctorModel
import com.bookappointment.app.ui.adapter.AdapterDoctorList
import com.bookappointment.app.ui.interfaces.SetOnItemClickListener
import kotlinx.android.synthetic.main.activity_booking_slot.*

class DoctorListActivity : AppCompatActivity(), SetOnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_list)
        rv_list.adapter = AdapterDoctorList(this, this)
    }

    override fun onItemSelectListener(doctorModel: DoctorModel) {
        startActivity(Intent(this, BookingSlotActivity::class.java)
            .putExtra("email", doctorModel.email))
    }
}