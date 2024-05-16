package com.minderanews

import android.app.Application
import com.minderanews.di.dataModule
import com.minderanews.di.networkModule
import com.minderanews.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    dataModule
                )
            )
        }
    }
}