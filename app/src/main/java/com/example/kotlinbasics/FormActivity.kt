package com.example.kotlinbasics

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etName = findViewById<EditText>(R.id.name)
        val etWorkPlace = findViewById<EditText>(R.id.workPlace)
        val etMail = findViewById<EditText>(R.id.eMail)
        val etPassword = findViewById<EditText>(R.id.password)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val checkBoxC = findViewById<CheckBox>(R.id.cLanguage)
        val checkBoxCpp = findViewById<CheckBox>(R.id.cppLanguage)
        val checkBoxKotlin = findViewById<CheckBox>(R.id.kotlinLanguage)
        checkBoxC.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                Toast.makeText(this,"Selected : ${checkBoxC.text}",Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this,"Unselected : ${checkBoxC.text}",Toast.LENGTH_SHORT).show()
            }
        }
        checkBoxCpp.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                Toast.makeText(this,"Selected : ${checkBoxCpp.text}",Toast.LENGTH_SHORT).show()
            }
        }
        checkBoxKotlin.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                Toast.makeText(this,"Selected : ${checkBoxKotlin.text}",Toast.LENGTH_SHORT).show()
            }
        }
        radioGroup.setOnCheckedChangeListener { _, radioBtnId ->
            val radioBtn = findViewById<RadioButton>(radioBtnId)
            Toast.makeText(this,"Selected: ${radioBtn.text}",Toast.LENGTH_SHORT).show()
        }
        btnLogin.setOnClickListener {
            if (validateDetails(etName, etWorkPlace, etMail, etPassword, radioGroup)) {
                val name = etName.text.toString().trim()
                val workplace = etWorkPlace.text.toString().trim()
                val mail = etMail.text.toString().trim()
                val password = etPassword.text.toString().trim()
                val radioBtn = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
                val gender = radioBtn.text.toString()
                println("eddr $name $workplace $mail $password $gender")
            } else {
                Toast.makeText(this, "Enter the Values", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateDetails(
        etName: EditText,
        etWorkPlace: EditText,
        etMail: EditText,
        etPassword: EditText,
        radioGroup: RadioGroup
    ): Boolean {
        var isValid = true
        val name = etName.text.toString().trim()
        if (name.isEmpty()) {
            isValid = false
            etName.error = "Enter Your Name"
        }
        val workplace = etWorkPlace.text.toString().trim()
        if (workplace.isEmpty()) {
            isValid = false
            etWorkPlace.error = "Enter Your Workplace"
        }
        val mail = etMail.text.toString().trim()
        if (mail.isEmpty()) {
            isValid = false
            etMail.error = "Enter Your Mail"
        }
        val password = etPassword.text.toString().trim()
        if (password.isEmpty()) {
            isValid = false
            etPassword.error = "Enter your Password"
        }
        if (radioGroup.checkedRadioButtonId == -1) {
            isValid = false
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show()
        }
        return isValid
    }
}