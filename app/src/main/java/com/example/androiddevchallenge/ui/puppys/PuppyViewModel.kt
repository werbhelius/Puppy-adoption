package com.example.androiddevchallenge.ui.puppys

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.Puppy
import java.util.*

/**
 * Created by wanbo on 2021/2/27.
 */
class PuppyViewModel: ViewModel() {

    val puppies = listOf(
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
        Puppy(
            id = UUID.randomUUID().toString(),
            name = "Lilly",
            gender = Gender.FEMALE,
            age = 2,
            imageUrl = "https://images.unsplash.com/photo-1610244130620-fd348aa7854e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHw%3D&auto=format&fit=crop&w=300&q=100"
        ),
    )
}