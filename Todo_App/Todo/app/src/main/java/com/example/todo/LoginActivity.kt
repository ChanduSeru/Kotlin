package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            login(username, password)
        }
    }

    private fun login(username: String, password: String) {
        // Make a network request to authenticate the user
        Thread {
            try {
                val url = URL("http://10.0.2.2:3000/login") // Update URL to match your backend
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                val postData = "username=$username&password=$password"
                connection.outputStream.write(postData.toByteArray())

                val response = connection.inputStream.bufferedReader().use { it.readText() }
                val jsonResponse = JSONObject(response)
                val success = jsonResponse.getBoolean("success")

                runOnUiThread {
                    if (success) {
                        // Save login state
                        val sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
                        sharedPreferences.edit().putBoolean("is_logged_in", true).apply()

                        // Navigate to CRUD activity
                        startActivity(Intent(this, CrudActivity::class.java))
                        finish()
                    } else {

                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}
