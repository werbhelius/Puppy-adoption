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
