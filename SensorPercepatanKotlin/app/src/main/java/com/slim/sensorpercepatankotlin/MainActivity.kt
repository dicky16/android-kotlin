package com.slim.sensorpercepatankotlin

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

private var sensorManger:SensorManager? = null

class MainActivity : AppCompatActivity(), SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManger = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    @SuppressLint("SetTextI18n")
    override fun onSensorChanged(event: SensorEvent?) {
        if(event!!.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            tv_x.text = "Sumbu X : "+ event?.values?.get(0).toString()
            tv_y.text = "Sumbu X : "+event?.values?.get(1).toString()
            tv_z.text = "Sumbu X : "+ event?.values?.get(2).toString()
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManger!!.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()
        sensorManger!!.registerListener(this, sensorManger!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
    }
}