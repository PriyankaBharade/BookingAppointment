package com.bookappointment.app.util

import com.bookappointment.R
import com.bookappointment.app.data.BookingSlotModel
import com.bookappointment.app.data.DoctorModel
import java.util.regex.Pattern

class Util {
    companion object {
        fun isEmailValid(email: String): Boolean {
            val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
            val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(email)
            return matcher.matches()
        }

        fun getDoctorList(): ArrayList<DoctorModel> {
            var doctorList = ArrayList<DoctorModel>()
            doctorList.add(DoctorModel("Dr. Nema" ,"nema@mailinator.com", R.mipmap.womanimage1, "Gynecologist", "Indore"))
            doctorList.add(
                DoctorModel(
                    "Children's Clinic",
                    "childerclinic@mailinator.com",
                    R.mipmap.clinicimage,
                    "Pediatrician",
                    "Indore"
                )
            )
            doctorList.add(
                DoctorModel(
                    "Dr Rashmi Gupta",
                    "rashmi@mailinator.com",
                    R.mipmap.womanimage2,
                    "psychologist",
                    "Indore"
                )
            )
            doctorList.add(
                DoctorModel(
                    "Dr. Sanjay Pacholi",
                    "sanjay@mailinator.com",
                    R.mipmap.menimage1,
                    "Skin and hair specialist",
                    "Indore"
                )
            )
            doctorList.add(DoctorModel("Dr. Mahajan",
                "mahajan@mailinator",
                R.mipmap.womanimage3, "Dentist", "Indore"))
            doctorList.add(
                DoctorModel(
                    "Dr. Vidhya Pancholi",
                    "vidhya@mailinator.com",
                    R.mipmap.womanimage4,
                    "Neuro Surgen",
                    "Indore"
                )
            )
            return doctorList
        }


        fun getBookingList(): ArrayList<BookingSlotModel> {
            var bookingSlotList = ArrayList<BookingSlotModel>()
            bookingSlotList.add(BookingSlotModel("08:00 AM - 03:00 PM", 0.2f, R.color.green, "Available"))
            bookingSlotList.add(
                BookingSlotModel("12:00 PM - 08:00 PM", 0.8f, R.color.red,"Almost Full")
            )
            bookingSlotList.add(
                BookingSlotModel("09:00 AM - 06:00 PM", 0.2f,R.color.green, "Available")
            )
            bookingSlotList.add(
                BookingSlotModel("11:00 AM - 02:00 PM", 0.8f,R.color.red, "Almost Full")
            )
            bookingSlotList.add(BookingSlotModel("12:00 AM - 04:00 PM", 0.4f, R.color.yellow,"Fast Filling"))
            bookingSlotList.add(
                BookingSlotModel("10:00 AM - 06:00 PM", 0.4f,R.color.yellow, "Fast Filling")
            )
            return bookingSlotList
        }
    }
}