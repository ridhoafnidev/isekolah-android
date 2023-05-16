package com.smpsantoyosef.feature.auth.ui.screen

import androidx.lifecycle.viewModelScope
import com.smpsantoyosef.domain.usecase.AuthUseCase
import com.smpsantoyosef.domain.usecase.UserUseCase
import com.smpsantoyosef.domain.utils.Resource
import com.smpsantoyosef.entity.User
import com.smpsantoyosef.feature.auth.BaseViewModel
import com.smpsantoyosef.feature.auth.ui.screen.login.LoginScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val userUseCase: UserUseCase
) : BaseViewModel() {

    private val _loginScreenState = MutableStateFlow<LoginScreenState>(LoginScreenState.Empty)
    val loginScreenState: StateFlow<LoginScreenState> get() = _loginScreenState

    private val _userStoreResponse = MutableStateFlow<Boolean>(false)
    val userStoreResponse: StateFlow<Boolean> get() = _userStoreResponse

    fun login(username: String, password: String) {
        viewModelScope.launch {
            authUseCase.execute(AuthUseCase.Params(username, password)).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _loginScreenState.value = LoginScreenState.Success(result.data)
                    }
                    is Resource.Error -> {
                        _loginScreenState.value = LoginScreenState.Error(result.msg)
                    }
                    else -> Unit
                }
            }
        }
    }

    fun storeUser(user: User) {
        viewModelScope.launch {
            userUseCase.storeUser(user).runFlow(_userStoreResponse)
        }
    }

    fun storeUsername(username: String) {
        viewModelScope.launch {
            userUseCase.storeUsername(username)
        }
    }

    fun storeId(id: Int) {
        viewModelScope.launch {
            userUseCase.storeId(id)
        }
    }

    fun storeToken(token: String) {
        viewModelScope.launch {
            userUseCase.storeToken(token)
        }
    }

}