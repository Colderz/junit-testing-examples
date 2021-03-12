package pakiet.arkadiuszzimny.unit_testing_1.repositories

import androidx.lifecycle.LiveData
import pakiet.arkadiuszzimny.unit_testing_1.data.local.ShoppingDao
import pakiet.arkadiuszzimny.unit_testing_1.data.local.ShoppingItem
import pakiet.arkadiuszzimny.unit_testing_1.data.remote.PixabayAPI
import pakiet.arkadiuszzimny.unit_testing_1.data.remote.responses.ImageResponse
import pakiet.arkadiuszzimny.unit_testing_1.other.Resource
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayAPI
): ShoppingRepository {

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
       return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if(response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Nieznany błąd", null)
            } else {
                Resource.error("Nieznany błąd", null)
            }
        } catch(e: Exception) {
            Resource.error("Brak połączenia z intenetem!", null)
        }
    }
}