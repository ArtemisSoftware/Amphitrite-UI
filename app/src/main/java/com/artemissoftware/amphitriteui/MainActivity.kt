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
import com.artemissoftware.amphitriteui.bottomsheet.BottomSheetScreen
import com.artemissoftware.amphitriteui.collapsebottomnavigation.BottomCollapseScreen
import com.artemissoftware.amphitriteui.imagepicker.CameraApp
import com.artemissoftware.amphitriteui.nestedscroll.NestedScrollScreen
import com.artemissoftware.amphitriteui.observeliveconnectivity.ConnectivityScreen
import com.artemissoftware.amphitriteui.pin.PinScreen
import com.artemissoftware.amphitriteui.ratingbar.RatingBar
import com.artemissoftware.amphitriteui.sound.SoundScreen
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class MainActivity : ComponentActivity() {
    @ExperimentalPermissionsApi
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
                    //CameraApp()
                    //SoundScreen()
                    //BottomSheetScreen()
                    //NestedScrollScreen()
                    //BottomCollapseScreen()
                    //ConnectivityScreen()
                    PinScreen()

//                    SingleContent{
//
//                        //ExoPlayer(url = VIDEO_URL)
//                        //ScratchCard()
//                        //SwipeButton()
//                        //RatingBar()
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

