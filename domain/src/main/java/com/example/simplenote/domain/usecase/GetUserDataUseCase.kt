package com.example.simplenote.domain.usecase

import com.example.simplenote.domain.models.UserData
import com.example.simplenote.domain.repository.UserRepository

class GetUserDataUseCase(private val userRepository: UserRepository) {

    fun execute(): UserData {
        return userRepository.getData()
    }
}
