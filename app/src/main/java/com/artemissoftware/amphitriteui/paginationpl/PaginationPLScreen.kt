package com.artemissoftware.amphitriteui.paginationpl

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.amphitriteui.paginationpl.composables.PageItem

@Composable
fun PaginationPLScreen() {

    val viewModel = viewModel<MainViewModel>()
    val state = viewModel.state

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        items(state.items.size) { i ->

            val item = state.items[i]

            if (i >= state.items.size - 1 && !state.endReached && !state.isLoading) {
                viewModel.loadNextItems()
            }

            PageItem(item = item)

        }

        item {
            if (state.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}