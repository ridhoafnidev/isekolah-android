package com.smpsantoyosef.isekolah.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _isSplash = MutableStateFlow(false)
    val isSplash get() = _isSplash

    init {
        viewModelScope.launch {
            delay(2000L)
            _isSplash.value = true
        }
    }
}