package com.estudos.convidados.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estudos.convidados.R
import com.estudos.convidados.service.model.Guest

class GuestAdapter : RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    private var mGuestList: List<Guest> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest, parent, false)
        return GuestViewHolder(item)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    override fun getItemCount() = mGuestList.count()

    fun updateGuests(list: List<Guest>){
        mGuestList = list
        notifyDataSetChanged()
    }


    class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(guest: Guest) {
            itemView.findViewById<TextView>()
        }
    }
}