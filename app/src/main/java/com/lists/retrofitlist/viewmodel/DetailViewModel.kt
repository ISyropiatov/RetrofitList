package com.lists.retrofitlist.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lists.retrofitlist.data.model.RootProject
import com.lists.retrofitlist.data.retrofit.Common
import com.lists.retrofitlist.data.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailViewModel(val context: Context) : ViewModel() {
    private var mService: RetrofitServices = Common.retrofitService
    val projectsLiveData: MutableLiveData<RootProject> = MutableLiveData()
    init {
        mService.getMovieList(
            "600b9ea",
            "batman",

            ).enqueue(object : Callback<RootProject> {
            override fun onFailure(call: Call<RootProject>, t: Throwable) {
                Toast.makeText(context, "Network error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<RootProject>,
                response: Response<RootProject>
            ) {
                projectsLiveData.value=response.body()

            }
        })

    }
}