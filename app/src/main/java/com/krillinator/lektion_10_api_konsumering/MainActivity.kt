package com.krillinator.lektion_10_api_konsumering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.krillinator.lektion_10_api_konsumering.api.Fox
import com.krillinator.lektion_10_api_konsumering.api.FoxApi
import com.krillinator.lektion_10_api_konsumering.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

// https://randomfox.ca/floof/

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding Setup
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomfox.ca/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Variables
        val getFox = retrofit.create<FoxApi>().getFox()

        // Make Api CALL
        getFox.enqueue(object : Callback<Fox> {

            override fun onResponse(call: Call<Fox>, response: Response<Fox>) {

                if (response.isSuccessful) {

                    val fox = response.body()
                    if (fox != null) {
                        binding.tvFoxApi.text = fox.img

                        // Display Image
                        Glide.with(view)
                            .load(fox.img)
                            .into(binding.ivFoxImage)
                    }
                }

            }

            override fun onFailure(call: Call<Fox>, t: Throwable) {
                println(t.message)
            }

        })

    }
}
