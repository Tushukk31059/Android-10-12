package com.example.kotlinbasics

import android.app.Dialog
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.databinding.ActivityMainBinding
import com.example.kotlinbasics.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnForm.setOnClickListener {
            val intent= Intent(this,FormActivity::class.java)
            startActivity(intent)
        }
        binding.btnIntent.setOnClickListener {
            startActivity(Intent(this,ImplicitIntentsAct::class.java))
        }
        binding.btnRelative.setOnClickListener {
            startActivity(Intent(this,RelativeLinearAct::class.java))
        }
        binding.btnConstraint.setOnClickListener {
            startActivity(Intent(this,ConstraintActivity::class.java))
        }
        binding.btnConstraintII.setOnClickListener {
            startActivity(Intent(this,ConstarintLayoutII::class.java))
        }
        binding.btnAlert.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
                .apply {
                    setTitle("Confirmation")
                    setMessage("Do you wanna delete this")
                    setPositiveButton("Yes"){_,_ ->
                        Toast.makeText(this@MainActivity,"You Pressed Yes..",Toast.LENGTH_SHORT).show()
                    }
                    setNeutralButton("Cancel"){_,_ ->
                        Toast.makeText(this@MainActivity,"You Pressed cancel..",Toast.LENGTH_SHORT).show()
                    }
                    setNegativeButton("No"){_,_ ->
                        Toast.makeText(this@MainActivity,"You Pressed No..",Toast.LENGTH_SHORT).show()
                    }
                }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
                val window = alertDialog.window
                window?.setBackgroundDrawable(AppCompatResources.getDrawable(this,R.drawable.card_background_i))
                window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
                val positiveBtn = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
                positiveBtn.setTextColor(getColor(R.color.white))
                positiveBtn.textSize = 20f
                val fontFace = ResourcesCompat.getFont(this,R.font.raleway_font)
                positiveBtn.setTypeface(fontFace,Typeface.NORMAL)
        }
        binding.btnCustom.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding=CustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.show()
            dialog.setCancelable(false)
            dialogBinding.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
            dialogBinding.btnDelete.setOnClickListener {
                Toast.makeText(this,"You clicked Delete",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialogBinding.imgCancel.setOnClickListener {
                dialog.dismiss()
            }
            val customWindow= dialog.window
            customWindow?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            customWindow?.setBackgroundDrawable(AppCompatResources.getDrawable(this,R.drawable.custom_dialog_bg))
        }
    }
}