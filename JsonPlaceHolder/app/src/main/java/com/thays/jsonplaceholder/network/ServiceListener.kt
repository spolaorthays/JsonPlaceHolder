package com.thays.jsonplaceholder.network

interface ServiceListener {

    fun onSuccess(`object`: Any?)

    fun onError(throwable: Throwable?)
}