package com.hieudt.kotlinfunitureshop.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "app_prefs"
)

object DataStoreProvider {
    fun get(context: Context): DataStore<Preferences> {
        return context.dataStore
    }
}