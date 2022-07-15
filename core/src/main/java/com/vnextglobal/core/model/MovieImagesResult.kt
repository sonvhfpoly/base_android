package com.vnextglobal.core.model

import com.google.gson.annotations.SerializedName

data class MovieImagesResult(
    @SerializedName("backdrops" ) var backdrops : ArrayList<Backdrops> = arrayListOf(),
    @SerializedName("id"        ) var id        : Int?                 = null,
    @SerializedName("logos"     ) var logos     : ArrayList<Logos>     = arrayListOf(),
    @SerializedName("posters"   ) var posters   : ArrayList<Posters>   = arrayListOf()
)
