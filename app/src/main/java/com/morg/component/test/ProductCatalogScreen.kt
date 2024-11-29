import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun ProductCatalogScreenContent(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    onSearch: () -> Unit,
    onFilterButtonClicked: () -> Unit,
    products: List<Product>,
    onProductSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // SearchBarComponent
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            label = { Text("Search Products") },
            placeholder = { Text("Search...") },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearch() }),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        // FilterButtonComponent
        Button(
            onClick = { onFilterButtonClicked() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Filter")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ProductCardComponent
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(products) { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onProductSelected(product.name) },
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(product.imageUrl),
                            contentDescription = "Image for ${product.name}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = product.name, style = MaterialTheme.typography.bodySmall)
                        Text(text = "${product.price}", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCatalogScreen(viewModel: ProductCatalogViewModel = hiltViewModel()) {
    val productCatalogState = viewModel.productCatalogState.collectAsState()

    ProductCatalogScreenContent(
        searchQuery = productCatalogState.value.searchQuery,
        onSearchQueryChanged = viewModel::onSearchQueryChanged,
        onSearch = viewModel::onSearch,
        onFilterButtonClicked = viewModel::onFilterButtonClicked,
        products = productCatalogState.value.products,
        onProductSelected = viewModel::onProductSelected
    )
}

val mockProducts = listOf(
    Product("1", "Product 1", "https://via.placeholder.com/150", "$10"),
    Product("2", "Product 2", "https://via.placeholder.com/150", "$15"),
    Product("3", "Product 3", "https://via.placeholder.com/150", "$20")
)

@Preview(showBackground = true)
@Composable
fun ProductCatalogScreenPreview() {
    ProductCatalogScreenContent(
        searchQuery = "",
        onSearchQueryChanged = {},
        onSearch = {},
        onFilterButtonClicked = {},
        products = mockProducts,
        onProductSelected = {}
    )
}
