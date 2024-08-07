package com.example.todo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class CrudActivity : AppCompatActivity() {

    private val baseUrl = "http://10.0.2.2:3000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val cityEditText = findViewById<EditText>(R.id.cityEditText)
        val idEditText = findViewById<EditText>(R.id.idEditText)

        val addButton = findViewById<Button>(R.id.addButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        val updateButton = findViewById<Button>(R.id.updateButton)
        val readButton = findViewById<Button>(R.id.readButton)
        val documentsTextView = findViewById<TextView>(R.id.documentsTextView)

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toInt()
            val city = cityEditText.text.toString()
            addDocument(name, age, city)
        }

        deleteButton.setOnClickListener {
            val id = idEditText.text.toString()
            deleteDocument(id)
        }

        updateButton.setOnClickListener {
            val id = idEditText.text.toString()
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toInt()
            val city = cityEditText.text.toString()
            updateDocument(id, name, age, city)
        }

        readButton.setOnClickListener {
            readDocuments(documentsTextView)
        }
    }

    private fun addDocument(name: String, age: Int, city: String) {
        Thread {
            try {
                val url = URL("$baseUrl/add")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                val postData = "name=$name&age=$age&city=$city"
                connection.outputStream.write(postData.toByteArray())

                val response = connection.inputStream.bufferedReader().use { it.readText() }
                // Handle response if needed
            } catch (e: Exception) {
                e.printStackTrace()

            }
        }.start()
    }

    private fun deleteDocument(id: String) {
        Thread {
            try {
                val url = URL("$baseUrl/delete?id=$id")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "DELETE"

                val response = connection.inputStream.bufferedReader().use { it.readText() }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun updateDocument(id: String, name: String, age: Int, city: String) {
        Thread {
            try {
                val url = URL("$baseUrl/update")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "PUT"
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                val postData = "id=$id&name=$name&age=$age&city=$city"
                connection.outputStream.write(postData.toByteArray())

                val response = connection.inputStream.bufferedReader().use { it.readText() }

            } catch (e: Exception) {
                e.printStackTrace()

            }
        }.start()
    }

    private fun readDocuments(documentsTextView: TextView) {
        Thread {
            try {
                val url = URL("$baseUrl/read")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"

                val response = connection.inputStream.bufferedReader().use { it.readText() }
                val jsonArray = JSONArray(response)
                runOnUiThread {
                    val documents = StringBuilder()
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val name = jsonObject.getString("name")
                        val age = jsonObject.getInt("age")
                        val city = jsonObject.getString("city")
                        documents.append("Name: $name, Age: $age, City: $city\n")
                    }
                    documentsTextView.text = documents.toString()
                }
            } catch (e: Exception) {
                e.printStackTrace()

            }
        }.start()
    }
}
