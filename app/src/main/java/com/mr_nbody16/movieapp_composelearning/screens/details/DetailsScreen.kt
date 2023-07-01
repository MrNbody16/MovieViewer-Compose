package com.mr_nbody16.movieapp_composelearning.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mr_nbody16.movieapp_composelearning.screens.home.MainContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movie: String?) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Spacer(modifier = Modifier.width(32.dp))
                    Text(text = "Movies") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.LightGray),
                navigationIcon = {
                    Icon(modifier = Modifier.clickable {
                        navController.popBackStack()
                    }, imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back")
                }
            )
        },
    ) {
        Column(
            modifier = Modifier.padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Details Screen 4 $movie")

            Spacer(modifier = Modifier.height(150.dp))

            Button(onClick = {
                navController.popBackStack()
            }) {
                Text(text = "Go Back")
            }
        }
    }
}