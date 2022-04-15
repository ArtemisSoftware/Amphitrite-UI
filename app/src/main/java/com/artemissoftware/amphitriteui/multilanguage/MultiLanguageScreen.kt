package com.artemissoftware.amphitriteui.multilanguage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.amphitriteui.expandablelist.ExpandableViewModel
import com.artemissoftware.amphitriteui.multilanguage.composables.LanguageContent
import com.artemissoftware.amphitriteui.multilanguage.composables.LanguageSetter
import com.artemissoftware.amphitriteui.multilanguage.composables.TopBarLanguage

@Composable
fun MultiLanguageScreen(
//    viewModel: LanguageViewModel = viewModel(
//        factory = DataStoreViewModelFactory(DataStorePreferenceRepository(LocalContext.current))
    ) {

    val viewModel: LanguageViewModel = viewModel()
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.getLanguage(context)
    }

    val currentLanguage = viewModel.language


//    val scope = rememberCoroutineScope()
//    val currentLanguage = viewModel.language.observeAsState().value
    val menuExpanded = remember { mutableStateOf(false) }
//
    LanguageSetter(language = currentLanguage)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarLanguage(menuExpanded = menuExpanded)
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState(0))
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(8.dp))


            LanguageContent(
                selectedPosition = currentLanguage.position,
                onLanguageSelected = {
                    viewModel.saveLanguage(it)
                }
            )
//            LanguagePicker(currentLanguage) { selected ->
//                scope.launch {
//                    viewModel.saveLanguage(selected)
//                }
//            }
        }
    }
}