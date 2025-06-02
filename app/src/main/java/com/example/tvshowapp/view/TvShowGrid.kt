package com.example.tvshowapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.tvshowapp.model.data.TvShow

@Composable
fun TvShowGrid(tvShows: List<TvShow>, onClick: (TvShow) -> Unit, isDarkTheme: Boolean) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDarkTheme) Color(0xFF0F1115) else Color.White)
    ) {
        items(tvShows) { show ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clickable { onClick(show) },
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDarkTheme) Color(0xFF1C1E24) else Color(0xFFF0F0F0)
                )
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                        Image(
                            painter = rememberAsyncImagePainter(show.imageThumbnailPath),
                            contentDescription = show.name,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        )
                    }
                    Text(
                        text = show.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        textAlign = TextAlign.Center,
                        color = if (isDarkTheme) Color.White else Color.Black,
                        fontSize = 16.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}








