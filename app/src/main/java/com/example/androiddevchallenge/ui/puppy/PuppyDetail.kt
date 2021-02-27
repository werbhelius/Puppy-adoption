package com.example.androiddevchallenge.ui.puppy

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cabin
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.twotone.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.Sex
import com.example.androiddevchallenge.model.format
import com.example.androiddevchallenge.ui.components.NetworkImage
import com.example.androiddevchallenge.ui.puppys.PuppyLabel
import com.example.androiddevchallenge.ui.puppys.PuppyViewModel
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Created by wanbo on 2021/2/27.
 */

@Composable
fun PuppyDetail(puppyID: String, upPress: () -> Unit, vm: PuppyViewModel) {

    val puppy = remember(puppyID) { vm.puppies.first { it.id == puppyID } }

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

            NetworkImage(url = puppy.imageUrl, modifier = Modifier
                .fillMaxHeight(fraction = 0.45f)
                .fillMaxWidth())

            Card(
                elevation = if (MaterialTheme.colors.isLight) 8.dp else 0.dp,
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(text = "Hi I am ${puppy.name}", style = MaterialTheme.typography.h1, color = MaterialTheme.colors.onSurface)
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        item { PuppyLabel(icon = "🐶", text = puppy.type.desc) }
                        item { PuppyLabel(icon = "🎂", text = "${puppy.age.format()} years") }
                        item { PuppyLabel(icon = "💪", text = "${puppy.weight.format()} kg") }
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        item { PuppyLabel(icon = if(puppy.sex == Sex.FEMALE) "👨" else "👩", text = puppy.sex.desc) }
                        item { PuppyLabel(icon = "🎨", text = puppy.color) }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = "About Me", style = MaterialTheme.typography.h1, color = MaterialTheme.colors.onSurface)
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = "I am a cute puppy. I want to find a master who can take care of me. I am very good, obedient, and very smart. I like that I can be good friends with you.",
                        style = MaterialTheme.typography.body2, color = MaterialTheme.colors.onSurface.copy(0.7f))
                }
            }

        }

        AdoptPuppyButton(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            onClick = { /*TODO*/ }
        )
    }
}

@Composable
private fun AdoptPuppyButton(modifier: Modifier, onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Rounded.Favorite, contentDescription = null) },
        text = { Text(text = "ADOPTION", style = MaterialTheme.typography.button, color = MaterialTheme.colors.onPrimary) },
        onClick = onClick,
        modifier = modifier
            .padding(24.dp),
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 2.dp, pressedElevation = 6.dp),
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
            Text(text = text, style = MaterialTheme.typography.body2, color = MaterialTheme.colors.onPrimary)
        }
    }
}