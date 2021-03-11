package com.estudos.convidados.view.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estudos.convidados.R
import com.estudos.convidados.service.model.Guest
import com.estudos.convidados.view.adapter.listener.GuestListener

class GuestAdapter : RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    private var mGuestList: List<Guest> = arrayListOf()
    private lateinit var mListener: GuestListener

    companion object {
        var createCount: Int = 0
        var bindCount: Int = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest, parent, false)
        return GuestViewHolder(item, mListener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    override fun getItemCount() = mGuestList.count()

    fun updateGuests(list: List<Guest>){
        mGuestList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: GuestListener) {
        mListener = listener
    }


    class GuestViewHolder(itemView: View, private val listener: GuestListener) : RecyclerView.ViewHolder(itemView) {

        fun bind(guest: Guest) {

            val textName = itemView.findViewById<TextView>(R.id.text_name)
            textName.text = guest.name

            textName.setOnClickListener {
                listener.onClick(guest.id)
            }

            textName.setOnLongClickListener {

                AlertDialog.Builder(itemView.context)
                    .setTitle(R.string.remocao_convidado)
                    .setMessage(R.string.deseja_remover)
                    .setPositiveButton(R.string.remover) {
                        dialog, whick -> listener.onDelete(guest.id)
                    }
                    .setNeutralButton(R.string.cancelar, null)
                    .show()
                true
            }
        }
    }
}