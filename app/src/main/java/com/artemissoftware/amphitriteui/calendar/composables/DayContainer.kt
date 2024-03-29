package com.artemissoftware.amphitriteui.calendar.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.calendar.models.DaySelectedStatus
import com.artemissoftware.amphitriteui.util.CalendarConstants.CELL_SIZE

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DayContainer(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: () -> Unit = { },
    onClickEnabled: Boolean = true,
    backgroundColor: Color = Color.Transparent,
    onClickLabel: String? = null,
    content: @Composable () -> Unit
) {
    val stateDescriptionLabel = stringResource(
        if (selected) R.string.state_descr_selected else R.string.state_descr_not_selected
    )
    Surface(
        modifier = modifier
            .size(CELL_SIZE)
            .then(
                if (onClickEnabled) {
                    modifier.semantics {
                        stateDescription = stateDescriptionLabel
                    }
                } else {
                    modifier.clearAndSetSemantics { }
                }
            ),
        onClick = onClick,
        enabled = onClickEnabled,
        color = backgroundColor,
        onClickLabel = onClickLabel
    ) {
        content()
    }
}

@Composable
fun DayStatusContainer(
    status: DaySelectedStatus,
    content: @Composable () -> Unit
) {
    if (DaySelectedStatus.isMarked(status)) {
        Box {

            val color = MaterialTheme.colors.secondary

            Circle(color = color)

            when{

                status == DaySelectedStatus.FirstDay->{
                    SemiRect(color = color, lookingLeft = false)
                }
//                status == DaySelectedStatus.LastDay->{
//                SemiRect(color = color, lookingLeft = true)
//                }
            }


            content()
        }
    } else {
        content()
    }
}