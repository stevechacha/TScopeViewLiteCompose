package com.steve.t_scopeviewlitecompose.domain.repositories

import com.steve.t_scopeviewlitecompose.data.response.AccessToken
import com.steve.t_scopeviewlitecompose.util.Resource

interface KeyCloakRepository {
    suspend fun getAccessToken(username: String, password: String): Resource<AccessToken>
}