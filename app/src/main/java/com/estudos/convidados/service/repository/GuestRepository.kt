package com.estudos.convidados.service.repository

import android.content.Context
import com.estudos.convidados.service.model.Guest

class GuestRepository (context: Context) {

    private val mDataBase = GuestDataBase.getDatabase(context).guestDAO()

    fun get(id: Int): Guest {
        return mDataBase.get(id)
    }

    fun save(guest: Guest): Boolean {
        return mDataBase.save(guest) > 0
    }

    fun getAll(): List<Guest> {
        return mDataBase.getInvited()
    }

    fun getPresents(): List<Guest> {
        return mDataBase.getPresent()
    }

    fun getAbsents(): List<Guest> {
        return mDataBase.getAbsent()
    }

    fun update(guest: Guest): Boolean {
        return mDataBase.update(guest) > 0
    }

    fun delete(guest: Guest) {
        return mDataBase.delete(guest)
    }
}