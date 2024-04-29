package com.example.ratingoffilms.model.api

import android.os.Handler
import android.os.Looper
import com.example.ratingoffilms.model.constant.MY_TOKEN_FOR_SERVER
import com.example.ratingoffilms.model.constant.NAME_HEADER
import com.example.ratingoffilms.model.constant.URL_JSON_DETAIL_FILMS
import com.example.ratingoffilms.model.modelresponse.detailfilm.modelDetailFilm
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiServiceDetailFilm(private val view:InterfaceForDetailFilmFragment) {

    fun loadFilm(idMovie : String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(URL_JSON_DETAIL_FILMS+idMovie)
            .addHeader(NAME_HEADER, MY_TOKEN_FOR_SERVER)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                val responseFromServer = Gson().fromJson(responseBody, modelDetailFilm::class.java)
                Handler(Looper.getMainLooper()).post {
                    view.sendParameters(responseFromServer.docs)
                }
            }
        })
    }

}