package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.card.CardComponent
import co.id.nexsoft.component.card.CardStyle
import co.id.nexsoft.component.card.CardType
import co.id.nexsoft.component.util.model.CardProductModel
import co.id.nexsoft.component.util.theme.BodyMedium
import co.id.nexsoft.component.util.theme.ImageSource
import co.id.nexsoft.component.util.theme.TitleLarge
import co.id.nexsoft.component.util.theme.TitleSmall

@Preview(showBackground = true)
@Composable
fun CardScreenPreview() {
    CardScreen(navController = NavController(LocalContext.current))
}

@Composable
fun CardScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Column {

            val map = mapOf(
                "Key 1" to "Value 1",
                "Key 2" to "Value 2",
                "Key 3" to "Value 3",
                "Key 4" to "Value 4",
                "Key 5" to "Value 5",
            )
            CardComponent(
                cardType = CardType.Detail,
                title = "Title",
                styleMapTitle = TitleLarge.merge(TextStyle(fontWeight = FontWeight.Bold)),
                map = map,
                onItemClicked = {})
            Spacer(modifier = Modifier.height(16.dp))

            val productModel = CardProductModel(
                productImage = "https://res.cloudinary.com/dk0z4ums3/image/upload/v1714982141/attached_image/bear-brand-0-alodokter.jpg",
                productName = "Product Name",
                productPrice = 1000.0,
                productPricePromo = 1000.0,
                isPromo = false,
                productDescription = "Product Description"
            )

            CardComponent(
                cardType = CardType.ProductLandscape,
                productModel = productModel,
                onItemClicked = {})

            Spacer(modifier = Modifier.height(16.dp))

            CardComponent(
                modifier = Modifier,
                id = "card_1",
                title = "Title",
                styleTitle = TitleSmall,
                description = "Description",
                styleDescription = BodyMedium,
                map = null,
                styleMapTitle = BodyMedium,
                icon = ImageSource.DrawableResource(co.id.nexsoft.component.R.drawable.ic_error_component),  // Add the icon here
                styleMapValue = BodyMedium,
                cardType = CardType.List,
                cardStyle = CardStyle.Color,
                color = Color.White,
                productModel = null,
                onItemClicked = {/* Handle item click */ })
        }
    }
}