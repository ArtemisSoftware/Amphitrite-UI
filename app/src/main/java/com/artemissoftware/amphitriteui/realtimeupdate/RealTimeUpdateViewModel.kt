package com.artemissoftware.amphitriteui.realtimeupdate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.amphitriteui.realtimeupdate.model.RealTimeUpdate
import com.artemissoftware.amphitriteui.realtimeupdate.usecases.DownloadItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RealTimeUpdateViewModel: ViewModel() {


    lateinit var downloadItemUseCase: DownloadItemUseCase


    private val _realTimeUpdate = MutableStateFlow(listOf<RealTimeUpdate>())
    val realTimeUpdate: StateFlow<List<RealTimeUpdate>> = _realTimeUpdate

    private val downloadQueue: MutableMap<Int, Flow<Int>> = mutableMapOf()

    init {
        getRealTimeUpdateItem()
    }

    private fun getRealTimeUpdateItem() {
        viewModelScope.launch(context = Dispatchers.Default) {

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

    fun startDownload(itemId: Int, index: Int) {
        if (downloadQueue.containsKey(itemId))
            return
        val download: Flow<Int> = downloadItemUseCase(itemId)
        downloadQueue[itemId] = download
        observeDownload(index, download)
    }

    private fun observeDownload(index: Int, download: Flow<Int>) {

        download.onEach { progress ->

            if (progress >= 100) {
                downloadQueue.remove(_realTimeUpdate.value[index].id)
            }

            val realtimeItem = _realTimeUpdate.value[index].copy(downloadProgress = progress)

            val downloadList = _realTimeUpdate.value.toMutableList()
            downloadList[index] = realtimeItem
            _realTimeUpdate.value = downloadList.toList()

        }.launchIn(viewModelScope)

    }
}
