package com.mrfreitas.weather_app.ui.main.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel() : ViewModel() {

    protected var compositeDisposable: CompositeDisposable? = CompositeDisposable()


    fun clearSubscriptions() {
        compositeDisposable!!.clear()
    }

    override fun onCleared() {
        super.onCleared()
        clearSubscriptions()
    }
}