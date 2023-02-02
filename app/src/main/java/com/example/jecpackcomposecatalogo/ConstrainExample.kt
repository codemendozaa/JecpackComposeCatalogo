package com.example.jecpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout



@Composable
fun ConstrainExample1(){
    ConstraintLayout (modifier = Modifier.fillMaxSize()){
        val (boxBlue,boxRed,boxYellow,boxGray,boxMagenta) = createRefs() //createRefs en cuando hay mas de una referencia

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxBlue.bottom)
                end.linkTo(boxBlue.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                top.linkTo(boxBlue.bottom)
                start.linkTo(boxBlue.end)

            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxBlue.top)
                end.linkTo(boxBlue.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Gray)
            .constrainAs(boxGray) {
                bottom.linkTo(boxBlue.top)
                start.linkTo(boxBlue.end)
            })
    }
}


@Composable
fun ConstraintExampleGuide(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        //se puede utilizar en estas dos formas en dp y %
       // val startGuide = createGuidelineFromTop(16.dp)
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)
        val boxGreen = createRef() // este createRef es cuando se crea una sola referencia

        Box(modifier = Modifier.size(125.dp).background(Color.Green).constrainAs(boxGreen){
            top.linkTo(topGuide)
            start.linkTo(startGuide)
        })
    }
}
