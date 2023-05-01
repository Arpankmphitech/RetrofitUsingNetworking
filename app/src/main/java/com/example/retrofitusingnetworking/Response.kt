package com.example.retrofitusingnetworking

import com.google.gson.annotations.SerializedName

data class Response<T>(

	@field:SerializedName("ResponseCode")
	val responseCode: Int? = null,

	@field:SerializedName("ResponseMsg")
	val responseMsg: String? = null,

	@field:SerializedName("Image")
	val image: List<ImageItem?>? = null,

	@field:SerializedName("ServerTime")
	val serverTime: String? = null,

	@field:SerializedName("Result")
	val result: Boolean? = null
)

data class ImageItem(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("walpapper_id")
	val walpapperId: String? = null
)
