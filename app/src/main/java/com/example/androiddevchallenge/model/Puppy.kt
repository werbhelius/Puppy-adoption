package com.example.androiddevchallenge.model

import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Created by wanbo on 2021/2/27.
 */
data class Puppy(
    var id: String,
    val name: String,
    val age: Double,
    val sex: Sex,
    val color: String,
    val weight: Double,
    val type: TYPE,
    val imageUrl: String,
    var isAdoption: Boolean
    ) {

    fun labels(): List<String> {
        return listOf(type.desc, "${age.format()} years", sex.desc, color, "${weight.format()} kg")
    }

}

fun Double.format(): String {
    val format = DecimalFormat("0.#")
    format.roundingMode = RoundingMode.FLOOR
    return format.format(this)
}

enum class Sex(val desc: String) {
    MALE("Male"), FEMALE("Female")
}

enum class TYPE(val desc: String) {
    ShihTzu("Shih Tzu"),
    SpringerSpaniel("Springer Spaniel"),
    Pomeranian("Pomeranian"),
    Beagle("Beagle"),
    Terrier("Terrier"),
    Pug("Pug"),
    Maltese("Maltese")
}