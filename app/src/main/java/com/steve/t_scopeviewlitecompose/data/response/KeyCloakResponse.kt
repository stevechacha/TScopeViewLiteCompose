package com.steve.t_scopeviewlitecompose.data.response

import com.google.gson.annotations.SerializedName
import java.util.*


data class KeyCloakResponse(
    @SerializedName("acces_token")
    var accessToken: String?=null,
    @SerializedName("expires_in")
    var expireIn: Int ?=null,
    @SerializedName("refresh_expires_in")
    val refreshExpiresIn: Int?=null,
    @SerializedName("refresh_token")
    val refreshToken: String? = null,
    @SerializedName("token_type")
    var tokenType: String? = null,
    @SerializedName("id_token")
    var idToken: String? = null,
    @SerializedName("not-before-policy")
    var notBeforePolicy: Int? = null,
    @SerializedName("session_state")
    var sessionState: String ? = null,
    @SerializedName("token_expiration_date")
    var tokenExpirationDate: Calendar?= null,
    @SerializedName("refresh_expiration_date")
    var refreshTokenExpirationDate: Calendar? = null

)
