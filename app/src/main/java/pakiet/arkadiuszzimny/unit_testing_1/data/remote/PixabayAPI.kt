package pakiet.arkadiuszzimny.unit_testing_1.data.remote

import pakiet.arkadiuszzimny.unit_testing_1.BuildConfig
import pakiet.arkadiuszzimny.unit_testing_1.data.remote.responses.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {

    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): Response<ImageResponse>



}