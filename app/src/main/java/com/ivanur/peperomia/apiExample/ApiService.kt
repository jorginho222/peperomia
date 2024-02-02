package com.ivanur.peperomia.apiExample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getFamilies(@Url url: String): Response<FamiliesResponse>
}