package com.artemissoftware.amphitriteui.autocomplete

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.autocomplete.composables.CountryList

@Composable
fun CountryListScreen() {

    val textVal = remember { mutableStateOf(TextFieldValue("")) }

    Column {
//        SearchCountryList(textVal)
        CountryList(textVal)
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    CountryListScreen()
}