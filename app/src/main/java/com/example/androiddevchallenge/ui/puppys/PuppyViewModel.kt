package com.example.androiddevchallenge.ui.puppys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Sex
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.TYPE
import java.util.*

/**
 * Created by wanbo on 2021/2/27.
 */
class PuppyViewModel: ViewModel() {

    private val _isGrid = MutableLiveData(true)
    val isGrid: LiveData<Boolean> = _isGrid

    fun onGridChanged(newGrid: Boolean) {
        _isGrid.value = newGrid
    }

    val puppies = listOf(
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Bella",
            age = 1.0,
            type = TYPE.ShihTzu,
            sex = Sex.MALE,
            color = "Brown",
            weight = 2.0,
            imageUrl = "https://images.unsplash.com/photo-1608096299210-db7e38487075?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Daisy",
            age = 1.3,
            type = TYPE.SpringerSpaniel,
            sex = Sex.FEMALE,
            color = "White&Black",
            weight = 3.0,
            imageUrl = "https://images.unsplash.com/photo-1604303766758-e9e7bd704fc4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Molly",
            age = 0.8,
            type = TYPE.Pomeranian,
            sex = Sex.FEMALE,
            color = "White",
            weight = 2.0,
            imageUrl = "https://images.unsplash.com/photo-1587402092301-725e37c70fd8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Sophie",
            age = 2.0,
            type = TYPE.Beagle,
            sex = Sex.MALE,
            color = "Brown&White",
            weight = 3.0,
            imageUrl = "https://images.unsplash.com/photo-1611305366162-ce5d41340817?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Coco",
            age = 1.5,
            type = TYPE.Terrier,
            sex = Sex.MALE,
            color = "White&Black",
            weight = 2.5,
            imageUrl = "https://images.unsplash.com/photo-1549775924-433bdc7ea7a9?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Nala",
            age = 2.0,
            type = TYPE.Pug,
            sex = Sex.MALE,
            color = "Black",
            weight = 3.5,
            imageUrl = "https://images.unsplash.com/photo-1530041686259-53d26f863313?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Abby",
            age = 1.0,
            type = TYPE.Maltese,
            sex = Sex.FEMALE,
            color = "White",
            weight = 1.5,
            imageUrl = "https://images.unsplash.com/photo-1577447310651-8453e529e838?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1080&q=80"
        )
    )



}