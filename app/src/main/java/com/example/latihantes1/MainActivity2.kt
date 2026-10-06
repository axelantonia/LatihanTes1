package com.example.latihantes1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val admin = findViewById<Button>(R.id.admin)
        admin.setOnClickListener {
            DataProfile.role = "Admin"
            finish()
        }

        val user = findViewById<Button>(R.id.User)
        user.setOnClickListener {
            DataProfile.role = "User"
            finish()
        }

        val guest = findViewById<Button>(R.id.Guest)
        guest.setOnClickListener {
            DataProfile.role = "Guest"
            finish()
        }
    }
}