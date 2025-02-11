package com.example.kotlinbasics.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlinbasics.R
import com.example.kotlinbasics.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
   private lateinit var frag1binding:FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        frag1binding=FragmentFirstBinding.inflate(inflater,container,false)
        return frag1binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frag1binding.btnSecondFrag.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

        }
    }

}