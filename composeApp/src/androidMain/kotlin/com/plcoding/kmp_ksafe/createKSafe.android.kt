package com.plcoding.kmp_ksafe

import android.content.Context
import eu.anifantakis.lib.ksafe.KSafe

object AppModule {
    private var applicationContext: Context? = null

    val ksafe by lazy {
        KSafe(applicationContext
            ?: throw IllegalStateException("AppModule wasn't initialized."))
    }

    fun init(appContext: Context) {
        applicationContext = appContext.applicationContext
    }
}

actual fun createKSafe(): KSafe = AppModule.ksafe