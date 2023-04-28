package com.example.testovoe6

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "aaa05ea2-0037-4b92-8083-d4f1712cfa0c"

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}