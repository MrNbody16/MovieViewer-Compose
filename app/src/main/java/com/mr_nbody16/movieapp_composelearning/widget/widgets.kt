package com.mr_nbody16.movieapp_composelearning.widget

import android.text.Html.ImageGetter
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.mr_nbody16.movieapp_composelearning.model.Movie
import com.mr_nbody16.movieapp_composelearning.model.getMovies


@Preview
@Composable
fun MovieItemRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick.invoke(movie.id)
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp)
            ) {
//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "MovieImages")
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(movie.images[0])
                            .crossfade(true)
                            .build()
                    ), contentDescription = "MoviePoster"
                )
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = movie.title, style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Director : ${movie.director}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Released : ${movie.year}",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}