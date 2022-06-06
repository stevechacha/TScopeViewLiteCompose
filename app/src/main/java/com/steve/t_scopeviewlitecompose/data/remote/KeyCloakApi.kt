package com.steve.t_scopeviewlitecompose.data.remote

import com.steve.t_scopeviewlitecompose.data.response.KeyCloakResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

interface KeyCloakApi {

    @POST("auth/realms/demo/protocol/openid-connect/token")
    @FormUrlEncoded
    suspend fun getAccessToken(
        @Field("client_id") clientId: String,
        @Field("grant_type") grantType: String= "authorization_code",
        @Field("client_secret") clientSecret: String,
        @Field("scope") scope: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): KeyCloakResponse

    @POST("token")
    @FormUrlEncoded
    suspend fun refreshAccessToken(
        @Field("refresh_token") refreshToken: String,
        @Field("client_id")     clientId: String,
        @Field("grant_type")    grantType: String = "refresh_token"
    ): KeyCloakResponse

    @POST("logout")
    @FormUrlEncoded
    suspend fun logout(
        @Field("client_id")     clientId: String,
        @Field("refresh_token") refreshToken: String
    ): KeyCloakResponse


}