package com.estudos.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.estudos.convidados.service.constants.GuestConstants
import com.estudos.convidados.service.model.Guest
import com.estudos.convidados.service.repository.GuestRepository

class GuestsViewModel(application: Application): AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository(application.applicationContext)
    private val mGuestList = MutableLiveData<List<Guest>>()

    val guestList: LiveData<List<Guest>> = mGuestList

    fun load(filter: Int) {

        if (filter == GuestConstants.FILTER.EMPTY) {
            mGuestList.value = mGuestRepository.getAll()
        } else if (filter == GuestConstants.FILTER.PRESENT){
            mGuestList.value = mGuestRepository.getPresents()
        } else {
            mGuestList.value = mGuestRepository.getAbsents()
        }
    }

    fun delete(id: Int) {
        val guest = mGuestRepository.get(id)
        mGuestRepository.delete(guest)
    }
}