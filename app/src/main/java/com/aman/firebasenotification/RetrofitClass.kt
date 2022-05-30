package com.aman.firebasenotification

import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class RetrofitClass {
    val header = HashMap<String, String>()

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://fcm.googleapis.com/fcm/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: ApiService = retrofit.create(ApiService::class.java)

  public  interface ApiService {
        @POST("send")
        fun updateUser( @HeaderMap  headers:Map<String, String>, @Body jsonObject: firebaseDataClass): Call<String>
    }
}