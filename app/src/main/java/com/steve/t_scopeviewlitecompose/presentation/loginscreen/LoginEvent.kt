package com.steve.t_scopeviewlitecompose.presentation.loginscreen

sealed class LoginEvent {
    data class EnteredUsername(val username: String): LoginEvent()
    data class EnteredPassword(val password: String): LoginEvent()
    object Login: LoginEvent()
}
