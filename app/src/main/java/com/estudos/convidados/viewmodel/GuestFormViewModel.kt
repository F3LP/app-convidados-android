package com.estudos.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.estudos.convidados.service.model.Guest
import com.estudos.convidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    private var mGuest = MutableLiveData<Guest>()
    val guest: LiveData<Guest> = mGuest

    fun save(id: Int, name: String, presence: Boolean) {
        val guest = Guest().apply {
            this.id = id
            this.name = name
            this.presence = presence
        }

        if (id != 0) {
            mSaveGuest.value = mGuestRepository.update(guest)
        } else {
            mSaveGuest.value = mGuestRepository.save(guest)
        }
    }

    fun load(id: Int) {
        mGuest.value = mGuestRepository.get(id)
    }
}