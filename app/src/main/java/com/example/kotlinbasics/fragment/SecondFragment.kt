package com.example.kotlinbasics.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlinbasics.R
import com.example.kotlinbasics.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var frag2binding:FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frag2binding=FragmentSecondBinding.inflate(inflater,container,false)
        return frag2binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frag2binding.btnFirstFrag.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }
    }
