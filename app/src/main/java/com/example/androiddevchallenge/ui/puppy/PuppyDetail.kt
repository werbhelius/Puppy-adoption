package com.example.androiddevchallenge.ui.puppy

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.components.NetworkImage
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

        NetworkImage(url = puppy.imageUrl, modifier = Modifier
            .fillMaxHeight(fraction = 0.45f)
            .fillMaxWidth())

        Card(
            shape = MaterialTheme.shapes.large.copy(
                bottomStart = ZeroCornerSize,
                bottomEnd = ZeroCornerSize
            ),
            elevation = if (MaterialTheme.colors.isLight) 8.dp else 0.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxHeight(fraction = 0.60f)
        ) {

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
        text = { Text(text = "ADOPTION") },
        onClick = onClick,
        modifier = modifier
            .padding(24.dp),
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 2.dp, pressedElevation = 6.dp)
    )
}