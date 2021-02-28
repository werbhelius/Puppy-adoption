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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.Sex
import com.example.androiddevchallenge.model.TYPE

/**
 * Created by wanbo on 2021/2/27.
 */
class PuppyViewModel : ViewModel() {

    private val _isGrid = MutableLiveData(true)
    val isGrid: LiveData<Boolean> = _isGrid

    private var _puppies = listOf(
        Puppy(
            id = "Bella01",
            name = "Bella",
            age = 1.0,
            type = TYPE.ShihTzu,
            sex = Sex.MALE,
            color = "Brown",
            weight = 2.0,
            imageUrl = "https://images.unsplash.com/photo-1608096299210-db7e38487075?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80",
            isAdoption = false
        ),
        Puppy(
            id = "Daisy02",
            name = "Daisy",
            age = 1.3,
            type = TYPE.SpringerSpaniel,
            sex = Sex.FEMALE,
            color = "White&Black",
            weight = 3.0,
            imageUrl = "https://images.unsplash.com/photo-1604303766758-e9e7bd704fc4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80",
            isAdoption = false
        ),
        Puppy(
            id = "Molly03",
            name = "Molly",
            age = 0.8,
            type = TYPE.Pomeranian,
            sex = Sex.FEMALE,
            color = "White",
            weight = 2.0,
            imageUrl = "https://images.unsplash.com/photo-1587402092301-725e37c70fd8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80",
            isAdoption = false
        ),
        Puppy(
            id = "Sophie04",
            name = "Sophie",
            age = 2.0,
            type = TYPE.Beagle,
            sex = Sex.MALE,
            color = "Brown&White",
            weight = 3.0,
            imageUrl = "https://images.unsplash.com/photo-1611305366162-ce5d41340817?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80",
            isAdoption = false
        ),
        Puppy(
            id = "Coco05",
            name = "Coco",
            age = 1.5,
            type = TYPE.Terrier,
            sex = Sex.MALE,
            color = "White&Black",
            weight = 2.5,
            imageUrl = "https://images.unsplash.com/photo-1549775924-433bdc7ea7a9?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80",
            isAdoption = false
        ),
        Puppy(
            id = "Nala06",
            name = "Nala",
            age = 2.0,
            type = TYPE.Pug,
            sex = Sex.MALE,
            color = "Black",
            weight = 3.5,
            imageUrl = "https://images.unsplash.com/photo-1530041686259-53d26f863313?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80",
            isAdoption = false
        ),
        Puppy(
            id = "Abby07",
            name = "Abby",
            age = 1.0,
            type = TYPE.Maltese,
            sex = Sex.FEMALE,
            color = "White",
            weight = 1.5,
            imageUrl = "https://images.unsplash.com/photo-1577447310651-8453e529e838?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80",
            isAdoption = false
        )
    )

    var puppies: List<Puppy> by mutableStateOf(value = _puppies)
        private set

    fun onGridChanged(newGrid: Boolean) {
        _isGrid.value = newGrid
    }

    fun onPuppyAdoption(puppy: Puppy) {
        val index = puppies.toMutableList().indexOfFirst { it.id == puppy.id }
        puppies = puppies.toMutableList().also { it[index] = puppy }
    }
}
