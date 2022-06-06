package com.steve.t_scopeviewlitecompose.data.repositories

import com.steve.t_scopeviewlitecompose.data.remote.KeyCloakApi
import com.steve.t_scopeviewlitecompose.data.response.KeyCloakResponse
import com.steve.t_scopeviewlitecompose.domain.repositories.KeyCloakRepository
import com.steve.t_scopeviewlitecompose.util.Constants
import com.steve.t_scopeviewlitecompose.util.Resource
import javax.inject.Inject


class KeyCloakRepositoryImpl(private val api: KeyCloakApi) :
    KeyCloakRepository {
    override suspend fun getAccessToken(username: String, password: String): Resource<KeyCloakResponse> {
        return try {
            val response = api.getAccessToken(
                clientId = Constants.clientId, //"Login",
                grantType = "password",
                clientSecret =  "PASTE YOUR CLIENTS SECRET",
                scope = "openid",
                username = username,
                password = password
            )

            Resource.Success(response)
        } catch (e: Exception) {
            return Resource.Error("An Error occurred, please try again!")
        }
    }
}