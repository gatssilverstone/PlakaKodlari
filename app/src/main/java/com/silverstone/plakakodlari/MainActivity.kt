package com.silverstone.plakakodlari

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeilkdeneme.ToolBarTheme
import com.silverstone.plakakodlari.ui.theme.PlakaKodlariTheme
import com.silverstone.sehirplakakodlar.ui.theme.CityCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlakaKodlariTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ToolBarTheme ()
                }
            }
        }
    }
}


@SuppressLint("SuspiciousIndentation")
@Composable
fun BackGround(content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()){
        val imageResource = painterResource(R.drawable.arkaplan)
        Image(
            painter = imageResource,
            contentDescription = "Resim Açıklaması",
            contentScale = ContentScale.FillBounds    ,
            modifier = Modifier.matchParentSize())
        content()

    }

}
@Composable
fun lazyCity(cityData:List<Pair<String, String>>){
Column(modifier = Modifier.padding(top = 70.dp).fillMaxSize()) {
    LazyVerticalGrid(columns = GridCells.Fixed(3), content ={
        items(cityData){(plakaKodu,sehirAdi) -> CityCard(plakaKodu = plakaKodu, sehirAdi = sehirAdi) }

    } )
}

}
