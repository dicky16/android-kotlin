package com.slim.makanan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodModel (
    var id: String,
    var nama: String,
    var gambar: String
) : Parcelable