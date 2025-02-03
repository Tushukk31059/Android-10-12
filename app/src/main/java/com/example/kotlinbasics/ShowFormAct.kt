package com.example.kotlinbasics

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.databinding.ActivityShowFormBinding
import java.util.ArrayList

class ShowFormAct : AppCompatActivity() {
    private lateinit var binding : ActivityShowFormBinding
    private var name : String? = null
    private var workplace: String?=null
    private var mail:String?=null
    private var password :String?=null
    private var gender : String? = null
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

        binding.male.isClickable = false
        binding.female.isClickable = false

        binding.cLanguage.isClickable = false
        binding.cppLanguage.isClickable = false
        binding.kotlinLanguage.isClickable = false

        val listLanguages = intent.getStringArrayListExtra("listLanguages")
        gender = intent.getStringExtra("gender")
        checkChild(binding.radioGroup)
        childCheck(binding.checkboxLayout,listLanguages!!)

    }
    private fun checkChild(parent:ViewGroup){
        for (i in 0..parent.childCount){
            val child=parent.getChildAt(i)
            if (child is RadioButton && child.text.toString() == gender){
                child.isChecked =true
            }else if (child is ViewGroup){
                checkChild(child)
            }
        }
    }

    private fun childCheck(parent: ViewGroup, list: ArrayList<String>){
        for (i in 0..parent.childCount){
            val child= parent.getChildAt(i)
            if(child is CheckBox && child.text.toString() in list){
                child.isChecked=true
            }else if(child is ViewGroup){
                childCheck(child,list)
            }
        }

    }

}