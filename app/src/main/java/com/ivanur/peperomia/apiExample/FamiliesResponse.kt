package com.ivanur.peperomia.apiExample

import com.google.gson.annotations.SerializedName

data class FamiliesResponse(
    @SerializedName("status") var status: String,
    @SerializedName("data") var data: List<FamilyItem>
) {

}