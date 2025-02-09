package com.example.kotlinbasics.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.R
import com.example.kotlinbasics.databinding.ActivityActFragInteractionBinding
import com.example.kotlinbasics.databinding.FragmentInteractBinding

class ActFragInteraction : AppCompatActivity() {
    private lateinit var actFragInteractionBinding: ActivityActFragInteractionBinding
    lateinit var actFragInteract: ActFragInteract
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actFragInteractionBinding=ActivityActFragInteractionBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(actFragInteractionBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        actFragInteractionBinding.btnGreen.setOnClickListener {
            actFragInteract.changeBg("Green")
        }
        actFragInteractionBinding.btnBlue.setOnClickListener {
            actFragInteract.changeBg("Blue")
        }
        actFragInteractionBinding.btnRed.setOnClickListener {
            actFragInteract.changeBg("Red")
        }
        actFragInteractionBinding.btnValue.setOnClickListener{
            actFragInteract.dataPass(actFragInteractionBinding.etValue.text.toString().trim())
        }
    }
    fun clearValue(){
        actFragInteractionBinding.etValue.text.clear()
    }
    fun clearCounter(){
        actFragInteractionBinding.tvNum.text="-"
    }
    fun changeValue(value:String){
        actFragInteractionBinding.tvNum.text=value

    }
    fun incValue(){
        val currentValue=actFragInteractionBinding.tvNum.text.toString().toIntOrNull()?:0
        actFragInteractionBinding.tvNum.text=(currentValue+1).toString()
    }
    fun decValue(){
        val currentValue=actFragInteractionBinding.tvNum.text.toString().toIntOrNull()?:0
        actFragInteractionBinding.tvNum.text=(currentValue-1).toString()
    }
}