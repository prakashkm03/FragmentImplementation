package com.example.fragmentimplementation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model
    (
    var text1: String,
    var text2: String
) : Parcelable