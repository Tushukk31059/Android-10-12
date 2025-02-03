package com.example.kotlinbasics

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
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

    private lateinit var selectedGender : String
    private val listLanguages : ArrayList<String> = arrayListOf()
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
                val intent = Intent(this,ShowFormAct::class.java)
                intent.putExtra("name",name.text.toString().trim())
                intent.putExtra("workplace",workPlace.text.toString().trim())
                intent.putExtra("mail",eMail.text.toString().trim())
                intent.putExtra("password",password.text.toString().trim())
                intent.putExtra("gender",selectedGender)
                intent.putStringArrayListExtra("listLanguages",listLanguages)

                startActivity(intent)
            } else{
                Toast.makeText(this,"Enter all fields..",Toast.LENGTH_SHORT).show()
            }
        }
        cLanguage.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                Toast.makeText(this,"You Selected : ${cLanguage.text}",Toast.LENGTH_SHORT).show()
                listLanguages.add(cLanguage.text.toString())
            }
            else{
                listLanguages.remove(cLanguage.text.toString())
            }
        }
        cppLanguage.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                Toast.makeText(this,"you Selected: ${cppLanguage.text}",Toast.LENGTH_SHORT).show()
                listLanguages.add(cppLanguage.text.toString())
            } else{
                listLanguages.remove(cppLanguage.text.toString())
            }
        }
        kotlinLanguage.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                Toast.makeText(this,"you Entered: ${kotlinLanguage.text}",Toast.LENGTH_SHORT).show()
                listLanguages.add(kotlinLanguage.text.toString())
            } else{
                listLanguages.remove(kotlinLanguage.text.toString())
            }
        }
        radioGroup.setOnCheckedChangeListener { _, radioBtnId ->
            val radioButton=findViewById<RadioButton>(radioBtnId)
            selectedGender = radioButton.text.toString()
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
        if(eMail.text.toString().trim().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(eMail.text.toString()).matches()){
            eMail.error = "Enter Correct Email"
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