package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if the user is logged in
        if (isUserLoggedIn()) {
            // User is logged in, navigate to CRUD activity
            startActivity(Intent(this, CrudActivity::class.java))
            finish()
        } else {
            // User is not logged in, navigate to Login activity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    // This method should be replaced with actual login state checking logic
    private fun isUserLoggedIn(): Boolean {
        // Placeholder: Replace with real logic to check if the user is logged in
        return false
    }
}
