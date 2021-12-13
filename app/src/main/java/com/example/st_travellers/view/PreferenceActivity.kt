package com.example.st_travellers.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.st_travellers.R

class PreferenceActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preference_activity)
        val fragment = PreferenceFragment()
        addFragmentToActivity(fragment)
    }

    private fun addFragmentToActivity(fragment: Fragment){
        if (fragment == null) return
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.add(R.id.preferenceContainer, fragment)
        tr.commitAllowingStateLoss()
        //curFragment = fragment
    }
}