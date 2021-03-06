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
package com.example.androiddevchallenge.ui.puppys

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.components.NetworkImage
import com.example.androiddevchallenge.ui.components.StaggeredVerticalGrid

/**
 * Created by wanbo on 2021/2/27.
 */

@Composable
fun PuppyList(selectPuppy: (String) -> Unit, vm: PuppyViewModel) {

    val isGrid: Boolean by vm.isGrid.observeAsState(vm.isGrid.value!!)

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        PuppyAppBar(isGrid, vm::onGridChanged)
        PuppyGridList(puppys = vm.puppies, isGrid = isGrid, selectPuppy = selectPuppy, vm::onPuppyAdoption)
    }
}

@Composable
fun PuppyAppBar(isGrid: Boolean, onGridChanged: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Image(
            modifier = Modifier
                .absolutePadding(left = 16.dp)
                .align(Alignment.CenterVertically)
                .size(36.dp),
            painter = painterResource(id = R.drawable.ic_puppy),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .absolutePadding(left = 16.dp)
                .align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier
                .absolutePadding(right = 16.dp)
                .align(Alignment.CenterVertically)
                .clickable {
                    onGridChanged(!isGrid)
                },
            painter = painterResource(id = if (isGrid) R.drawable.ic_baseline_grid else R.drawable.ic_grid_off),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary)
        )
    }
}

@Composable
fun PuppyGridList(puppys: List<Puppy>, isGrid: Boolean, selectPuppy: (String) -> Unit, adoptionPuppy: (Puppy) -> Unit) {
    StaggeredVerticalGrid(
        maxColumnWidth = if (isGrid) 220.dp else 800.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        puppys.forEach { puppy ->
            PuppyItem(puppy, selectPuppy, adoptionPuppy)
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy, selectPuppy: (String) -> Unit, adoptionPuppy: (Puppy) -> Unit) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(4.dp)
            .clickable { selectPuppy(puppy.id) },
        elevation = 2.dp
    ) {
        Column {

            Box {
                NetworkImage(
                    url = puppy.imageUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(173.dp)
                )
                IconButton(
                    onClick = { adoptionPuppy(puppy.copy(isAdoption = !puppy.isAdoption)) },
                    modifier = Modifier
                        .zIndex(8f)
                        .align(Alignment.TopStart)
                        .padding(start = 0.dp)
                ) {
                    Icon(imageVector = if (puppy.isAdoption) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder, contentDescription = null)
                }
            }

            Column(modifier = Modifier.padding(16.dp, 14.dp, 16.dp, 12.dp)) {
                Text(
                    text = puppy.name,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                PuppyLabel(labels = puppy.labels())
            }
        }
    }
}

@Composable
fun PuppyLabel(labels: List<String>) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
    ) {
        labels.forEach { label ->
            Surface(
                border = BorderStroke(2.dp, MaterialTheme.colors.primary),
                color = MaterialTheme.colors.primary.copy(alpha = 0.08f),
                modifier = Modifier.absolutePadding(right = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(32.dp)
                        .padding(10.dp, 6.dp),
                ) {
                    Text(
                        label,
                        modifier = Modifier.align(Alignment.Center),
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        }
    }
}
