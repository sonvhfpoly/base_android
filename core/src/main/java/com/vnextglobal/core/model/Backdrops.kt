package com.vnextglobal.core.model

import com.google.gson.annotations.SerializedName


data class Backdrops (

    @SerializedName("aspect_ratio" ) var aspectRatio : Double? = null,
    @SerializedName("height"       ) var height      : Int?    = null,
    @SerializedName("iso_639_1"    ) var iso6391     : String? = null,
    @SerializedName("file_path"    ) var filePath    : String? = null,
    @SerializedName("vote_average" ) var voteAverage : Double? = null,
    @SerializedName("vote_count"   ) var voteCount   : Int?    = null,
    @SerializedName("width"        ) var width       : Int?    = null

){
    fun getImageUrlPath() = Image.urlImagePath + filePath
}