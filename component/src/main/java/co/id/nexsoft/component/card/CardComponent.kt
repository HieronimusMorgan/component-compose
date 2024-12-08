package co.id.nexsoft.component.card

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.id.nexsoft.component.util.theme.SpacingComponent
import co.id.nexsoft.component.util.theme.setId

@Preview(showBackground = true)
@Composable
fun CardComponentPreview() {
    Column {

//        val map = mapOf(
//            "Key 1" to "Value 1",
//            "Key 2" to "Value 2",
//            "Key 3" to "Value 3",
//            "Key 4" to "Value 4",
//            "Key 5" to "Value 5",
//        )
//        CardComponent(
//            cardType = CardType.Detail,
//            title = "Title",
//            styleMapTitle = TitleLarge.merge(TextStyle(fontWeight = FontWeight.Bold)),
//            map = map,
//            onItemClicked = {})
//        val productModel = CardProductModel(
//            productImage = "https://res.cloudinary.com/dk0z4ums3/image/upload/v1714982141/attached_image/bear-brand-0-alodokter.jpg",
//            productName = "Product Name",
//            productPrice = 1000.0,
//            productPricePromo = 1000.0,
//            isPromo = false,
//            productDescription = "Product Description"
//        )
//        CardComponent(
//            cardType = CardType.ProductLandscape,
//            productModel = productModel,
//            onItemClicked = {})
        CardComponent(
            modifier = Modifier,
            id = "card_1",
            cardStyle = CardStyle.Color,
            color = Color.White,
            onItemClicked = {/* Handle item click */ }) {
            Text(text = "Card Content")
        }
    }
}

@Composable
fun CardComponent(
    modifier: Modifier = Modifier,
    id: String? = null,
    padding: Dp = SpacingComponent.Sm8,
    cardStyle: CardStyle = CardStyle.Color,
    color: Color = Color.White,
    onItemClicked: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    modifier.layoutId("card_${setId(id, "")}")
    Card(modifier = modifier
        .fillMaxWidth()
        .border(
            width = 1.dp, color = MaterialTheme.colorScheme.onSurface.copy(
                alpha = 0.5f
            ), shape = RoundedCornerShape(SpacingComponent.Sm8)
        ), colors = when (cardStyle) {
        CardStyle.Color -> {
            CardDefaults.cardColors(
                color
            )
        }

        CardStyle.Outline, CardStyle.Shadow -> {
            CardDefaults.cardColors(
                Color.White
            )
        }
    }, onClick = { onItemClicked() }) {
        Box(modifier = Modifier.padding(padding)) {
            content()
        }
    }
}

enum class CardType {
    Default, List, Detail, ProductLandscape, ProductPortrait, FeedCard
}

enum class CardStyle {
    Color, Outline, Shadow
}