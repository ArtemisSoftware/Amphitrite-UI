package com.artemissoftware.amphitriteui.autocomplete.composables

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun CountryList(textVal: MutableState<TextFieldValue>) {

    val context = LocalContext.current
    val countries = getListOfCountries()
    var filteredCountries: ArrayList<String>

    val searchText = textVal.value.text
    filteredCountries = if (searchText.isEmpty()) {
        countries
    } else {
        val resultList = ArrayList<String>()
        for (country in countries) {
            if (country.lowercase(Locale.getDefault()).contains(searchText.lowercase(Locale.getDefault()))) {
                resultList.add(country)
            }
        }
        resultList
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {

        items(filteredCountries) { filteredCountries ->
            CountryListItem(
                countryText = filteredCountries,
                onItemClick = { selectedCountry ->
                    Toast.makeText(context, selectedCountry, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

fun getListOfCountries(): ArrayList<String> {
    
    val isoCountryCodes = Locale.getISOCountries()
    val countryListWithEmojis = ArrayList<String>()
    
    for (countryCode in isoCountryCodes) {
        val locale = Locale("", countryCode)
        val countryName = locale.displayCountry
        val flagOffset = 0x1F1E6
        val asciiOffset = 0x41
        val firstChar = Character.codePointAt(countryCode, 0) - asciiOffset + flagOffset
        val secondChar = Character.codePointAt(countryCode, 1) - asciiOffset + flagOffset
        val flag = (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))
        countryListWithEmojis.add("$countryName (${locale.country}) $flag")
    }
    return countryListWithEmojis
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    val textVal = remember { mutableStateOf(TextFieldValue("Angola")) }
    CountryList(textVal = textVal)
}