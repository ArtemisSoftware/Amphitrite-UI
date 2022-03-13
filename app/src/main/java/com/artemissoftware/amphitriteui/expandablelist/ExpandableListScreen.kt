package com.artemissoftware.amphitriteui.expandablelist

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.amphitriteui.circularprogress.CircularProgressViewModel
import com.artemissoftware.amphitriteui.expandablelist.composables.ExpandableCard

@ExperimentalAnimationApi
@Composable
fun ExpandableListScreen() {

    val viewModel: ExpandableViewModel = viewModel()
    val cards = viewModel.cards.collectAsState()
    val expandedCard = viewModel.expandedCardList.collectAsState()


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
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