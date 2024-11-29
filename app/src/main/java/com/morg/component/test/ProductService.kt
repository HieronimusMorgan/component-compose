import retrofit2.http.GET
import retrofit2.http.Path

// Import statements

interface ProductService {
    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products/search")
    suspend fun searchProducts(@Path("query") query: String): List<Product>
}