package com.example.simplenote.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplenote.domain.models.SaveUserDataParam
import com.example.simplenote.domain.models.UserData
import com.example.simplenote.domain.usecase.GetUserDataUseCase
import com.example.simplenote.domain.usecase.SaveUserDataUseCase

class MainViewModel(
    private val getUserDataUseCase: GetUserDataUseCase,
    private val saveUserDataUseCase: SaveUserDataUseCase
) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM created")
        super.onCleared()
    }


    fun save(text: String) {
        val params = SaveUserDataParam(data = text)
        val resultData: Boolean = saveUserDataUseCase.execute(param = params)
        resultLiveMutable.value = "Save result $resultData"
    }

    fun load() {
        val userData: UserData = getUserDataUseCase.execute()
        resultLiveMutable.value = "${userData.firstData} ${userData.lastData}"
    }
}