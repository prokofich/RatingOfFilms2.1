package com.example.ratingoffilms.model.api

import android.os.Handler
import android.os.Looper
import com.example.ratingoffilms.model.constant.MY_TOKEN_FOR_SERVER
import com.example.ratingoffilms.model.constant.NAME_HEADER
import com.example.ratingoffilms.model.constant.URL_JSON_FILMS
import com.example.ratingoffilms.model.modelResponse.films.modelFilm
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiServiceFilms(private val view:InterfaceForFilmsFragment) {

    fun loadFilms() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(URL_JSON_FILMS)
            .addHeader(NAME_HEADER, MY_TOKEN_FOR_SERVER)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                val responseFromServer = Gson().fromJson(responseBody, modelFilm::class.java)
                Handler(Looper.getMainLooper()).post {
                    view.setListForAdapter(responseFromServer.docs)
                }
            }
        })
    }

}