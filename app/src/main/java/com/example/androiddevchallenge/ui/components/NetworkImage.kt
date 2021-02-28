/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
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
    placeholderColor: Color? = if (isSystemInDarkTheme()) MaterialTheme.colors.surface.copy(alpha = 0.8f) else Color_D8D8D8
) {
    CoilImage(
        data = url,
        modifier = modifier,
        contentDescription = null,
        contentScale = contentScale,
        loading = {
            if (placeholderColor != null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(placeholderColor)
                ) {
                    Text(text = "🐶", modifier = Modifier.align(Alignment.Center), style = TextStyle(fontSize = 36.sp))
                }
            }
        }
    )
}
