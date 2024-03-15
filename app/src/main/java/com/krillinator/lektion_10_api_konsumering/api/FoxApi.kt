package com.krillinator.lektion_10_api_konsumering.api

import retrofit2.Call
import retrofit2.http.GET

interface FoxApi {

    @GET("/floof")
    fun getFox(): Call<Fox>

    /** TODO What is a CALL?
     *      Works with Requests & Responses
     *      Returns a 'response'
     *      response == Data + Status Code
     */


}
