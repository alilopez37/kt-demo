package com.alilopez.demo.core.network

import com.alilopez.demo.features.jsonplaceholder.data.datasources.remote.models.PostsDto
import retrofit2.http.GET

interface JsonPlaceHolderApi {
    @GET("posts")
    suspend fun getPosts(): List<PostsDto>
}