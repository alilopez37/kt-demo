package com.alilopez.demo.features.factory.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alilopez.demo.features.factory.domain.GetFactoryUseCase
import com.alilopez.demo.features.factory.presentation.viewmodels.FactoryViewModel
import com.alilopez.demo.features.factory.presentation.viewmodels.FactoryViewModelFactory

@Composable
fun FactoryScreen(
    viewModel: FactoryViewModel = viewModel(
        factory = FactoryViewModelFactory(getFactoryUseCase = GetFactoryUseCase())
    )
) {
    val count by viewModel.count.collectAsStateWithLifecycle()
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text("$count",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Button(
            onClick = {viewModel.inc()},
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(horizontal = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text("Inc",
                style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Preview
@Composable
fun FactoryScreenPreview(){
    FactoryScreen()
}