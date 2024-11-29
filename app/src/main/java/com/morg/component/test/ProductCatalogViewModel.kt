// Import statements
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductCatalogViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {
    private val _productCatalogState = MutableStateFlow(ProductCatalogState())
    val productCatalogState: StateFlow<ProductCatalogState> = _productCatalogState

    init {
        loadProducts()
    }

    fun onSearchQueryChanged(query: String) {
        _productCatalogState.value = _productCatalogState.value.copy(searchQuery = query)
    }

    fun onSearch() {
        viewModelScope.launch {
            val products = repository.searchProducts(_productCatalogState.value.searchQuery)
            _productCatalogState.value = _productCatalogState.value.copy(products = products)
        }
    }

    fun onFilterButtonClicked() {
        // Implement filter logic
    }

    fun onProductSelected(productId: String) {
        // Handle product selection
    }

    private fun loadProducts() {
        viewModelScope.launch {
            val products = repository.getProducts()
            _productCatalogState.value = _productCatalogState.value.copy(products = products)
        }
    }

    data class ProductCatalogState(
        val searchQuery: String = "",
        val products: List<Product> = emptyList()
    )
}