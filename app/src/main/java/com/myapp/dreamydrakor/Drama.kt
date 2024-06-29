package com.myapp.dreamydrakor

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drama(
    val title: String,
    val description: String,
    val dramaImage: Int
) : Parcelable
