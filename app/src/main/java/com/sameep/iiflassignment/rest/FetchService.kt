package com.example.shaadiassignment.rest

import com.sameep.iiflassignment.rest.response.Response
import com.sameep.iiflassignment.rest.response.ResponseItem
import retrofit2.http.GET

interface FetchService {

    @GET("wp-json/wp/v2/posts")
    suspend fun getArticles() : List<ResponseItem>

}