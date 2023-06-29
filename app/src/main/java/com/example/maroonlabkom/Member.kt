package com.example.maroonlabkom

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Member(
    val name: String,
    val description: String,
    val photo: Int,
    val note: String
) : Parcelable
