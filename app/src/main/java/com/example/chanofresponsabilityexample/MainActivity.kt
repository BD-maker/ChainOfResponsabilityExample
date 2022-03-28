package com.example.chanofresponsabilityexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.chanofresponsabilityexample.core.ContactlessPayListener
import com.example.chanofresponsabilityexample.databinding.ActivityMainBinding
import com.example.chanofresponsabilityexample.domain.data.AnimationStates
import com.example.chanofresponsabilityexample.ui.viewModel.CompraViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CompraViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAction.setOnClickListener(View.OnClickListener {
            initVM()
        })
    }

    private fun initVM(){
        viewModel.init()
        viewModel.states.observe(this, Observer { state ->
            when(state){
                AnimationStates.BeginProcess -> Log.d("Activity","Iniciando proceso")
                AnimationStates.RequestPreAuth -> {
                    Log.d("Activity","Esperando huella")
                    binding.btnEvent.setOnClickListener( View.OnClickListener {
                        val contactlessPayListener = ContactlessPayListener()
                        contactlessPayListener.onAuthenticationCompleted()
                        binding.btnEvent.visibility = View.INVISIBLE
                    })
                    binding.btnEvent.visibility = View.VISIBLE
                }
                AnimationStates.EndProcess -> Log.d("Activity","Fin Proceso")
            }
        })
    }


}