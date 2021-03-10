package com.estudos.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.estudos.convidados.service.model.Guest
import com.estudos.convidados.service.repository.GuestRepository

class AllGuestsViewModel(application: Application): AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)
    private val mGuestList = MutableLiveData<List<Guest>>()

    val guestList: LiveData<List<Guest>> = mGuestList

    fun load() {
        mGuestList.value = mGuestRepository.getAll()
    }
}