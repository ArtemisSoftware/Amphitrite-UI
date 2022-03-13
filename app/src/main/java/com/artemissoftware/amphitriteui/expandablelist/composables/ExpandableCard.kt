package com.artemissoftware.amphitriteui.expandablelist.composables

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.expandablelist.ItemExp
import com.artemissoftware.amphitriteui.ui.theme.Purple500
import com.artemissoftware.amphitriteui.util.Constants.ExpandAnimationDuration

@SuppressLint("UnusedTransitionTargetStateParameter")
@ExperimentalAnimationApi
@Composable
fun ExpandableCard(
    card: ItemExp,
    expanded: Boolean,
    arrowRotationDegree: Float = 180F,
    onCardArrowClick: () -> Unit
){

    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}

    val transition = updateTransition(targetState = transitionState, label = "transition")


    val cardBgColor by transition.animateColor(
        transitionSpec = {
            tween(durationMillis = ExpandAnimationDuration)
        },
        label = "bgColorTransition"
    ){
        if (expanded) Purple500 else Purple500
    }
//    val cardPaddingHorizontal by transition.animateDp({
//        tween(durationMillis = ExpandAnimation)
//    }, label = "paddingTransition") {
//        20.dp
//    }
//    val cardElevation by transition.animateDp({
//        tween(durationMillis = ExpandAnimation)
//    }, label = "elevationTransition") {
//        if (expanded) 20.dp else 5.dp
//    }
//    val cardRoundedCorners by transition.animateDp({
//        tween(
//            durationMillis = ExpandAnimation,
//            easing = FastOutSlowInEasing
//        )
//    }, label = "cornersTransition") {
//        15.dp
//    }
//    val arrowRotationDegree by transition.animateFloat({
//        tween(durationMillis = ExpandAnimation)
//    }, label = "rotationDegreeTransition") {
//        if (expanded) 0f else 180f
//    }



    Card(
        backgroundColor = cardBgColor,
//        elevation = cardElevation,
//        shape = RoundedCornerShape(cardRoundedCorners),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(
//                horizontal = cardPaddingHorizontal,
//                vertical = 8.dp
//            )
    ) {

        Column(
//            modifier = Modifier
//                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.weight(0.85f)
                    ) {
                        Text(
                            text = card.title,
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        )
                    }

                    Column(
                        modifier = Modifier.weight(0.15f)
                    ) {
                        CardArrow(
                            degrees = arrowRotationDegree,
                            onClick = onCardArrowClick,
                            color = Color.White
                        )
                    }
                }
            }
            ExpandableContent(expanded)
        }

    }

}


@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    val card = ItemExp(1, "Title")
    ExpandableCard(card = card, onCardArrowClick = {}, expanded = true)
}