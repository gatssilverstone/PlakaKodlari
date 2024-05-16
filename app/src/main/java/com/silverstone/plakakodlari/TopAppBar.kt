package com.example.composeilkdeneme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.silverstone.plakakodlari.BackGround
import com.silverstone.plakakodlari.R
//import com.silverstone.plakakodlari.icerik
import com.silverstone.plakakodlari.lazyCity



@SuppressLint("UnusedMaterial3SccafoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter", "ResourceType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBarTheme() {
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = " ") },
                modifier = Modifier
                    .clip(RoundedCornerShape(0.dp))
                    .height(70.dp)
                    .clip(RoundedCornerShape(0, 0, 15, 15)),
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(id = R.color.card_back)),


            )
            TextField(modifier = Modifier
                .clip(RoundedCornerShape(0, 0, 15, 15))
                .fillMaxWidth()
                .padding(10.dp)
                .height(50.dp),
                value = searchText,
                onValueChange = {searchText=it},
            placeholder = {Text(text = "Şehir veya Plaka Ara!")},
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "Arama zımbırtısı")
            })
        },

        content = {

            val padding = PaddingValues(top = 58.dp)

            BackGround {


                val cityList = listOf(
                    "01" to "Adana",
                    "02" to "Adıyaman",
                    "03" to "Afyon",
                    "04" to "Ağrı",
                    "05" to "Amasya",
                    "06" to "Ankara",
                    "07" to "Antalya",
                    "08" to "Artvin",
                    "09" to "Aydın",
                    "10" to "Balıkesir",
                    "11" to "Bilecik",
                    "12" to "Bingöl",
                    "13" to "Bitlis",
                    "14" to "Bolu",
                    "15" to "Burdur",
                    "16" to "Bursa",
                    "17" to "Çanakkale",
                    "18" to "Çankırı",
                    "19" to "Çorum",
                    "20" to "Denizli",
                    "21" to "Diyarbakır",
                    "22" to "Edirne",
                    "23" to "Elazığ",
                    "24" to "Erzincan",
                    "25" to "Erzurum",
                    "26" to "Eskişehir",
                    "27" to "Gaziantep",
                    "28" to "Giresun",
                    "29" to "Gümüşhane",
                    "30" to "Hakkari",
                    "31" to "Hatay",
                    "32" to "Isparta",
                    "33" to "Mersin",
                    "34" to "İstanbul",
                    "35" to "İzmir",
                    "36" to "Kars",
                    "37" to "Kastamonu",
                    "38" to "Kayseri",
                    "39" to "Kırklareli",
                    "40" to "Kırşehir",
                    "41" to "Kocaeli",
                    "42" to "Konya",
                    "43" to "Kütahya",
                    "44" to "Malatya",
                    "45" to "Manisa",
                    "46" to "K.Maraş",
                    "47" to "Mardin",
                    "48" to "Muğla",
                    "49" to "Muş",
                    "50" to "Nevşehir",
                    "51" to "Niğde",
                    "52" to "Ordu",
                    "53" to "Rize",
                    "54" to "Sakarya",
                    "55" to "Samsun",
                    "56" to "Siirt",
                    "57" to "Sinop",
                    "58" to "Sivas",
                    "59" to "Tekirdağ",
                    "60" to "Tokat",
                    "61" to "Trabzon",
                    "62" to "Tunceli",
                    "63" to "Şanlıurfa",
                    "64" to "Uşak",
                    "65" to "Van",
                    "66" to "Yozgat",
                    "67" to "Zonguldak",
                    "68" to "Aksaray",
                    "69" to "Bayburt",
                    "70" to "Karaman",
                    "71" to "Kırıkkale",
                    "72" to "Batman",
                    "73" to "Şırnak",
                    "74" to "Bartın",
                    "75" to "Ardahan",
                    "76" to "Iğdır",
                    "77" to "Yalova",
                    "78" to "Karabük",
                    "79" to "Kilis",
                    "80" to "Osmaniye",
                    "81" to "Düzce"

                )

                val filteredCityList = cityList.filter {
                    it.first.contains(searchText, ignoreCase = true) || // Şehir adında filtreleme
                            it.second.contains(searchText, ignoreCase = true) // Plaka kodunda filtreleme
                }
                lazyCity(cityData = filteredCityList)
              //  lazyCity(cityData = cityList)
            }

        }
    )
}
