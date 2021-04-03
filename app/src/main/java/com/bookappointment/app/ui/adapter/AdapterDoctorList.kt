package com.bookappointment.app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bookappointment.R
import com.bookappointment.app.ui.interfaces.SetOnItemClickListener
import com.bookappointment.app.util.Util.Companion.getDoctorList
import de.hdodenhof.circleimageview.CircleImageView

class AdapterDoctorList : RecyclerView.Adapter<AdapterDoctorList.MyViewHolder> {
    var context: Context? = null
    var setOnItemClickList: SetOnItemClickListener? = null

    constructor(context: Context, setOnItemClickList: SetOnItemClickListener) {
        this.context = context
        this.setOnItemClickList = setOnItemClickList
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_user_name: TextView = itemView.findViewById(R.id.tv_user_name)
        var tv_designation: TextView = itemView.findViewById(R.id.tv_designation)
        var tv_location: TextView = itemView.findViewById(R.id.tv_location)
        var tv_email: TextView = itemView.findViewById(R.id.tv_email)
        var image_view: CircleImageView = itemView.findViewById(R.id.image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return getDoctorList().size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var doctorModel = getDoctorList()[position]
        holder.tv_user_name.text = doctorModel.name
        holder.tv_designation.text = doctorModel.designation
        holder.tv_location.text = doctorModel.location
        holder.tv_email.text = doctorModel.email
        holder.image_view.setImageResource(doctorModel.profilePic)
        holder.itemView.setOnClickListener {
            setOnItemClickList?.onItemSelectListener(getDoctorList()[position])
        }
    }

}