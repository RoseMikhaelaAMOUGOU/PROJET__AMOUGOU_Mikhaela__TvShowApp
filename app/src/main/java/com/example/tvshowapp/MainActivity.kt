

package com.example.tvshowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.tvshowapp.ui.theme.TvShowAppTheme
import com.example.tvshowapp.view.TvShowAppNav
import com.example.tvshowapp.viewmodel.TvShowViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: TvShowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvShowAppTheme {
                TvShowAppNav(viewModel = viewModel)
            }
        }
    }
}
