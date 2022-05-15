package com.artemissoftware.amphitriteui.animation.searching

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.animation.searching.composables.AnimateSearch
import com.artemissoftware.amphitriteui.animation.searching.composables.InfinitelyFlowingCircles

@Composable
fun Searching() {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        InfinitelyFlowingCircles()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 28.dp, end = 28.dp),
            contentAlignment = Alignment.Center
        ) {
            AnimateSearch()
        }
    }
}