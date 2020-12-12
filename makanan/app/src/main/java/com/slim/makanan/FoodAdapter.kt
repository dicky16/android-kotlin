package com.slim.makanan

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.slim.makanan.model.FoodModel
import kotlinx.android.synthetic.main.item_food.view.*

class FoodAdapter(private val listFood: ArrayList<FoodModel>) : RecyclerView.Adapter<FoodAdapter.ListViewHolder>(){

        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_food, viewGroup, false)
            return ListViewHolder(view)
        }

        override fun getItemCount(): Int = listFood.size

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            holder.bind(listFood[position])
        }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(foodModel: FoodModel) {
            with(itemView){
                Glide.with(itemView.context)
                    .load("https://raw.githubusercontent.com/dicky16/test-api/master/food/" + foodModel.gambar)
                    .apply(RequestOptions().override(100, 100))
                    .into(img_item_photo)
                tv_nama.text = foodModel.nama
                itemView.setOnClickListener {
                    Log.e("tag", "kepenek = ${foodModel.nama}")
                    Toast.makeText(itemView.context, "Kamu memilih ${foodModel.nama}", Toast.LENGTH_SHORT).show() }
            }
        }
    }

}