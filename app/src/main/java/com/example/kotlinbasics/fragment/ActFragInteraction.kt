package com.example.kotlinbasics.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.R
import com.example.kotlinbasics.databinding.FragmentInteractBinding

class ActFragInteraction : AppCompatActivity() {
    private lateinit var actFragmentInteractBinding: FragmentInteractBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actFragmentInteractBinding=FragmentInteractBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(actFragmentInteractBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}