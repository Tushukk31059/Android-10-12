package com.example.kotlinbasics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinbasics.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    private lateinit var fragmentBinding: ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        fragmentBinding=ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(fragmentBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navHost:NavHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController:NavController=navHost.navController
        fragmentBinding.btnFrag1.setOnClickListener {
            if (navController.currentDestination?.id== R.id.secondFragment)
                navController.navigate(R.id.action_secondFragment_to_firstFragment)
        }
        fragmentBinding.btnFrag2.setOnClickListener {
            if (navController.currentDestination?.id==R.id.firstFragment)
                navController.navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}