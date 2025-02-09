package com.example.kotlinbasics.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinbasics.R
import com.example.kotlinbasics.databinding.FragmentInteractBinding

class InteractFrag : Fragment(),ActFragInteract {
    private lateinit var interactBinding: FragmentInteractBinding
    private lateinit var actFragInteraction: ActFragInteraction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actFragInteraction= activity as ActFragInteraction
        actFragInteraction.actFragInteract=this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        interactBinding=FragmentInteractBinding.inflate(inflater,container,false)
        return interactBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        interactBinding.btnFragPass.setOnClickListener {
        actFragInteraction.changeValue(interactBinding.etFragValue.text.toString().trim())
        }
        interactBinding.btnInc.setOnClickListener {
            actFragInteraction.incValue()
        }
        interactBinding.btnDec.setOnClickListener {
            actFragInteraction.decValue()
        }
        interactBinding.btnReset.setOnClickListener {
            actFragInteraction.clearCounter()
            actFragInteraction.clearValue()
            interactBinding.etFragValue.text.clear()
        }
    }

    override fun dataPass(value: String) {
        actFragInteraction.clearCounter()
        interactBinding.etFragValue.setText(value)
    }

    override fun changeBg(value: String) {
        if(value=="Green"){
            interactBinding.fragLayout.setBackgroundResource(R.drawable.bg_green)
        }else if (value=="Blue"){
            interactBinding.fragLayout.setBackgroundResource(R.drawable.bg_blue)
        }else if (value=="Red"){
            interactBinding.fragLayout.setBackgroundResource(R.drawable.bg_red)
        }
    }
}