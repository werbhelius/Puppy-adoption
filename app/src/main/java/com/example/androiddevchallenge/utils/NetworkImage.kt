package com.example.androiddevchallenge.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.example.androiddevchallenge.ui.theme.Color_D8D8D8
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Created by wanbo on 2021/2/27.
 */
@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    placeholderColor: Color? = Color_D8D8D8
) {
    CoilImage(
        data = url,
        modifier = modifier,
        contentDescription = null,
        contentScale = contentScale,
        fadeIn = true,
        loading = {
            if (placeholderColor != null) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(placeholderColor)) {
                    Text(text = "🐶", modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    )
}