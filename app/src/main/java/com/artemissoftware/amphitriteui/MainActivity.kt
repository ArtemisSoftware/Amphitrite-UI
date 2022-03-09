package com.artemissoftware.amphitriteui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.circularprogress.CircularProgressBarScreen
import com.artemissoftware.amphitriteui.scratchcard.ScratchCard
import com.artemissoftware.amphitriteui.shimmer.ShimmerAnimate
import com.artemissoftware.amphitriteui.shimmer.ShimmerAnimateItem
import com.artemissoftware.amphitriteui.swipebutton.SwipeButton
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphitriteUITheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    //ShimmerAnimate()
                    //CircularProgressBarScreen()

                    SingleContent{
                        ShimmerAnimateItem()
                        //ScratchCard()
                        //SwipeButton()
                    }


                }
            }
        }
    }
}

@Composable
fun SingleContent(
    content: @Composable() () -> Unit
){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        content()
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AmphitriteUITheme {
        Greeting("Android")
    }
}