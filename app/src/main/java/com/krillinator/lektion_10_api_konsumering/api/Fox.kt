package com.krillinator.lektion_10_api_konsumering.api

import com.google.gson.annotations.SerializedName

class Fox(
    @SerializedName("image")
    var img: String = "",
    var link: String = ""
) {

    override fun toString(): String {
        return "Fox(img='$img', link='$link')"
    }
}

