package com.slim.intentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSubmit.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("nama", edtNama.text.toString())
            intent.putExtra("alamat", edtAlamat.text.toString())
            intent.putExtra("no_tlp", edtNo.text.toString())
            startActivity(intent)
        }
    }
}
