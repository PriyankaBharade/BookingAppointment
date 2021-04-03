package com.bookappointment.app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bookappointment.R
import com.bookappointment.app.data.BookingSlotModel
import com.bookappointment.app.util.Util.Companion.getBookingList
import com.bookappointment.databinding.ItemBookingLayoutBinding
import kotlinx.android.synthetic.main.item_booking_layout.view.*

class AdapterBookingSlotList : RecyclerView.Adapter<AdapterBookingSlotList.MyViewHolder> {
    var context: Context? = null
    var setOnClick: SetOnClick? = null

    constructor(context: Context,setOnClick: SetOnClick) {
        this.context = context
        this.setOnClick = setOnClick
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: BookingSlotModel) {
            with(itemView) {
                itemView.tv_time_duration.text = book.time
                itemView.seekbar.value = book.range
                itemView.tv_availability.text = book.availability

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemBookingLayoutBinding: ItemBookingLayoutBinding? = null
        itemBookingLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_booking_layout,
            parent,
            false
        )
        var itemView = itemBookingLayoutBinding.root
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return getBookingList().size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getBookingList()[position])
        holder.itemView.setOnClickListener {
            setOnClick?.onClick()
        }
    }

    interface SetOnClick{
        fun onClick()
    }

}