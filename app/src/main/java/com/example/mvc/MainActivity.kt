package com.example.mvc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvc.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {

    var myModel: MyModel? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myModel = MyModel()
        myModel?.addObserver(this)

        binding.apply {
            button.setOnClickListener(this@MainActivity)
            button2.setOnClickListener(this@MainActivity)
        }
        binding.next.setOnClickListener { startActivity(Intent(this, MainActivity2::class.java)) }
    }

    override fun update(p0: Observable?, p1: Any?) {
        binding.textView.text = myModel?.getValue().toString()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button -> myModel?.decrement()
            R.id.button2 -> myModel?.increment()
        }
    }
}