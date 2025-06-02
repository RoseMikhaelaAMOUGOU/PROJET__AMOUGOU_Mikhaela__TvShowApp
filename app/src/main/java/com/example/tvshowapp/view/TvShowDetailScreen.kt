package com.example.tvshowapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.tvshowapp.model.data.TvShow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowDetailScreen(tvShow: TvShow, onBack: () -> Unit, isDarkTheme: Boolean) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = tvShow.name,
                        color = if (isDarkTheme) Color.White else Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = if (isDarkTheme) Color.White else Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = if (isDarkTheme) Color(0xFF0F1115) else Color.White
                )
            )
        },
        containerColor = if (isDarkTheme) Color(0xFF0F1115) else Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(tvShow.imageThumbnailPath),
                contentDescription = tvShow.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Text(
                text = tvShow.name,
                fontSize = 24.sp,
                color = if (isDarkTheme) Color.White else Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Status: ${tvShow.status} • Country: ${tvShow.country}",
                color = if (isDarkTheme) Color.LightGray else Color.DarkGray,
                fontSize = 16.sp
            )
        }
    }
}






