package com.artemissoftware.amphitriteui.realtimeupdate.usecases

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class DownloadItemUseCase() {

    operator fun invoke(itemId: Int): Flow<Int> = flow {

            var progress = 10
            emit(progress)

            repeat(100) {
                progress += Random.nextInt(10, 25)

                delay(500L)

                if (progress >= 100) {
                    emit(100)
                    return@flow
                }
                else
                    emit(progress)
            }
        }

}