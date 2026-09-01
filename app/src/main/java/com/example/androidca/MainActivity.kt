package com.example.androidca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidca.R
import com.example.androidca.ui.theme.AndroidCATheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidCATheme() {
                ExploreRestaurantMenu()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreRestaurantMenu() {

    var showSheet by remember {
        mutableStateOf(false)
    }
    val sheetState =
        rememberModalBottomSheetState()
    var selectedFood by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 50.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Restaurant Menu",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Pizza",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.background(Color.LightGray)
                .fillMaxWidth()
                .clickable {
                    selectedFood = "Pizza"
                    showSheet = true
                }
                .padding(20.dp)
        )
        Text(
            text = "Burger",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.background(Color.LightGray)
                .fillMaxWidth()
                .clickable {
                    selectedFood = "Burger"
                    showSheet = true
                }
                .padding(20.dp)
        )
        Text(
            text = "Pasta",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.background(Color.LightGray)
                .fillMaxWidth()
                .clickable {
                    selectedFood = "Pasta"
                    showSheet = true
                }
                .padding(20.dp)
        )
    }
    if (showSheet) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                showSheet = false
            }
        ) {
            when (selectedFood) {
                "Pizza" -> {
                    Image(
                        painter = painterResource(R.drawable.pizza),
                        contentDescription = "Pizza",
                        modifier = Modifier.size(200.dp).padding(10.dp)
                    )
                    Text(text = "Pizza", style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Price: ₹299", style = MaterialTheme.typography.headlineMedium)
                }
                "Burger" -> {
                    Image(
                        painter = painterResource(R.drawable.burger),
                        contentDescription = "Burger",
                        modifier = Modifier.size(200.dp).padding(10.dp)
                    )
                    Text(text = "Burger", style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Price: ₹199", style = MaterialTheme.typography.headlineMedium)
                }
                "Pasta" -> {
                    Image(
                        painter = painterResource(R.drawable.pasta),
                        contentDescription = "Pasta",
                        modifier = Modifier.size(200.dp).padding(10.dp)
                    )
                    Text(text = "Pasta",style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Price: ₹249", style = MaterialTheme.typography.headlineMedium)
                }
            }
            Button(
                onClick = {
                    scope.launch {
                        sheetState.hide()
                        showSheet = false
                    }
                }
            ) {
                Text("Close")
            }
        }
    }
}

