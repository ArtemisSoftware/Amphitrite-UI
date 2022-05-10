package com.artemissoftware.amphitriteui.showcase

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ShowCaseScreen() {

    val context = LocalContext.current
    //val targets = remember { mutableStateMapOf<String, ShowCaseProperty>() }

    Box {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { },
                    backgroundColor = Color.Transparent,
                    elevation = 0.dp,
                    navigationIcon = {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .onGloballyPositioned { coordinates ->
//                                    targets["back"] = ShowCaseProperty(
//                                        4,
//                                        coordinates,
//                                        "Go back!",
//                                        "You can go back by Clicking here!!!"
//                                    )
                                }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .onGloballyPositioned { coordinates ->
//                                    targets["search"] = ShowCaseProperty(
//                                        3,
//                                        coordinates,
//                                        "Search anything!",
//                                        "You can search anything by clicking here!!!"
//                                    )
                                }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search"
                            )
                        }
                    }
                )
            },
            /*
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .onGloballyPositioned { coordinates ->
                            targets["email"] = ShowCaseProperty(
                                1,
                                coordinates,
                                "Check email",
                                "You can Click here to email"
                            )
                        },
                    backgroundColor = ThemeColor,
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.elevation(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email"
                    )
                }
            }
        */
        ) {
            /*
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.3f)
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth()
                            .padding(16.dp)
                            .height(90.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "ShowCase View",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = ThemeColor
                        )
                        Text(
                            text = "In this Example of ShowCase View",
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .onGloballyPositioned { coordinates ->
                                targets["profile"] = ShowCaseProperty(
                                    0,
                                    coordinates,
                                    "User Profile",
                                    "You can click here to update profile image"
                                )
                            }
                    )
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, bottom = 16.dp)
                        .onGloballyPositioned { coordinates ->
                            targets["follow"] = ShowCaseProperty(
                                2,
                                coordinates,
                                "Follow Me",
                                "You can click here to follow"
                            )
                        }
                ) {
                    Text(text = "Follow Me!")
                }
            }
            */
        }

        /*
        ShowCaseView(targets = targets) {
            Toast.makeText(context, "App Intro finished!", Toast.LENGTH_SHORT).show()
        }
        */
    }
}