package com.steve.t_scopeviewlitecompose.data.response

import java.util.*


data class KeyCloakResponse(
    var accessToken: String?=null,
    var expireIn: Int ?=null,
    val refreshExpiresIn: Int?=null,
    val refreshToken: String? = null,
    var tokenType: String? = null,
    var idToken: String? = null,
    var notBeforePolicy: Int? = null,
    var sessionState: String ? = null,
    var tokenExpirationDate: Calendar?= null,
    var refreshTokenExpirationDate: Calendar? = null

)
