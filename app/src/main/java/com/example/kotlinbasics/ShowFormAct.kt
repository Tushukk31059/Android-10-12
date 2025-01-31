package com.example.kotlinbasics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.databinding.ActivityShowFormBinding

class ShowFormAct : AppCompatActivity() {
    private lateinit var binding : ActivityShowFormBinding
    private var name : String? = null
    private var workplace: String?=null
    private var mail:String?=null
    private var password :String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityShowFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name = intent.getStringExtra("name")
        binding.etName.setText(name)
        workplace=intent.getStringExtra("workplace")
        binding.etWorkPlace.setText(workplace)
        mail=intent.getStringExtra("mail")
        binding.etMail.setText(mail)
        password=intent.getStringExtra("password")
        binding.etPassword.setText(password)
    }
}