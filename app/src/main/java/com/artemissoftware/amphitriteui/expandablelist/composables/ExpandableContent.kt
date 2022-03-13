package com.artemissoftware.amphitriteui.expandablelist.composables

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.ui.theme.Purple500
import com.artemissoftware.amphitriteui.util.Constants.CollapseAnimationDuration
import com.artemissoftware.amphitriteui.util.Constants.ExpandAnimationDuration
import com.artemissoftware.amphitriteui.util.Constants.FadeInAnimationDuration
import com.artemissoftware.amphitriteui.util.Constants.FadeOutAnimationDuration

@ExperimentalAnimationApi
@Composable
fun ExpandableContent(
    expanded: Boolean = true
) {

    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimationDuration))
    }

    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimationDuration))
    }

    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimationDuration,
                easing = FastOutLinearInEasing
            )
        )
    }

    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimationDuration,
                easing = LinearOutSlowInEasing
            )
        )
    }


    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
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
    }
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