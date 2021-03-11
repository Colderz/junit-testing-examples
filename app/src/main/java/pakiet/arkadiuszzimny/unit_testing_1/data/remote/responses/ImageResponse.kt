package pakiet.arkadiuszzimny.unit_testing_1.data.remote.responses

data class ImageResponse(
    val hits: List<ImageResult>,
    val total: Int,
    val totalHits: Int
)