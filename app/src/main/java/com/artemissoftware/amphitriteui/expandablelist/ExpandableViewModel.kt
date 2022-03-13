package com.artemissoftware.amphitriteui.expandablelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExpandableViewModel: ViewModel() {

    private val _cards = MutableStateFlow(listOf<ItemExp>())
    val cards: StateFlow<List<ItemExp>> get() = _cards

    private val _expandedCardList = MutableStateFlow(listOf<Int>())
    val expandedCardList: StateFlow<List<Int>> get() = _expandedCardList

    init {
        getSampleData()
    }

    private fun getSampleData() {
        viewModelScope.launch(Dispatchers.Default) {
            val sampleList = arrayListOf<ItemExp>()
            repeat(10) {
                sampleList += ItemExp(
                    id = it + 1,
                    title = "Expandable card ${it + 1}"
                )
            }
            _cards.emit(sampleList)
        }
    }

    fun cardArrowClick(cardId: Int) {
        _expandedCardList.value = _expandedCardList.value.toMutableList().also { list ->
            if (list.contains(cardId)) {
                list.remove(cardId)
            } else {
                list.add(cardId)
            }
        }
    }
}







