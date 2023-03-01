package com.example.jecpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jecpackcomposecatalogo.model.Routes
import com.example.jecpackcomposecatalogo.ui.theme.JecpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JecpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //  modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.route
                    ) {
                        composable(Routes.Pantalla1.route) { Screen1(navigationController) }
                        composable(Routes.Pantalla2.route) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.route) { Screen3(navigationController) }
                        composable(
                            Routes.Pantalla4.route,
                            arguments = listOf(navArgument("age") {
                                type = NavType.IntType
                            })
                        ) { backStackEntry ->
                            backStackEntry.arguments?.getInt("age")?.let {
                                Screen4(
                                    navigationController,
                                    it
                                )
                            }
                        }
                        composable(
                            Routes.Pantalla5.route,
                            arguments = listOf(navArgument("name") {
                                defaultValue = ""
                            })
                        )
                        { backStackEntry ->
                            backStackEntry.arguments?.getString("name")?.let {
                                Screen5(
                                    navigationController,
                                    it
                                )
                            }
                        }


                    }
                }
                //    var myText by remember { mutableStateOf("") }
                //    val mypOtions = getOptions(listOf("Code", "Example", "Check"))
                //  var selected by rememberSaveable { mutableStateOf("codeMendozaa") }

/*   Column {

      MyTextField(myText) { myText = it }
       MyTriStatusCheckBox()
       mypOtions.forEach {
           MyCheckBoxWithTextCompleted(it)
       }*/

                //  var show by rememberSaveable { mutableStateOf(false) }
                //Dialog Basic
                /* Box(
                     modifier = Modifier.fillMaxSize(),
                     contentAlignment = Alignment.Center
                 ) {
                     Button(onClick = { show = true }) {
                         Text(text = "Mostrar Dialogo")
                     }
                     MyAlertDialog(
                         show = show,
                         onDismiss = { show = false },
                         onConfirm = { Log.i("codeMendoza", "Click") })*/

                //MySimpleCustomDialog
// Box(
// modifier = Modifier.fillMaxSize(),
// contentAlignment = Alignment.Center
// ) {
// Button(onClick = { show = true }) {
// Text(text = "Mostrar DialogCustom")
// }
// /*  MySimpleCustomDialog(
// show = show,
// onDismiss = { show = false },
// )
// MyConfirmationDialog(show = show,
// onDismiss = { show = false })*/
//
                //  ScaffoldExample()
