package com.artemissoftware.amphitriteui.multilanguage.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.R

@Composable
fun TopBarLanguage(menuExpanded: MutableState<Boolean>) {

    TopAppBar(
        title = {
            Text(
                text = "MultiLanguage",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        actions = {
            IconButton(
                onClick = {
                    menuExpanded.value = true
                }
            ) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
            Column(
                modifier = Modifier.wrapContentSize(TopStart)
            ) {
                DropdownMenu(
                    expanded = menuExpanded.value,
                    onDismissRequest = {
                        menuExpanded.value = false
                    },
                    modifier = Modifier
                        .width(150.dp)
                        .wrapContentSize(TopStart)
                ) {
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(id = R.string.versions))
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(id = R.string.settings))
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(id = R.string.logout))
                    }
                }
            }
        }
    )

}