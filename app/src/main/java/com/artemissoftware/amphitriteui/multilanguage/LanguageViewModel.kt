package com.artemissoftware.amphitriteui.multilanguage

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.amphitriteui.multilanguage.repository.DataStorePreferenceRepository
import com.artemissoftware.amphitriteui.paginationpl.ScreenState
import com.artemissoftware.amphitriteui.util.Language
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LanguageViewModel: ViewModel() {

    private lateinit var dataStorePreferenceRepository: DataStorePreferenceRepository

    var language by mutableStateOf(Language.ENGLISH)

    fun getLanguage(context: Context){

        dataStorePreferenceRepository = DataStorePreferenceRepository(context = context)

        viewModelScope.launch {
            dataStorePreferenceRepository.getLanguage.collect {
                language = Language.get(it)
            }
        }
    }

    fun saveLanguage(language: Int) {
        viewModelScope.launch(Dispatchers.Default){
            dataStorePreferenceRepository.setLanguage(language)
        }

    }
}