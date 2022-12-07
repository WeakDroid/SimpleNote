package com.example.simplenote.data.repository

import com.example.simplenote.data.storage.models.User
import com.example.simplenote.data.storage.UserStorage
import com.example.simplenote.domain.models.SaveUserDataParam
import com.example.simplenote.domain.models.UserData
import com.example.simplenote.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveData(saveParam: SaveUserDataParam): Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getData(): UserData {

        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserDataParam): User {
        return User(firstData = saveParam.data, lastData = "")
    }

    private fun mapToDomain(user: User): UserData {
        return UserData(firstData = user.firstData, lastData = user.lastData)
    }
}