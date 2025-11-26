package com.hieudt.kotlinfunitureshop.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class TokenStorage(private val context: Context) {
    private val Context.dataStore by preferencesDataStore("app_prefs")

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("token")
    }

    suspend fun saveToken(token: String) {
        context.dataStore.edit { it[TOKEN_KEY] = token }
    }

    suspend fun getToken(): String? {
        val prefs = context.dataStore.data.first()
        return prefs[TOKEN_KEY]
    }

    suspend fun clear() {
        context.dataStore.edit { it.remove(TOKEN_KEY) }
    }
}