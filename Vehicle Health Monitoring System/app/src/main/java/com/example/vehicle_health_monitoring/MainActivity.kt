package com.example.vehicle_health_monitoring

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var engineHealthTextView: TextView
    private lateinit var oilLevelTextView: TextView
    private lateinit var tirePressureTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        engineHealthTextView = findViewById(R.id.engineHealthTextView)
        oilLevelTextView = findViewById(R.id.oilLevelTextView)
        tirePressureTextView = findViewById(R.id.tirePressureTextView)

        // Update data periodically
        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                updateVehicleData()
                delay(5000)
            }
        }
    }

    private suspend fun updateVehicleData() {
        // Simulate fetching data
        val engineHealth = fetchEngineHealth()
        val oilLevel = fetchOilLevel()
        val tirePressure = fetchTirePressure()

        engineHealthTextView.text = "Engine Health: $engineHealth"
        oilLevelTextView.text = "Oil Level: $oilLevel"
        tirePressureTextView.text = "Tire Pressure: $tirePressure"
    }

    private suspend fun fetchEngineHealth(): String {

        return "Good"
    }

    private suspend fun fetchOilLevel(): String {

        return "49%"
    }

    private suspend fun fetchTirePressure(): String {

        return "40 PSI"
    }
}
