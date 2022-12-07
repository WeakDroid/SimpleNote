package com.example.simplenote.domain.usecase

import com.example.simplenote.domain.models.SaveUserDataParam
import com.example.simplenote.domain.repository.UserRepository

class SaveUserDataUseCase(private val userRepository: UserRepository) {
    
    fun execute(param: SaveUserDataParam): Boolean {

        val oldUserData = userRepository.getData()

        if (oldUserData.firstData == param.data) {
            return true
        }
        val result: Boolean = userRepository.saveData(saveParam = param)
        return result
    }
}