package com.smpsantoyosef.feature.auth.ui.screen.login

import com.smpsantoyosef.entity.User

sealed class LoginScreenState {
    class Success(val user: User): LoginScreenState()
    class Error(val message:  String): LoginScreenState()
    object Loading:  LoginScreenState()
    object Empty:  LoginScreenState()
}