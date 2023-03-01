package com.example.jecpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jecpackcomposecatalogo.model.Routes

@Composable
fun Screen1(navHostController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = "Pantalla 1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navHostController.navigate(Routes.Pantalla2.route) })
    }
}

@Composable
fun Screen2(navHostController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = "Pantalla 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navHostController.navigate(Routes.Pantalla3.route) })
    }
}

@Composable
fun Screen3(navHostController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = "Pantalla 3", modifier = Modifier
            .align(Alignment.Center)
            .clickable { navHostController.navigate(Routes.Pantalla4.createRoute(24)) })
    }
}

@Composable
fun Screen4(navHostController: NavHostController, age: Int) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(text = "tengo $age años", modifier = Modifier
            .align(Alignment.Center)
            .clickable { navHostController.navigate(Routes.Pantalla5.createRoute("")) })
    }
}


@Composable
fun Screen5(navHostController: NavHostController, name: String?) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "sigueme en @$name ", modifier = Modifier.align(Alignment.Center))
    }
}
