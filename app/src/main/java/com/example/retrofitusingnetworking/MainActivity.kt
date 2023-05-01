package com.example.retrofitusingnetworking


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.example.retrofitusingnetworking.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import org.json.JSONException
import org.json.JSONObject
import com.androidnetworking.interfaces.JSONObjectRequestListener as JSONObjectRequestListener


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var imageList = ArrayList<ImageItem>()
    lateinit var requestQueue: RequestQueue


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestQueue = Volley.newRequestQueue(this)
        AndroidNetworking.initialize(applicationContext)

//      initView()

        apiCall()
    }

    private fun apiCall() {
        lifecycleScope.launch(Dispatchers.IO) {
            val apiUrl = "https://appkiduniya.in/wallpaper/Api/User/getwallpaper"
            var jsonObjectRequest = JsonObjectRequest(Request.Method.GET, apiUrl, null, {

                try {
                    val res = it.getJSONArray("Image")
                    for (i in 0 until res.length()) {
                        val obj = res.getJSONObject(i)
                        val walpapper_id = obj.getString("walpapper_id")
                        val name = obj.getString("name")
                        val created_at = obj.getString("created_at")
                        val updated_at = obj.getString("updated_at")

                        val imageItem =
                            ImageItem(updated_at, name, created_at, walpapper_id)
                        imageList.add(imageItem)
                    }

                } catch (e: JSONException) {
                    Log.e("TAG", "catch....Error: " + e.message)
                    e.printStackTrace()
                }

                val adapterImage = ImageAdapter(imageList!!, applicationContext)
                binding.rcvImage.setLayoutManager(LinearLayoutManager(applicationContext))
                binding.rcvImage.adapter = adapterImage

            }, {
                Log.d("API Request Error", "${it.printStackTrace()}")
            })
            requestQueue.add(jsonObjectRequest) // -> Added jsonObjectRequest To requestQueue
        }
    }

    private fun initView() {

        GlobalScope.launch {
            AndroidNetworking.get("https://appkiduniya.in/wallpaper/Api/User/getwallpaper").build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject) {

                        Log.e("TAG", "onResponse:--" + response)

                        for (i in 0 until response.length()) {
                            try {
                                val res = response.getJSONArray("Image")


                                for (i in 0 until res.length()) {
                                    val obj = res.getJSONObject(i)
                                    val walpapper_id = obj.getString("walpapper_id")
                                    val name = obj.getString("name")
                                    val created_at = obj.getString("created_at")
                                    val updated_at = obj.getString("updated_at")

                                    val imageItem =
                                        ImageItem(updated_at, name, created_at, walpapper_id)
                                    imageList.add(imageItem)
                                }

                            } catch (e: JSONException) {
                                Log.e("TAG", "catch....Error: " + e.message)
                                e.printStackTrace()
                            }
                        }

                        val adapterImage = ImageAdapter(imageList!!, applicationContext)
                        binding.rcvImage.setLayoutManager(LinearLayoutManager(applicationContext))
                        binding.rcvImage.adapter = adapterImage

                    }

                    override fun onError(anError: ANError?) {

                        Log.e("TAG", "onError: " + anError)

                    }
                })
        }
    }
}