package com.example.jecpackcomposecatalogo.ui

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jecpackcomposecatalogo.R
import com.example.jecpackcomposecatalogo.model.SuperHero

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("erix", "javier", "Mendoza", "Acosta")
    LazyColumn {
        item { Text(text = "Primer Item") }
        items(7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "hola me llamo $it")
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero)
            {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
            }

        }

    }

}

@OptIn
@Composable
fun SuperHeroGriDView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero)
            {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
            }

        }
    }, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp))


}

@Composable
fun SuperHeroSpecialControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) { superhero ->
                ItemHero(superhero = superhero)
                { Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show() }
            }

        }



        Button(
            onClick = { },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        ) {
            Text(text = "soy un button cool")
        }
    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superhero: Map<String, List<SuperHero>> = getSuperHeroes().groupBy { it.publisher }


    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superhero.forEach { (publisher, mysuperHero) ->

            stickyHeader {
                Text(
                    text = publisher, modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            items(mysuperHero) { superhero ->
                ItemHero(superhero = superhero)
                {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
                }

            }
        }

    }

}


@Composable
fun ItemHero(superhero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, color = Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemSelected(superhero)
            }) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "super hero avatar",
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )

            Text(
                text = superhero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)

            )
        }

    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce  wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
    )
}