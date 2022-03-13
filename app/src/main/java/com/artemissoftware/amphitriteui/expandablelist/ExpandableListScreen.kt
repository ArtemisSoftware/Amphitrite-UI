package com.artemissoftware.amphitriteui.expandablelist

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.amphitriteui.expandablelist.composables.ExpandableCard

@ExperimentalAnimationApi
@Composable
fun ExpandableListScreen() {

    val viewModel: ExpandableViewModel = viewModel()
    val cards = viewModel.cards.collectAsState()
    val expandedCard = viewModel.expandedCardList.collectAsState()


    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        itemsIndexed(cards.value) { _, card ->
            ExpandableCard(
                card = card,
                onCardArrowClick = { viewModel.cardArrowClick(card.id) },
                expanded = expandedCard.value.contains(card.id)
            )
        }
    }

}