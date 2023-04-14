package com.example.millenialfit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.millenialfit.data.Repository
import com.example.millenialfit.data.remote.TrainingAPI
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = Repository(TrainingAPI)
    val exerciseList = repository.exerciseList

    private var _greetingName = MutableLiveData<String>("")
    val greetingName: LiveData<String>
        get() = _greetingName

    init {
        viewModelScope.launch {
            repository.getExercises()
        }
    }

    fun saveName(name:String){
        _greetingName.value = name
    }
}