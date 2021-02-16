package com.google.llc.retrofit

import com.google.llc.dashboard.models.TopHeadLineResponse
import com.google.llc.utils.Constants
import io.reactivex.Single
import retrofit2.http.GET

interface NewsApi {

    @GET("top-headlines?country=us&apiKey=" + Constants.API_KEY)
    fun getNews(): Single<TopHeadLineResponse>
}