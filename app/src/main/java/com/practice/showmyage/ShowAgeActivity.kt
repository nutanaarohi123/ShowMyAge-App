package com.practice.showmyage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.practice.showmyage.databinding.ActivityAgeBinding

class ShowAgeActivity : AppCompatActivity() {
    private lateinit var viewmodel: ShowAgeViewModel
    private lateinit var binding:ActivityAgeBinding
            @SuppressLint("SetTextI18n")
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgeBinding.inflate(layoutInflater)
        // Hide the status bar.
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
                setContentView(binding.root)
                viewmodel= ViewModelProvider(this).get(ShowAgeViewModel::class.java)
         binding.showButton.setOnClickListener {
           viewmodel.getMyAge(binding.inputyear)
         }


         viewmodel.userAge.observe(this,{
            t ->  if(t!=null){
                val show = "You are ${t.age} year old"
             binding.showAge.text = show
             binding.constraintLayout.setBackgroundResource(R.drawable.cupbg2)
             binding.showAge.visibility= View.VISIBLE
             binding.showButton.visibility= View.GONE
             binding.inputyear.visibility= View.GONE
             }
         })

    }


}