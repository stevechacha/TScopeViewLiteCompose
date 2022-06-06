package com.steve.t_scopeviewlitecompose.data.remote

import com.steve.t_scopeviewlitecompose.data.response.KeyCloakResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

interface KeyCloakApi {

    @POST("token")
    @FormUrlEncoded
    suspend fun grantNewAccessToken(
        @Field("code") code: String,
        @Field("client_id") clientId: String,
        @Field("redirect_uri") uri: String,
        @Field("grant_type") grantType: String = "authorization_code"
    ): Response<KeyCloakResponse>

    @POST("token")
    @FormUrlEncoded
    suspend fun refreshAccessToken(
        @Field("refresh_token") refreshToken: String,
        @Field("client_id")     clientId: String,
        @Field("grant_type")    grantType: String = "refresh_token"
    ): Response<KeyCloakResponse>

    @POST("logout")
    @FormUrlEncoded
    suspend fun logout(
        @Field("client_id")     clientId: String,
        @Field("refresh_token") refreshToken: String
    ): Response<KeyCloakResponse>


}