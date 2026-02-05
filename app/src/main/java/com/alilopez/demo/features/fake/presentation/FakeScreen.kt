package com.alilopez.demo.features.fake.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FakeScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.surface)) {
        LazyColumn() {
            items(16){ it ->
                Row(modifier = Modifier
                    .height(100.dp)) {
                    Text("$it")
                }
            }
        }
    }
}

@Preview
@Composable
fun FakeScreenPreview() {
    FakeScreen()
}