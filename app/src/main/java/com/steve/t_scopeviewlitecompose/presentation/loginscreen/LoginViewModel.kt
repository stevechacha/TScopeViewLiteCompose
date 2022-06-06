package com.steve.t_scopeviewlitecompose.presentation.loginscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steve.t_scopeviewlitecompose.domain.repositories.KeyCloakRepository
import com.steve.t_scopeviewlitecompose.domain.state.PasswordTextFieldState
import com.steve.t_scopeviewlitecompose.domain.state.StandardTextFieldState
import com.steve.t_scopeviewlitecompose.util.Resource
import com.steve.t_scopeviewlitecompose.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: KeyCloakRepository
) : ViewModel() {

    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> = _loginState

    private val _userNameState = mutableStateOf(StandardTextFieldState())
    val userNameState: State<StandardTextFieldState> = _userNameState

    private val _passwordState = mutableStateOf(PasswordTextFieldState())
    val passwordState: State<PasswordTextFieldState> = _passwordState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EnteredUsername -> {
                _userNameState.value = userNameState.value.copy(
                    text = event.username
                )
            }
            is LoginEvent.EnteredPassword -> {
                _passwordState.value = passwordState.value.copy(
                    text = event.password
                )
            }
            is LoginEvent.Login -> {
                viewModelScope.launch {
                    _loginState.value = loginState.value.copy(
                        isLoading = true
                    )

                    if (userNameState.value.text.isBlank()) {
                        _userNameState.value = userNameState.value.copy(
                            error = "Field empty"
                        )
                        return@launch
                    }

                    if (passwordState.value.text.isBlank()) {
                        _passwordState.value = passwordState.value.copy(
                            error = "Field empty"
                        )
                        return@launch
                    }
                    val loginResult = repository.getAccessToken(
                        username = userNameState.value.text,
                        password = passwordState.value.text
                    )
                    _loginState.value = loginState.value.copy(
                        isLoading = false
                    )


                    when (loginResult) {
                        is Resource.Success -> {
                            _eventFlow.emit(
                                //UiEvent.Navigate("home"),
                                UiEvent.SnackbarEvent("Logged in Successfully")
                            )
                        }
                        is Resource.Error -> {
                            _eventFlow.emit(
                                UiEvent.SnackbarEvent(
                                    loginResult.message ?: "Unknown error occurred"
                                )
                            )
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}