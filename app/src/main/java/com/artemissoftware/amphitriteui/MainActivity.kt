package com.artemissoftware.amphitriteui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.expandablelist.ExpandableListScreen
import com.artemissoftware.amphitriteui.expandablelist.ItemExp
import com.artemissoftware.amphitriteui.expandablelist.composables.ExpandableCard
import com.artemissoftware.amphitriteui.imagepicker.ImagePickerScreen
import com.artemissoftware.amphitriteui.player.ExoPlayer
import com.artemissoftware.amphitriteui.shimmer.ShimmerAnimateItem
import com.artemissoftware.amphitriteui.shimmer.ShimmerAnimateScreen
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme
import com.artemissoftware.amphitriteui.util.Constants.VIDEO_URL

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphitriteUITheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    //ShimmerAnimateScreen()
                    //CircularProgressBarScreen()
                    //ExpandableListScreen()
                    ImagePickerScreen()

//                    SingleContent{

                        //ExoPlayer(url = VIDEO_URL)
                        //ScratchCard()
                        //SwipeButton()
//                    }


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