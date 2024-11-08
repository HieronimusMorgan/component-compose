package co.id.nexsoft.component.util.model

data class CardProductModel(
    var productName: String,
    var productDescription: String,
    var productPrice: Double,
    var productPricePromo: Double,
    var productImage: String,
    var isPromo: Boolean,
)
