package com.slim.makanan

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.slim.makanan.model.FoodModel
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_food.setHasFixedSize(true)
        getFoodImage()
    }

    private fun getFoodImage(): ArrayList<FoodModel> {
        progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = "https://dicky16.github.io/test-api/food.json"
        val listFood = ArrayList<FoodModel>()
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                progressBar.visibility = View.INVISIBLE
                val result = String(responseBody)
                try {
                    val jsonObject = JSONObject(result)
                    val jsonArray = jsonObject.getJSONArray("result")
                    val length = jsonArray.length() - 1
                    Log.d("jumlah", length.toString())
                    for (i in 0 until jsonArray.length() ) {
                        val jsonObj = jsonArray.getJSONObject(i)
                        val food = FoodModel(
                            jsonObj.getString("id"),
                            jsonObj.getString("nama"),
                            jsonObj.getString("gambar")
                        )
                        listFood.add(food)
                        showRecyclerFood(listFood)
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                    Log.d("error", e.message)
                    e.printStackTrace()
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {

            }
        })
        return listFood
    }
    private fun showRecyclerFood(list: ArrayList<FoodModel>) {
        rv_food.layoutManager = LinearLayoutManager(this)
        val foodAdapter = FoodAdapter(list)
        rv_food.adapter = foodAdapter
    }
}
