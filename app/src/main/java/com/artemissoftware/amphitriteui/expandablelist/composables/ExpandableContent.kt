package com.artemissoftware.amphitriteui.expandablelist.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.expandablelist.ItemExp
import com.artemissoftware.amphitriteui.ui.theme.Purple500

@ExperimentalAnimationApi
@Composable
fun ExpandableContent(
    expanded: Boolean = true
) {
//    val enterFadeIn = remember {
//        fadeIn(
//            animationSpec = TweenSpec(
//                durationMillis = FadeInAnimation,
//                easing = FastOutLinearInEasing
//            )
//        )
//    }
//    val enterExpand = remember {
//        expandVertically(animationSpec = tween(ExpandAnimation))
//    }
//    val exitFadeOut = remember {
//        fadeOut(
//            animationSpec = TweenSpec(
//                durationMillis = FadeOutAnimation,
//                easing = LinearOutSlowInEasing
//            )
//        )
//    }
//    val exitCollapse = remember {
//        shrinkVertically(animationSpec = tween(CollapseAnimation))
//    }

//    AnimatedVisibility(
//        visible = expanded,
//        enter = enterExpand + enterFadeIn,
//        exit = exitCollapse + exitFadeOut
//    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp)
        ) {
            Text(
                text = "Make It Easy Description",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                color = Purple500
            )
        }
//    }
}


@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    Column {
        ExpandableContent()
        Spacer(modifier = Modifier.height(24.dp))
        ExpandableContent(false)
    }

}