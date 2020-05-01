package com.example.pixabayapp


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Image(
    private val onSuccess: (List<result>) -> Unit
) {

    fun loadImages(
        query: String
    ) {
        Api.getImageApi()
            .getImagesByQuery(query)
            .enqueue(object : Callback<model> {
                override fun onResponse(
                    call: Call<model>,
                    response: Response<model>
                ) {
                    response.body()?.hits?.let {
                        onSuccess(it)
                    }
                }

                override fun onFailure(call: Call<model>, t: Throwable) {

                }
            })
    }


}