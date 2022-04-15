package com.artemissoftware.amphitriteui.multilanguage.composables

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.artemissoftware.amphitriteui.util.Language
import java.util.*

@Composable
fun LanguageSetter(language: Language) {

    val locale = Locale(language.abreviation)
    var context = LocalContext.current
    val configuration = LocalConfiguration.current
    configuration.setLocale(locale)

    val resources = LocalContext.current.resources
    resources.updateConfiguration(configuration, resources.displayMetrics);


//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//        context.createConfigurationContext(configuration);
//    } else {
//
//        val resources = LocalContext.current.resources
//        resources.updateConfiguration(configuration, resources.displayMetrics);
//    }
}
