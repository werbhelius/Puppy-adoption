package com.example.androiddevchallenge.ui.puppys

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.components.StaggeredVerticalGrid
import com.example.androiddevchallenge.utils.NetworkImage

/**
 * Created by wanbo on 2021/2/27.
 */

@Composable
fun PuppyApp() {

    val viewModel = viewModel<PuppyViewModel>()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        PuppyAppBar()
        PuppyGridList(puppys = viewModel.puppies)
    }
}

@Preview
@Composable
fun PuppyAppBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)) {
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
                .align(Alignment.CenterVertically))
    }
}

@Composable
fun PuppyGridList(puppys: List<Puppy>) {
    StaggeredVerticalGrid(
        maxColumnWidth = 220.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        puppys.forEach { puppy ->
            PuppyItem(puppy)
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(4.dp),
        elevation = 2.dp
    ) {
        Column {
            NetworkImage(url = puppy.imageUrl, modifier = Modifier
                .fillMaxWidth()
                .height(173.dp))

            Column(modifier = Modifier.padding(16.dp, 14.dp, 16.dp, 10.dp)) {
                Text(text = puppy.name)
            }
        }
    }
}