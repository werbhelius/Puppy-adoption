package com.example.androiddevchallenge.ui.puppys

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.ColorFilter
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.components.StaggeredVerticalGrid
import com.example.androiddevchallenge.ui.theme.Color_000000
import com.example.androiddevchallenge.utils.NetworkImage

/**
 * Created by wanbo on 2021/2/27.
 */

@Composable
fun PuppyApp(vm: PuppyViewModel = PuppyViewModel()) {

    val isGrid: Boolean by vm.isGrid.observeAsState(true)

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        PuppyAppBar(isGrid, vm::onGridChanged)
        PuppyGridList(puppys = vm.puppies, isGrid = isGrid)
    }
}

@Composable
fun PuppyAppBar(isGrid: Boolean, onGridChanged:(Boolean) -> Unit) {
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
            painter = painterResource(id = if (isGrid) R.drawable.ic_baseline_grid else R.drawable.ic_view_list ),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary)
        )

    }
}

@Composable
fun PuppyGridList(puppys: List<Puppy>, isGrid: Boolean) {
    StaggeredVerticalGrid(
        maxColumnWidth = if (isGrid) 220.dp else 800.dp,
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
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(4.dp),
        elevation = 2.dp
    ) {
        Column {
            NetworkImage(
                url = puppy.imageUrl, modifier = Modifier
                    .fillMaxWidth()
                    .height(173.dp)
            )

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