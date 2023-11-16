package com.lists.retrofitlist

import android.app.Application
import com.lists.retrofitlist.viewmodel.DetailViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RetroApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RetroApp)
            androidLogger()
            modules(myModule)
        }

    }

    private val myModule = module {
        viewModel { DetailViewModel(get()) }
    }

}