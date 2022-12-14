package com.example.simplenote.data.storage

import com.example.simplenote.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}