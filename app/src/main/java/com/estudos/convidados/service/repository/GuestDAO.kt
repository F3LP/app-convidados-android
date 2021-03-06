package com.estudos.convidados.service.repository

import androidx.room.*
import com.estudos.convidados.service.model.Guest

@Dao
interface GuestDAO {

    @Insert
    fun save(guest: Guest): Long

    @Update
    fun update(guest: Guest): Int

    @Delete
    fun delete(guest: Guest)

    @Query("SELECT * FROM Guest WHERE id = :id")
    fun get(id: Int): Guest

    @Query("SELECT * FROM Guest")
    fun getInvited(): List<Guest>

    @Query("SELECT * FROM Guest WHERE presence = 1")
    fun getPresent(): List<Guest>

    @Query("SELECT * FROM Guest WHERE presence = 0")
    fun getAbsent(): List<Guest>
}