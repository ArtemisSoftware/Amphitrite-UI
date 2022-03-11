package com.artemissoftware.amphitriteui.shimmer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.ui.theme.Purple500
import com.artemissoftware.amphitriteui.util.Constants

@ExperimentalFoundationApi
@Composable
fun ShimmerAnimateScreen() {


//    val brush = Brush.linearGradient(
//        colors = Constants.SHIMMER_COLORS,
//        start = Offset(10f, 10f),
//        //end = Offset(translateAnim.value, translateAnim.value)
//    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Purple500)
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Shimmer Animate",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {

            repeat(3) {
                item {
                    ShimmerAnimateItem{
                        ShimmerItem(brush = it)
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.padding(10.dp)
        ) {
            repeat(10) {
                item {
                    ShimmerAnimateItem{
                        ShimmerGridItem(brush = it)
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ShimmerAnimateScreen()
}