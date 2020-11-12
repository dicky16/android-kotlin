package com.example.tugas4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var nilai = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_reset.setOnClickListener {
            tv_count.text = "0"
            val tv = TextView(this)
            tv.text = nilai.toString()
            tv.textSize = 30F
            layout.addView(tv)
            nilai = 0
        }

        btn_tambah.setOnClickListener {
            ++nilai
            tv_count.text = nilai.toString()
        }
        btn_kurang.setOnClickListener {
            --nilai
            tv_count.text = nilai.toString()
        }
    }
}
