package com.example.jecpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
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

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })
    }
}


@Composable
fun ConstraintBarrier(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxBlue,boxGreen,boxYellow) = createRefs()
        val barrier = createEndBarrier(boxBlue,boxGreen)


        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(parent.start, margin = 16.dp)
            })
        Box(modifier = Modifier
            .size(235.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxBlue.bottom)
                start.linkTo(boxBlue.start, margin = 32.dp)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(barrier)
            }) {

        }
    }
}



@Composable
fun ConstraintChainExample(){
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxBlue,boxGreen,boxYellow) = createRefs()


        Box(modifier = Modifier
            .size(85.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(parent.start)
                end.linkTo(boxGreen.start)
            })
        Box(modifier = Modifier
            .size(85.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(boxBlue.end)
                end.linkTo(boxYellow.start)
            })

        Box(modifier = Modifier
            .size(85.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(boxGreen.end)
                end.linkTo(parent.end)
            })

        createHorizontalChain(boxBlue,boxGreen,boxYellow, chainStyle = ChainStyle.Packed)
    }


}

@Preview
@Composable
fun ConstraintChainExample2(){
    ConstraintLayout(Modifier.fillMaxSize()){
        val (boxBlue,boxGreen,boxYellow) = createRefs()


        Box(modifier = Modifier
            .size(85.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue)
            {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        Box(modifier = Modifier
            .size(85.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(boxBlue.start)
                end.linkTo(boxYellow.end)
            })

        Box(modifier = Modifier
            .size(85.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(boxGreen.start)
                end.linkTo(parent.end)
            })

        createVerticalChain(boxBlue,boxGreen,boxYellow, chainStyle = ChainStyle.Packed)
    }
}
