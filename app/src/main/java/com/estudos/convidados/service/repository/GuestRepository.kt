package com.estudos.convidados.service.repository

import android.content.Context
import com.estudos.convidados.service.model.Guest

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance (context: Context): GuestRepository {
            if(!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun save(guest: Guest) {

    }

    fun getAll(): List<Guest> {
        val list: MutableList<Guest> = ArrayList()
        return list
    }

    fun getPresents(): List<Guest> {
        val list: MutableList<Guest> = ArrayList()
        return list
    }

    fun getAbsents(): List<Guest> {
        val list: MutableList<Guest> = ArrayList()
        return list
    }

    fun update(guest: Guest) {

    }

    fun delete(guest: Guest) {

    }
}