package com.bookappointment.app.ui

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.bookappointment.R
import com.bookappointment.app.ui.adapter.AdapterBookingSlotList
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.view.calender.horizontal.umar.horizontalcalendarview.DayDateMonthYearModel
import com.view.calender.horizontal.umar.horizontalcalendarview.HorizontalCalendarListener
import kotlinx.android.synthetic.main.activity_booking_slot.*


class BookingSlotActivity : AppCompatActivity(), HorizontalCalendarListener,
    AdapterBookingSlotList.SetOnClick {
    var email: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_slot)
        email = intent.getStringExtra("email")
        Log.e("TAG", email.toString())
        rv_list.adapter = AdapterBookingSlotList(this, this)
        calender_view.setContext(this@BookingSlotActivity)

    }

    override fun updateMonthOnScroll(selectedDate: DayDateMonthYearModel?) {
        tv_month_name.text = selectedDate?.month
    }

    override fun newDateSelected(selectedDate: DayDateMonthYearModel?) {
        tv_month_name.text = selectedDate?.month
    }

    override fun onClick() {
        val actionCodeSettings =
            ActionCodeSettings.newBuilder() // URL you want to redirect back to. The domain (www.example.com) for this
                // URL must be whitelisted in the Firebase Console.
                .setUrl("https://com.bookappointment/BookingSlotActivity") // This must be true
                .setHandleCodeInApp(true)
                .setAndroidPackageName(
                    "com.bookappointment",
                    true,  /* installIfNotAvailable */
                    "12" /* minimumVersion */
                )
                .build()
        val auth = FirebaseAuth.getInstance()
        auth.sendSignInLinkToEmail(email.toString(), actionCodeSettings)
            .addOnCompleteListener { task ->
                Log.e("TAG Email", task.exception?.message.toString())
                Log.e("TAG Email", task.isCanceled?.toString())
                AlertDialog.Builder(this)
                    .setMessage("Your Booking Appointment request successfully sent to the " + email.toString() + " doctor ")
                    .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                        finish()
                    }).show()
            }
    }
}