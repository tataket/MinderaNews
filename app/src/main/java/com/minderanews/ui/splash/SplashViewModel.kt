package com.minderanews.ui.splash

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SplashViewModel : ViewModel() {

    private val _navigate: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val navigate: StateFlow<Boolean?> = _navigate

    fun isExistUserAuth() {
        _navigate.value = FirebaseAuth.getInstance().currentUser != null
    }

}