package com.example.kotlinbasics

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.databinding.ActivityImplicitIntentsBinding

class ImplicitIntentsAct : AppCompatActivity() {
    private lateinit var binding : ActivityImplicitIntentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityImplicitIntentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.webPageBtn.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW)
            val link = "https://google.com"
            browserIntent.data = Uri.parse(link)
            startActivity(browserIntent)
        }

        binding.txtShareBtn.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,"Hello Wow..")
//            startActivity(Intent.createChooser(shareIntent,""))
            startActivity(shareIntent)


        }
        binding.emailIntentBtn.setOnClickListener {
            val emailIntent=Intent().apply {
                action = Intent.ACTION_SENDTO
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("abc@gmail.com","abc2@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT,"Using Email Intent..")
                putExtra(Intent.EXTRA_TEXT,"Email Body..")
            }
            startActivity(emailIntent)
        }

        binding.smsIntentBtn.setOnClickListener {
            val smsIntent=Intent().apply {
                action=Intent.ACTION_SENDTO
                data= Uri.parse("smsto:${1234567890};${62565625622}")
                putExtra(Intent.EXTRA_TEXT,"hello...")
            }
            startActivity(smsIntent)
        }
    }
}