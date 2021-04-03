package com.bookappointment.app.data

data class BookingSlotModel(
    val time: String,
    val range: Float,
    val color: Int,
    val availability: String
)