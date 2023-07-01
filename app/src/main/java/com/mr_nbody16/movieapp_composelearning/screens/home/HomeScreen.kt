package com.mr_nbody16.movieapp_composelearning.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mr_nbody16.movieapp_composelearning.model.Movie
import com.mr_nbody16.movieapp_composelearning.model.getMovies
import com.mr_nbody16.movieapp_composelearning.navigation.MovieScreens
import com.mr_nbody16.movieapp_composelearning.widget.MovieItemRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movies") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Magenta)
            )
        },
    ) {
        MainContent(navController , it)
    }
}

@Composable
fun MainContent(
    navController: NavController ,
    paddingValues: PaddingValues,
    moviesList: List<Movie> = getMovies()
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        LazyColumn() {
            items(moviesList) { item ->
                MovieItemRow(movie = item) { selectedMovie ->
                    Log.i("mTAG", "MainContent: $selectedMovie")
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$selectedMovie")
                }
            }
        }
    }
}