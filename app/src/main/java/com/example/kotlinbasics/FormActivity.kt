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
        val name=findViewById<EditText>(R.id.name)
        val workPlace=findViewById<EditText>(R.id.workPlace)
        val eMail=findViewById<EditText>(R.id.eMail)
        val password=findViewById<EditText>(R.id.password)
        val radioGroup=findViewById<RadioGroup>(R.id.radioGroup)
        val btnNext=findViewById<Button>(R.id.btnNext)
        val cLanguage=findViewById<CheckBox>(R.id.cLanguage)
        val cppLanguage=findViewById<CheckBox>(R.id.cppLanguage)
        val kotlinLanguage=findViewById<CheckBox>(R.id.kotlinLanguage)

        btnNext.setOnClickListener {
            if (detailsValidate(name,workPlace,eMail,password,radioGroup,cLanguage,cppLanguage,kotlinLanguage)){
                println("Wow..")
            } else{
                Toast.makeText(this,"Enter all fields..",Toast.LENGTH_SHORT).show()
            }
        }
        cLanguage.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                Toast.makeText(this,"${cLanguage.text} box checked",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"${cLanguage.text} box unchecked",Toast.LENGTH_SHORT).show()
            }
        }
        radioGroup.setOnCheckedChangeListener { _, radioBtnId ->
            val radioButton=findViewById<RadioButton>(radioBtnId)
            Toast.makeText(this,"${radioButton.text} is selected",Toast.LENGTH_SHORT).show()
        }
    }

    private fun detailsValidate(name: EditText, workPlace: EditText, eMail: EditText, password: EditText, radioGroup: RadioGroup,
        cLanguage: CheckBox, cppLanguage: CheckBox, kotlinLanguage: CheckBox): Boolean {
        var value = true
        if(name.text.toString().trim().isEmpty()){
            name.error = "Enter name"
            value = false
        }
        if(workPlace.text.toString().trim().isEmpty()){
            workPlace.error = "Enter Workplace"
            value = false
        }
        if(eMail.text.toString().trim().isEmpty()){
            eMail.error = "Enter Email"
            value = false
        }
        if(password.text.toString().trim().isEmpty()){
            password.error = "Enter Password"
            value = false
        }
        if (radioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show()
            value = false
        }
        if (!cLanguage.isChecked && !cppLanguage.isChecked && !kotlinLanguage.isChecked) {
            Toast.makeText(this, "Please select any Option", Toast.LENGTH_SHORT).show()
            value = false
        }
        return value
    }


}