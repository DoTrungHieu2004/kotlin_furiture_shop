package com.hieudt.kotlinfunitureshop

import android.annotation.SuppressLint
import android.app.Application
import com.hieudt.kotlinfunitureshop.utils.TokenStorage

class AppApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var tokenStorage: TokenStorage
            private set
    }

    override fun onCreate() {
        super.onCreate()
        tokenStorage = TokenStorage(this)
    }
}