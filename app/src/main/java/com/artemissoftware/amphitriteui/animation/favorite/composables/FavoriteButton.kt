package com.artemissoftware.amphitriteui.animation.favorite.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.animation.favorite.models.FavoriteButtonState
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme
import com.artemissoftware.amphitriteui.ui.theme.Purple500

@Composable
fun FavoriteButton(buttonState: MutableState<FavoriteButtonState>, onClick: () -> Unit) {

    val width = if (buttonState.value == FavoriteButtonState.PRESSED) 60.dp else 300.dp

    Button(
        border = BorderStroke(1.dp, Purple500),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.size(width, 60.dp),
        onClick = onClick
    ) {
        ButtonContent(buttonState = buttonState)
    }
}

@Composable
private fun ButtonContent(buttonState: MutableState<FavoriteButtonState>) {

    if (buttonState.value == FavoriteButtonState.IDLE) { //1

        Row(verticalAlignment = Alignment.CenterVertically) {

            Column(
                modifier = Modifier.width(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    tint = Purple500,
                    contentDescription = "",
                    imageVector = Icons.Default.FavoriteBorder,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                "ADD TO FAVORITES!",
                softWrap = false,
                color = Purple500
            )
        }
    }
    else{

        Icon(
            tint = Purple500,
            contentDescription = "",
            imageVector = Icons.Default.Favorite,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Column {

        val buttonState = remember { mutableStateOf(FavoriteButtonState.PRESSED) }
        FavoriteButton(buttonState = buttonState, onClick = {})

        val buttonState2 = remember { mutableStateOf(FavoriteButtonState.IDLE) }
        FavoriteButton(buttonState = buttonState2, onClick = {})
    }

}