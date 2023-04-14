package com.example.millenialfit.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.millenialfit.data.model.Training
import com.example.millenialfit.data.remote.TrainingAPI

class Repository(val api: TrainingAPI) {

    private var _exerciseList = MutableLiveData<List<Training>>()
    val exerciseList: LiveData<List<Training>>
        get() = _exerciseList

    suspend fun getExercises(){
        val import = api.retrofitService.getExercises()

        _exerciseList.value = import.training
    }

}