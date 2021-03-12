package pakiet.arkadiuszzimny.unit_testing_1.repositories

import androidx.lifecycle.LiveData
import pakiet.arkadiuszzimny.unit_testing_1.data.local.ShoppingItem
import pakiet.arkadiuszzimny.unit_testing_1.data.remote.responses.ImageResponse
import pakiet.arkadiuszzimny.unit_testing_1.other.Resource

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}