package com.example.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvc.databinding.ActivityMain2Binding
import java.util.*

class MainActivity2 : AppCompatActivity(), Observer, View.OnClickListener {

    private var model: Model? = null
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        model = Model()
        model?.addObserver(this)
        binding.button.setOnClickListener(this@MainActivity2)
        binding.button2.setOnClickListener(this@MainActivity2)
        binding.button3.setOnClickListener(this@MainActivity2)
    }

    override fun update(p0: Observable?, p1: Any?) {
        binding.button.text = model?.getValueAtIndex(0)?.toString()
        binding.button2.text = model?.getValueAtIndex(1)?.toString()
        binding.button3.text = model?.getValueAtIndex(2)?.toString()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button -> {
                model?.setValueAtIndex(0)
            }
            R.id.button2 -> {
                model?.setValueAtIndex(1)
            }
            R.id.button3 -> {
                model?.setValueAtIndex(2)
            }
        }
    }
}