package com.example.st_travellers.view

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.st_travellers.R

class PreferenceFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}