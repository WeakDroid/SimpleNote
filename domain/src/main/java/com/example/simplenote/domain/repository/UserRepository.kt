package com.example.simplenote.domain.repository

import com.example.simplenote.domain.models.SaveUserDataParam
import com.example.simplenote.domain.models.UserData

interface UserRepository {

    fun saveData(saveParam: SaveUserDataParam): Boolean

    fun getData(): UserData

}