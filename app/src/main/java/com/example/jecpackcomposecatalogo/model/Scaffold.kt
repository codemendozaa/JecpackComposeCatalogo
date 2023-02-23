package com.example.jecpackcomposecatalogo.model

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
            MyTopAppBar({
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "HAs pulsado $it"
                    )
                }
            }, onclickDrawer = { coroutineScope.launch { scaffoldState.drawerState.open() } })
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFab() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = false,
        drawerContent = { MyDrawer { coroutineScope.launch { scaffoldState.drawerState.close() } } },
        drawerGesturesEnabled = false

    ) {

    }
}


@Composable
fun MyTopAppBar(onclickIcon: (String) -> Unit, onclickDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = "My primera TopAppBar compose ") },
        backgroundColor = Color.Gray,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onclickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")

            }
        },
        actions = {
            IconButton(onClick = { onclickIcon("Search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")

            }

            IconButton(onClick = { onclickIcon("Closed") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")

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

@Composable
fun MyDrawer(onClosedDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primera Opcion",
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClosedDrawer() }
        )
        Text(
            text = "Segunda Opcion",
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClosedDrawer() }
        )

        Text(
            text = "Tercera Opcion",
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClosedDrawer() }
        )

    }
}