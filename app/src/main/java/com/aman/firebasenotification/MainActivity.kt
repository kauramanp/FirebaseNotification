package com.aman.firebasenotification

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Headers

class MainActivity : AppCompatActivity() {
    lateinit var btn :Button
    lateinit var retrofitClass: RetrofitClass
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        retrofitClass = RetrofitClass()
        sharedPreferences = this.getSharedPreferences(resources.getString(R.string.app_name), MODE_PRIVATE)
        editor = sharedPreferences.edit()

        btn.setOnClickListener {
            val token = sharedPreferences.getString("token", "")
            var firebaseDataClass = firebaseDataClass()
            firebaseDataClass.to = token
            var firebaseDataDataClass = firebaseDataDataClass()
            firebaseDataDataClass.message = "Message "
            firebaseDataDataClass.title = "Title "
            firebaseDataClass.data  = firebaseDataDataClass
            val headerMap =  HashMap<String, String>()
            headerMap["Content-Type"]  = "application/json"
            headerMap["project_id"]  = "project id"
            headerMap["Authorization"]  = "Your project firebase server key"

            retrofitClass.service.updateUser(headerMap, firebaseDataClass).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.e(TAG," response $response")
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.e(TAG,"t ${t.localizedMessage}")
                }
            })
        }
    }
}