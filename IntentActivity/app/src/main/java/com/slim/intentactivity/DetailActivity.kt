package com.slim.intentactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tvNama.text = intent.getStringExtra("nama")
        tvAlamat.text = intent.getStringExtra("alamat")
        tvNo.text = intent.getStringExtra("no_tlp")
    }
}
