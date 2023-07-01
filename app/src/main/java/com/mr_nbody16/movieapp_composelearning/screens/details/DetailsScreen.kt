package com.mr_nbody16.movieapp_composelearning.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.mr_nbody16.movieapp_composelearning.model.getMovies
import com.mr_nbody16.movieapp_composelearning.widget.MovieItemRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {

    val movieFilter = getMovies().filter {
        it.id == movieId
    }

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
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            
            MovieItemRow(movieFilter.first())
            
            Spacer(modifier = Modifier.height(30.dp))
            
            LazyRow{
                items(movieFilter.first().images) {image ->
                    Card(modifier = Modifier
                        .padding(12.dp)
                        .size(240.dp) ,
                    elevation = CardDefaults.cardElevation(5.dp)) {
                        Image(painter = rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current)
                            .data(image)
                            .crossfade(true)
                            .build()), contentDescription = "Movie Images" , alignment = Alignment.Center)

                    }
                }
            }
        }
    }
}