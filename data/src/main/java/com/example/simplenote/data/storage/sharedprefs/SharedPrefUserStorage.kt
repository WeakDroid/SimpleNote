package com.example.simplenote.data.storage.sharedprefs

import android.content.Context
import com.example.simplenote.data.storage.UserStorage
import com.example.simplenote.data.storage.models.User

private const val SHARED_PREFS_DATA = "shared_prefs_data"
private const val KEY_FIRST_DATA = "first_data"
private const val KEY_LAST_DATA = "last_data"
private const val DEFAULT_LAST_DATA = "default last data"
private const val DEFAULT_FIRST_DATA = "default first data"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_DATA, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_DATA, user.firstData).apply()
        sharedPreferences.edit().putString(KEY_LAST_DATA, user.lastData).apply()
        return true
    }

    override fun get(): User {
        val firstData =
            sharedPreferences.getString(KEY_FIRST_DATA, DEFAULT_FIRST_DATA) ?: DEFAULT_FIRST_DATA
        val lastData =
            sharedPreferences.getString(KEY_LAST_DATA, DEFAULT_LAST_DATA) ?: DEFAULT_LAST_DATA

        return User(firstData = firstData, lastData = lastData)
    }

}