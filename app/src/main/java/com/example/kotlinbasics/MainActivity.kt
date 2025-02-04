package com.example.kotlinbasics

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.databinding.ActivityMainBinding

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
//            val alertDialogBuilder = AlertDialog.Builder(this)
//            .setTitle("Confirmation")
//            .setMessage("Do you wanna delete this")
//            .setPositiveButton("Yes") { _, _ ->
//                Toast.makeText(this,"You Pressed Yes..",Toast.LENGTH_SHORT).show()
//            }
//            .setNegativeButton("No") { _, _ ->
//                Toast.makeText(this,"You Pressed No..",Toast.LENGTH_SHORT).show()
//            }
//            .setNeutralButton("Cancel"){_,_ ->
//                Toast.makeText(this,"You Pressed Cancel..",Toast.LENGTH_SHORT).show()
//            }.show()

            val alertDialogBuilder = AlertDialog.Builder(this).apply {
                setTitle("Confirmation")
                setMessage("Do you wanna delete this")
                setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(this@MainActivity,"You Pressed Yes..",Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("No") { _, _ ->
                    Toast.makeText(this@MainActivity,"You Pressed No..",Toast.LENGTH_SHORT).show()
                }
                setNeutralButton("Cancel"){_,_ ->
                    Toast.makeText(this@MainActivity,"You Pressed Cancel..",Toast.LENGTH_SHORT).show()
                }.show()
            }

        }
    }
}