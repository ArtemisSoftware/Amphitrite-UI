package com.artemissoftware.amphitriteui.multilanguage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.artemissoftware.amphitriteui.multilanguage.composables.TopBarLanguage

@Composable
fun MultiLanguageScreen(
//    viewModel: LanguageViewModel = viewModel(
//        factory = DataStoreViewModelFactory(DataStorePreferenceRepository(LocalContext.current))
    ) {
//    val scope = rememberCoroutineScope()
//    val currentLanguage = viewModel.language.observeAsState().value
    val menuExpanded = remember { mutableStateOf(false) }
//
//    SetLanguage(position = currentLanguage!!)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarLanguage(menuExpanded = menuExpanded)
        }
    ) {
//        Column(
//            modifier = Modifier
//                .verticalScroll(rememberScrollState(0))
//                .fillMaxSize()
//        ) {
//            Spacer(modifier = Modifier.height(8.dp))
//            LanguagePicker(currentLanguage) { selected ->
//                scope.launch {
//                    viewModel.saveLanguage(selected)
//                }
//            }
//        }
    }
}