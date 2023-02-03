package com.example.jecpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jecpackcomposecatalogo.ui.theme.JecpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JecpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MytextFieldAdvance()
                }
            }
        }
    }
}

@Composable
fun MyComplexLayout(){
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Blue),contentAlignment = Alignment.TopCenter) {
            Text(text = "Hi I am Codemendozaa")
        }
        MySpace(30)

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),contentAlignment = Alignment.Center){
                Text(text = "Hi I am Codemendozaa")
            }
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.LightGray),contentAlignment = Alignment.Center){
                Text(text = "Hi I am Codemendozaa")
            }
        }
        MySpace(size = 80)

        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),contentAlignment = Alignment.BottomCenter) {
            Text(text = "Hi I am Codemendozaa")
        }
        
    }
}

@Composable
fun MySpace(size:Int){
    Spacer(modifier = Modifier.height(size.dp))

}

@Composable
fun MyRow(){
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "example 1")
        Text(text = "example 2")
        Text(text = "example 3")
    }
}
@Composable
fun MyColumn(){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "This is an example", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "This is an example", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "This is an example", modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "This is an example", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))

    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState())
                , contentAlignment = Alignment.BottomCenter){
            Text(text = "This is an example")
        }
    }
}

@Composable
fun MyStateExample(){
    var counter by rememberSaveable(){mutableStateOf(0)}
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button( onClick = { counter +=1 }) {
            Text(text = "Click")
        }
        Text(text = "He sido pulsado $counter veces")
        
    }
}



@Composable
fun MyText(){
    Column(Modifier.fillMaxSize()) {
        Text(text = "This is an example")
        Text(text = "This is an example", color = Color.Red)
        Text(text = "This is an example", fontWeight = FontWeight.ExtraBold)
        Text(text = "This is an example", fontWeight = FontWeight.Light)
        Text(text = "This is an example", fontFamily = FontFamily.Cursive)
        Text(text = "This is an example", textDecoration = TextDecoration.LineThrough)
        Text(text = "This is an example", textDecoration = TextDecoration.Underline)
        Text(text = "This is an example", textDecoration = TextDecoration.combine(
            listOf(TextDecoration.LineThrough,TextDecoration.Underline)))
        Text(text = "This is an example", fontSize = 30.sp)
    }

}

@Composable
fun MyTextField(){
    var myText  by remember { mutableStateOf("") }

    TextField(value = myText, onValueChange = {myText = it})

}

@Composable
fun MytextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = {
        myText = if (it.contains("e")) {
            it.replace("e", "")
        } else
            it
    },
        label = { Text(text = "Escribe tu Nombre") })

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JecpackComposeCatalogoTheme {
        MytextFieldAdvance()
    }
}