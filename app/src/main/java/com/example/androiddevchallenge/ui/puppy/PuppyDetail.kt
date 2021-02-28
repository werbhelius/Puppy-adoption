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
package com.example.androiddevchallenge.ui.puppy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.Sex
import com.example.androiddevchallenge.model.format
import com.example.androiddevchallenge.ui.components.NetworkImage
import com.example.androiddevchallenge.ui.puppys.PuppyViewModel

/**
 * Created by wanbo on 2021/2/27.
 */

@Composable
fun PuppyDetail(puppyID: String, upPress: () -> Unit, vm: PuppyViewModel) {

    var puppy by mutableStateOf(vm.puppies.first { it.id == puppyID })

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { upPress() },
            modifier = Modifier
                .zIndex(8f)
                .align(Alignment.TopStart)
                .padding(start = 4.dp)
        ) {
            Icon(imageVector = Icons.TwoTone.ArrowBack, contentDescription = null)
        }

        Column {

            NetworkImage(
                url = puppy.imageUrl,
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.45f)
                    .fillMaxWidth()
            )

            Card(
                elevation = if (MaterialTheme.colors.isLight) 8.dp else 0.dp,
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                PuppyInfo(puppy = puppy)
            }
        }

        AdoptPuppyButton(
            puppy = puppy,
            modifier = Modifier
                .align(Alignment.BottomEnd),
            onClick = {
                puppy = puppy.copy(isAdoption = !puppy.isAdoption)
                vm.onPuppyAdoption(puppy)
            }
        )
    }
}

@Composable
fun PuppyInfo(puppy: Puppy) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = "Hi I am ${puppy.name}",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onSurface
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            item { PuppyLabel(icon = "🐶", text = puppy.type.desc) }
            item { PuppyLabel(icon = "🎂", text = "${puppy.age.format()} years") }
            item { PuppyLabel(icon = "💪", text = "${puppy.weight.format()} kg") }
        }
        Spacer(modifier = Modifier.height(14.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            item {
                PuppyLabel(
                    icon = if (puppy.sex == Sex.FEMALE) "👨" else "👩",
                    text = puppy.sex.desc
                )
            }
            item { PuppyLabel(icon = "🎨", text = puppy.color) }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "About Me",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onSurface
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "I am a cute puppy. I want to find a master who can take care of me. I am very good, obedient, and very smart. I like that I can be good friends with you.",
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSurface.copy(0.7f)
        )
    }
}

@Composable
fun AdoptPuppyButton(puppy: Puppy, modifier: Modifier, onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        icon = {
            Icon(
                if (puppy.isAdoption) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = null
            )
        },
        text = {
            Text(
                text = "ADOPTION",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onPrimary
            )
        },
        onClick = onClick,
        modifier = modifier
            .padding(24.dp),
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 2.dp,
            pressedElevation = 6.dp
        ),
        backgroundColor = MaterialTheme.colors.secondary
    )
}

@Composable
private fun PuppyLabel(icon: String, text: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 2.dp,
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .height(36.dp)
        ) {
            Text(text = icon, style = MaterialTheme.typography.body2)
            Spacer(Modifier.width(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}