//
// }
// }
// }
//
// }
// }
// }
// }
//
//
// @Composable
// fun getOptions(title: List<String>): List<CheckInfo> {
// return title.map {
// var status by rememberSaveable { mutableStateOf(false) }
// CheckInfo(
// it,
// status,
// ) { myNewStatus -> status = myNewStatus }
// }
//
//
// }
//
// @Composable
// fun MyComplexLayout() {
// Column(Modifier.fillMaxSize()) {
// Box(
// Modifier
// .fillMaxWidth()
// .weight(1f)
// .background(Color.Blue), contentAlignment = Alignment.TopCenter
// ) {
// Text(text = "Hi I am Codemendozaa")
// }
// MySpace(30)
//
// Row(
// Modifier
// .fillMaxWidth()
// .weight(1f)
// ) {
// Box(
// Modifier
// .weight(1f)
// .fillMaxHeight()
// .background(Color.Red), contentAlignment = Alignment.Center
// ) {
// Text(text = "Hi I am Codemendozaa")
// }
// Box(
// Modifier
// .weight(1f)
// .fillMaxHeight()
// .background(Color.LightGray), contentAlignment = Alignment.Center
// ) {
// Text(text = "Hi I am Codemendozaa")
// }
// }
// MySpace(size = 80)
//
// Box(
// Modifier
// .fillMaxWidth()
// .weight(1f)
// .background(Color.Cyan), contentAlignment = Alignment.BottomCenter
// ) {
// Text(text = "Hi I am Codemendozaa")
// }
//
// }
// }
//
// @Composable
// fun MySpace(size: Int) {
// Spacer(modifier = Modifier.height(size.dp))
//
// }
//
// @Composable
// fun MyRow() {
// Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
// Text(text = "example 1")
// Text(text = "example 2")
// Text(text = "example 3")
// }
// }
//
// @Composable
// fun MyColumn() {
// Column(
// modifier = Modifier
// .fillMaxSize()
// .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
// ) {
// Text(
// text = "This is an example", modifier = Modifier
// .background(Color.Cyan)
// .fillMaxWidth()
// .height(100.dp)
// )
// Text(
// text = "This is an example", modifier = Modifier
// .background(Color.Blue)
// .fillMaxWidth()
// .height(100.dp)
// )
// Text(
// text = "This is an example", modifier = Modifier
// .background(Color.Gray)
// .fillMaxWidth()
// .height(100.dp)
// )
// Text(
// text = "This is an example", modifier = Modifier
// .background(Color.Red)
// .fillMaxWidth()
// .height(100.dp)
// )
//
// }
// }
//
// @Composable
// fun MyBox() {
// Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
// Box(
// modifier = Modifier
// .width(50.dp)
// .height(50.dp)
// .background(Color.Cyan)
// .verticalScroll(rememberScrollState()), contentAlignment = Alignment.BottomCenter
// ) {
// Text(text = "This is an example")
// }
// }
// }
//
// @Composable
// fun MyStateExample() {
// var counter by rememberSaveable { mutableStateOf(0) }
// Column(
// Modifier.fillMaxSize(),
// verticalArrangement = Arrangement.Center,
// horizontalAlignment = Alignment.CenterHorizontally
// ) {
// Button(onClick = { counter += 1 }) {
// Text(text = "Click")
// }
// Text(text = "He sido pulsado $counter veces")
//
// }
// }
//
//
// @Composable
// fun MyText() {
// Column(Modifier.fillMaxSize()) {
// Text(text = "This is an example")
// Text(text = "This is an example", color = Color.Red)
// Text(text = "This is an example", fontWeight = FontWeight.ExtraBold)
// Text(text = "This is an example", fontWeight = FontWeight.Light)
// Text(text = "This is an example", fontFamily = FontFamily.Cursive)
// Text(text = "This is an example", textDecoration = TextDecoration.LineThrough)
// Text(text = "This is an example", textDecoration = TextDecoration.Underline)
// Text(
// text = "This is an example", textDecoration = TextDecoration.combine(
// listOf(TextDecoration.LineThrough, TextDecoration.Underline)
// )
// )
// Text(text = "This is an example", fontSize = 30.sp)
// }
//
// }
//
// @Composable
// fun MyTextField(name: String, onvalueChanged: (String) -> Unit) {
//
//
// TextField(value = name, onValueChange = { onvalueChanged(it) })
//
// }
//
// @Composable
// fun MytextFieldAdvance() {
// var myText by remember { mutableStateOf("") }
// TextField(value = myText, onValueChange = {
// myText = if (it.contains("e")) {
// it.replace("e", "")
// } else
// it
// },
// label = { Text(text = "Escribe tu Nombre") })
// }
//
// @Composable
// fun MytextFieldOutLine() {
// var myText by remember { mutableStateOf("") }
// OutlinedTextField(
// value = myText,
// onValueChange = { myText = it },
// modifier = Modifier.padding(24.dp),
// label = { Text(text = "Hi") },
// colors = TextFieldDefaults.outlinedTextFieldColors(
// focusedBorderColor = Color.Green,
// unfocusedBorderColor = Color.Blue
// )
// )
// }
//
// @Composable
// fun MyButtonExample() {
// var enabled by rememberSaveable { mutableStateOf(true) }
// Column(
// Modifier
// .fillMaxSize()
// .padding(24.dp)
// ) {
// Button(
// onClick = { enabled = false },
// enabled = false,
// colors = ButtonDefaults.buttonColors(
// backgroundColor = Color.Green,
// contentColor = Color.Red
// ),
// border = BorderStroke(5.dp, color = Color.Gray)
// ) {
// Text(text = "Hi")
// }
// OutlinedButton(
// onClick = { enabled = false },
// enabled = false,
// modifier = Modifier.padding(top = 5.dp),
// colors = ButtonDefaults.buttonColors(
// backgroundColor = Color.Green,
// contentColor = Color.Red,
// disabledBackgroundColor = Color.Transparent,
// disabledContentColor = Color.Blue
// )
// ) {
// Text(text = "Hola")
// }
//
// TextButton(onClick = { /*TODO*/ }) {
// Text(text = "soy un text button")
// }
// }
//
// }
//
// @Composable
// fun MyImage() {
// Image(
// painter = painterResource(id = R.drawable.ic_launcher_background),
// contentDescription = "",
// alpha = 0.5f
// )
// }
//
// @Composable
// fun MyImageAdvanced() {
// Image(
// painter = painterResource(id = R.drawable.ic_launcher_background),
// contentDescription = "",
// //modifier = Modifier.clip(RoundedCornerShape(25f))
// modifier = Modifier
// .clip(CircleShape)
// .border(5.dp, Color.Blue, CircleShape)
// )
// }
//
// @Composable
// fun MyIcon() {
// Icon(
// imageVector = Icons.Rounded.Star,
// contentDescription = "Icon",
// tint = Color.Green
// )
// }
//
// @Composable
// fun MyProgress() {
// var showLoading by rememberSaveable { mutableStateOf(false) }
// Column(
// Modifier
// .padding(24.dp)
// .fillMaxSize(),
// verticalArrangement = Arrangement.Center,
// horizontalAlignment = Alignment.CenterHorizontally
// )
// {
// if (showLoading) {
// CircularProgressIndicator(color = Color.Green, strokeWidth = 8.dp)
// LinearProgressIndicator(
// modifier = Modifier.padding(top = 32.dp),
// color = Color.Red,
// backgroundColor = Color.Blue
// )
// }
// Button(onClick = { showLoading = !showLoading }) {
// Text(text = "Cargando...")
// }
//
//
// }
// }
//
// @Composable
// fun MyProgessBarAdvance() {
// var progressStatus by rememberSaveable { mutableStateOf(0f) }
// Column(
// Modifier.fillMaxSize(),
// verticalArrangement = Arrangement.Center,
// horizontalAlignment = Alignment.CenterHorizontally
// ) {
// CircularProgressIndicator(progress = progressStatus)
// Row(Modifier.fillMaxSize()) {
// Button(onClick = { progressStatus += 0.1f }) {
// Text(text = "Incrementar")
//
// }
// Button(onClick = { progressStatus -= 0.1f }) {
// Text(text = "Reducir")
//
// }
// }
// }
// }
//
// @Composable
// fun MySwitch() {
// var state by rememberSaveable { mutableStateOf(false) }
// Switch(
// checked = state,
// onCheckedChange = { state = !state },
// enabled = true,
// colors = SwitchDefaults.colors(
// checkedThumbColor = Color.Green,
// uncheckedThumbColor = Color.Red,
// uncheckedTrackColor = Color.Cyan,
// checkedTrackColor = Color.Red,
// uncheckedTrackAlpha = 1.0f,
// checkedTrackAlpha = 1.0f,
// disabledCheckedTrackColor = Color.Blue,
// disabledCheckedThumbColor = Color.Green,
// disabledUncheckedThumbColor = Color.Gray,
// disabledUncheckedTrackColor = Color.Blue
//
// )
// )
//
// }
//
// @Composable
// fun MyCheckBox() {
// var state by rememberSaveable { mutableStateOf(false) }
// Checkbox(
// checked = state,
// onCheckedChange = { state = !state },
// enabled = true,
// colors = CheckboxDefaults.colors(
// checkedColor = Color.Green,
// uncheckedColor = Color.Gray,
// checkmarkColor = Color.Black
// )
// )
//
// }
//
// @Composable
// fun MyCheckBoxWithText() {
// var state by rememberSaveable { mutableStateOf(false) }
//
// Row(Modifier.padding(8.dp)) {
// Checkbox(
// checked = state,
// onCheckedChange = { state = !state })
// Spacer(modifier = Modifier.width(8.dp))
// Text(text = "Example 1", Modifier.padding(top = 10.dp))
//
// }
//
// }
//
// @Composable
// fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
//
// Row(Modifier.padding(8.dp)) {
// Checkbox(
// checked = checkInfo.selected,
// onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
// Spacer(modifier = Modifier.width(8.dp))
// Text(text = checkInfo.title, Modifier.padding(top = 10.dp))
//
// }
//
// }
//
// @Composable
// fun MyTriStatusCheckBox() {
// var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
// TriStateCheckbox(state = status, onClick = {
// status = when (status) {
// ToggleableState.On -> ToggleableState.Off
// ToggleableState.Off -> ToggleableState.Indeterminate
// ToggleableState.Indeterminate -> ToggleableState.On
// }
// })
// }
//
// @Composable
// fun MyRadioButton() {
// Row(Modifier.fillMaxWidth()) {
// RadioButton(
// selected = true,
// onClick = { },
// enabled = true,
// colors = RadioButtonDefaults.colors(
// selectedColor = Color.Red,
// unselectedColor = Color.Yellow,
// disabledColor = Color.Gray
// )
// )
// Text(text = "Example", Modifier.padding(top = 12.dp))
// }
//
// }
//
// @Composable
// fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {
// Column(Modifier.fillMaxWidth()) {
// Row {
// RadioButton(
// selected = name == "Example List 1",
// onClick = { onItemSelected("Example List 1") })
// Text(text = "Example List 1", Modifier.padding(top = 12.dp))
// }
// Row {
// RadioButton(name == "Example List 2", onClick = { onItemSelected("Example List 2") })
// Text(text = "Example List 2", Modifier.padding(top = 12.dp))
// }
// Row {
// RadioButton(name == "Example List 3", onClick = { onItemSelected("Example List 3") })
// Text(text = "Example List 3", Modifier.padding(top = 12.dp))
// }
// /*Row {
// RadioButton(name == "Example List 4", onClick = { onItemSelected("Example List 4") })
// Text(text = "Example List 4", Modifier.padding(top = 12.dp))
// }*/
// }
// }
//
// @Composable
// fun MyCard() {
// Card(
// modifier = Modifier
// .fillMaxWidth()
// .padding(16.dp),
// elevation = 12.dp,
// shape = MaterialTheme.shapes.medium,
// backgroundColor = Color.Blue,
// contentColor = Color.LightGray
// ) {
// Column(modifier = Modifier.padding(16.dp)) {
// Text(text = "Example..")
// Text(text = "Example..")
// Text(text = "Example..")
// }
//
//
// }
// }
//
// @OptIn(ExperimentalMaterialApi::class)
// @Composable
// fun MyBadgeBox() {
// BadgedBox(
// badge = { Badge { Text("8", Modifier.background(Color.Yellow), color = Color.Black) } },
// Modifier
// .padding(16.dp)
// .background(Color.Green)
//
//
// ) {
// Icon(
// imageVector = Icons.Default.Star,
// contentDescription = "",
//
// )
// }
// }
//
//
// @Composable
// fun MyDivider() {
// Divider(
// Modifier
// .fillMaxWidth()
// .padding(top = 16.dp), color = Color.Red
// )
// }
//
// @Composable
// fun MyDropdownMenu() {
// var selectedText by rememberSaveable { mutableStateOf("") }
// var expanded by rememberSaveable { mutableStateOf(false) }
// val desserts = listOf("Cafe", "Helado", "Chocolate", "Fruta", "Natilla")
// Column(Modifier.padding(20.dp)) {
// OutlinedTextField(
// value = selectedText,
// onValueChange = { selectedText = it },
// enabled = false,
// readOnly = true,
// modifier = Modifier
// .clickable { expanded = true }
// .fillMaxWidth()
// )
// DropdownMenu(
// expanded = expanded,
// onDismissRequest = { expanded = false },
// Modifier.fillMaxWidth()
// ) {
// desserts.forEach { dessert ->
// DropdownMenuItem(onClick = {
// expanded = false
// selectedText = dessert
// }) {
// Text(text = dessert)
// }
// }
// }
//
// }
// }

            }
        }
    }
}

// @Preview(showBackground = true)
// @Composable
// fun DefaultPreview() {
// JecpackComposeCatalogoTheme {
// MyDropdownMenu()
