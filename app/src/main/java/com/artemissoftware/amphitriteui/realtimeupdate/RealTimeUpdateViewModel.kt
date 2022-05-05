package com.artemissoftware.amphitriteui.realtimeupdate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.amphitriteui.realtimeupdate.model.RealTimeUpdate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RealTimeUpdateViewModel: ViewModel() {

    private val _realTimeUpdate = MutableStateFlow(listOf<RealTimeUpdate>())
    val realTimeUpdate: StateFlow<List<RealTimeUpdate>> get() = _realTimeUpdate

    //private val downloadQueue: MutableMap<Int, Flow<Int>> = mutableMapOf()

    init {
        getRealTimeUpdateItem()
    }

    private fun getRealTimeUpdateItem() {
        viewModelScope.launch(Dispatchers.Default) {

            val initialRealTimeUpdateItem = arrayListOf<RealTimeUpdate>()

            repeat(20) {
                initialRealTimeUpdateItem += RealTimeUpdate(
                    id = it + 1,
                    title = "Download File ${it + 1}",
                    downloadProgress = 0
                )
            }
            _realTimeUpdate.emit(initialRealTimeUpdateItem)
        }
    }

//    private fun provideDownloadFlow(RealTimeUpdateItemId: Int): Flow<Int> {
//        return flow {
//            var progress = 10
//            emit(progress)
//            repeat(100) {
//                progress += Random.nextInt(10, 25)
//                delay(500L)
//                if (progress >= 100)
//                    emit(100)
//                else
//                    emit(progress)
//                if (progress >= 100) {
//                    downloadQueue.remove(RealTimeUpdateItemId)
//                    return@flow
//                }
//            }
//        }
//    }
//
//    fun onDownloadRealTimeUpdateItemClicked(RealTimeUpdateItemId: Int, index: Int) {
//        if (downloadQueue.containsKey(RealTimeUpdateItemId))
//            return
//        val download: Flow<Int> = provideDownloadFlow(RealTimeUpdateItemId)
//        downloadQueue[RealTimeUpdateItemId] = download
//        observeDownload(index, download)
//    }
//
//    private fun observeDownload(index: Int, download: Flow<Int>) {
//        viewModelScope.launch(Dispatchers.Default) {
//            download.collect { progress ->
//                val updatedRealTimeUpdateItem = _realTimeUpdateItem.value[index].copy(downloadProgress = progress)
//                val mutableRealTimeUpdateItem = _realTimeUpdateItem.value.toMutableList()
//                mutableRealTimeUpdateItem[index] = updatedRealTimeUpdateItem
//                _realTimeUpdateItem.value = mutableRealTimeUpdateItem.toList()
//            }
//        }
//    }
}
