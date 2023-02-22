package com.example.jecpackcomposecatalogo.model

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
        scaffoldState = scaffoldState
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
