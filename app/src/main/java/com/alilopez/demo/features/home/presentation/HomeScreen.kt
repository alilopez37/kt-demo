package com.alilopez.demo.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alilopez.demo.R
import com.alilopez.demo.features.jsonplaceholder.presentation.viewmodels.PostsViewModel

@Composable
fun HomeScreen(
    onClickRick: () -> Unit,
    onClickJson: () -> Unit) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("App DEMO",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(30.dp))
        Row(modifier = Modifier.padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                onClick = onClickRick,
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(16.dp),
                shadowElevation = 8.dp,
                modifier = Modifier.size(150.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rickandmorty),
                    contentDescription = "Rick And Morty",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.size(50.dp))
            Surface(
                onClick = onClickJson,
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(16.dp),
                shadowElevation = 8.dp,
                modifier = Modifier.size(150.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.json),
                    contentDescription = "Json Place Holder",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}