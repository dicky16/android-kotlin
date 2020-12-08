package com.slim.tugas7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var editText_id: EditText
    lateinit var editText_nama: EditText
    lateinit var editText_alamat: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        editText_id = findViewById(R.id.editText_ID)
        editText_nama = findViewById(R.id.editText_nama)
        editText_alamat =findViewById(R.id.editText_alamat)

        textView_hasil.setText("welcome")
    }

    fun button_read(view: View) {
        GlobalScope.async {
            var id: String = editText_id.text.toString()

            var alamat = "http://192.168.43.214/android/getID.php?id=$id"
            var hasil: String = getJsonFromURL(alamat).toString()
            textView_hasil.setText(hasil)
        }
    }

    fun button_insert(view: View) {
        var nama:String = editText_nama.text.toString()
        var alamat:String =editText_alamat.text.toString()
        nama = nama.replace(" ", "%20")
        alamat = alamat.replace(" ", "%20")

        GlobalScope.launch {
            URL("http://192.168.43.214/android/insert.php?nama="+nama+"&alamat="+alamat).openStream()
        }

    }

    fun button_update(view: View) {
        // isi update untuk tugas
        var nama:String = editText_nama.text.toString()
        var alamat:String =editText_alamat.text.toString()
        var id:String =editText_id.text.toString()
        nama = nama.replace(" ", "%20")
        alamat = alamat.replace(" ", "%20")

        GlobalScope.launch {
            URL("http://192.168.43.214/android/update.php?nama="+nama+"&alamat="+alamat+"&id="+id).openStream()
        }
        GlobalScope.async {
            var id: String = editText_id.text.toString()

            var alamat = "http://192.168.43.214/android/getID.php?id=$id"
            var hasil: String = getJsonFromURL(alamat).toString()
            textView_hasil.setText(hasil)
        }
    }
    fun button_delete(view: View) {
        var id:String = editText_id.text.toString()
        GlobalScope.launch {
            URL("http://192.168.43.214/android/delete.php?id=$id").openStream()
        }
    }

    fun getJsonFromURL(wantedURL: String) : String {
        return URL(wantedURL).readText()
    }
}
