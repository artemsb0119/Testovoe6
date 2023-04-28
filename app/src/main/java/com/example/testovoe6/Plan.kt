package com.example.testovoe6

import com.google.gson.annotations.SerializedName

data class Plan (

    @SerializedName("train") val train : String,
    @SerializedName("kol") val kol : String
)