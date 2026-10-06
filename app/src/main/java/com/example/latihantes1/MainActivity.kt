package com.example.latihantes1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var email = findViewById<LinearLayout>(R.id.Email)
        email.setOnClickListener {
            val _sendIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:sarah@school.edu")
                putExtra(Intent.EXTRA_SUBJECT, "Pesan dari Aplikasi Profile")
            }

            startActivity(Intent.createChooser(_sendIntent, "PILIH APLIKASI"))
        }

        var phone = findViewById<LinearLayout>(R.id.Phone)
        phone.setOnClickListener {
            val _callIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+1 (555) 987-6547")
            }

            startActivity(_callIntent)
        }

        var role = findViewById<LinearLayout>(R.id.Role)
        role.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                MainActivity2::class.java
            )
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()

        val roleValue = findViewById<TextView>(R.id.RoleValue)
        roleValue.text = DataProfile.role
    }
}