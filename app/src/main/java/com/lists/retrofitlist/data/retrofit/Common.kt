package com.lists.retrofitlist.data.retrofit
object Common {
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient().create(RetrofitServices::class.java)
}