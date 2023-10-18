package com.example.submissionpemulaapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animal(
    val animal: String,
    val latin: String,
    val photo: String,
    val description: String
): Parcelable
