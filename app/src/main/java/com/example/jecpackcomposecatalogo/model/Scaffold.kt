package com.example.jecpackcomposecatalogo.model

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "HAs pulsado $it"
                    )
                }
            }
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFab() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {

    }
}


@Composable
fun MyTopAppBar(onclickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "My primera TopAppBar compose ") },
        backgroundColor = Color.Gray,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onclickIcon("Atrás") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")

            }
        },
        actions = {
            IconButton(onClick = { onclickIcon("Search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")

            }

            IconButton(onClick = { onclickIcon("Closed") }) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "close")

            }
        }

    )
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }
    BottomNavigation {
        BottomNavigationItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "home")
            },
            label = { Text(text = "Home") }
        )

        BottomNavigationItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "favorite")
            },
            label = { Text(text = "Favorite") }
        )

        BottomNavigationItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "p    erson")
            },
            label = { Text(text = "Person") }
        )

    }
}


@Composable
fun MyFab() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = Color.Yellow,
        contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "add")

    }
}