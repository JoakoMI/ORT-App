package com.joako.ort_app

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.joako.ort_app.data.retrofit.RetroFitInstance
import com.joako.ort_app.navigation.Routes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainActivityViewModel : ViewModel() {

    val retrofitInstance: RetroFitInstance = RetroFitInstance
    private var _titleBar = MutableLiveData("Inicio")
    private var _route = mutableStateOf(Routes.SPLASH_SCREEN)
    private val _drawerShouldBeOpened = MutableStateFlow(false)
    val drawerShouldBeOpened = _drawerShouldBeOpened.asStateFlow()



    fun setRoute(route: Routes) {
        _route.value = route.toString()
    }

    fun getRoute(): String {
        return _route.value
    }

    fun openDrawer() {
        _drawerShouldBeOpened.value = true
    }

    fun resetOpenDrawerAction() {
        _drawerShouldBeOpened.value = false
    }

    val titleBar: LiveData<String>
        get() = _titleBar

    fun setTitleBar(newTitle: String) {
        _titleBar.value = newTitle
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                MainActivityViewModel()
            }
        }
    }
}