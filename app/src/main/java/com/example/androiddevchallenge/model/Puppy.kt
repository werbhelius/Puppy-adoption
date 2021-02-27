package com.example.androiddevchallenge.model

/**
 * Created by wanbo on 2021/2/27.
 */
data class Puppy(
    val id: String,
    val name: String,
    val age: Int,
    val gender: Gender,
    val imageUrl: String
    )

enum class Gender {
    MALE, FEMALE
}