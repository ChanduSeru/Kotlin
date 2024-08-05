package com.example.smarthome

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var lightSwitch: CompoundButton
    private lateinit var thermostatSeekBar: SeekBar
    private lateinit var thermostatValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lightSwitch = findViewById(R.id.light_switch)
        thermostatSeekBar = findViewById(R.id.thermostat_seekbar)
        thermostatValue = findViewById(R.id.thermostat_value)

        lightSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle light control
            if (isChecked) {
                // Turn on
            } else {
                // Turn off
            }
        }


        thermostatSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                thermostatValue.text = "${progress + 10}°C" // Assuming 10°C is the minimum temperature
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
              
            }
        })
    }
}