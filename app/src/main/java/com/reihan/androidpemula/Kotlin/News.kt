package com.reihan.androidpemula.Kotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    val title: String,
    val author: String,
    val date: String,
    val desc: String,
    val photo: Int
) : Parcelable
