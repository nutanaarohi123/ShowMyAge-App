package com.practice.showmyage

import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ShowAgeViewModel : ViewModel() {
    private var userMutableLiveData: MutableLiveData<Age>? = null
    val userAge: MutableLiveData<Age>
        get() {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData!!
        }

    fun getMyAge(inputYear:EditText) {
        val currentyear = Calendar.getInstance().get(Calendar.YEAR)
        val yob = Integer.parseInt(inputYear.text.toString())
        val userage = currentyear - yob
        val age = Age(userage)
        userMutableLiveData!!.value = age
        Log.d("ShowAge","Your age is $age")  //not necessary just for confirmation 
    }
}
