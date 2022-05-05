package com.artemissoftware.amphitriteui.realtimeupdate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.amphitriteui.realtimeupdate.composables.RealTimeUpdateItemCard

@Composable
fun RealTimeUpdateScreen() {

    val viewModel: RealTimeUpdateViewModel = viewModel()
    val realTimeUpdateItem = viewModel.realTimeUpdate.collectAsState()

    LazyColumn {
        itemsIndexed(realTimeUpdateItem.value) { index, item ->
            RealTimeUpdateItemCard(
                realTimeUpdateItem = item,
                onDownloadClick = {
                    //viewModel.onDownloadRealTimeUpdateItemClicked(item.id, index)
                }
            )
        }
    }
}