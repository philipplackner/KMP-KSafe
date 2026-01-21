package com.plcoding.ksafe.androidapp

import android.app.Application
import com.plcoding.kmp_ksafe.AppModule

class KSafeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AppModule.init(this)
    }
}