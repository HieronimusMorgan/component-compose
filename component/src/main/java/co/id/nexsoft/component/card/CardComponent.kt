package co.id.nexsoft.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.id.nexsoft.component.R
import co.id.nexsoft.component.button.ButtonComponent
import co.id.nexsoft.component.util.model.CardProductModel
import co.id.nexsoft.component.util.theme.BodyMedium
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.SpacingComponent
import co.id.nexsoft.component.util.theme.TitleSmall
import co.id.nexsoft.component.util.theme.setId
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

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
            title = "Title",
            styleTitle = TitleSmall,
            description = "Description",
            styleDescription = BodyMedium,
            map = null,
            styleMapTitle = BodyMedium,
            styleMapValue = BodyMedium,
            cardType = CardType.List,
            cardStyle = CardStyle.Color,
            color = Color.White,
            productModel = null,
            onItemClicked = {/* Handle item click */ })
    }
}

/**
 * The CardComponent function takes several parameters, including modifier, title, styleTitle, description, styleDescription, map, styleMapTitle, styleMapValue, cardType, cardStyle, color, productModel, and onItemClicked. Depending on the cardType parameter, it delegates the rendering to other composable functions like CardList, CardDetail, and CardProductLandscape.
 * ```
 * when (cardType) {
 *     CardType.List -> {
 *         CardList(
 *             modifier = modifier,
 *             title = title,
 *             styleTitle = styleTitle,
 *             description = description,
 *             styleDescription = styleDescription,
 *             cardStyle = cardStyle,
 *             color = color,
 *             onItemClicked = onItemClicked
 *         )
 *     }
 *     // Other cases...
 * }
 * ```
 *
 * The CardProductLandscape function creates a card displaying product information in a landscape layout. It uses the rememberAsyncImagePainter to load and display the product image and conditionally shows a badge and a more options icon.
 * ```
 * val painter = rememberAsyncImagePainter(
 *     model = ImageRequest.Builder(context)
 *         .data(productModel.productImage)
 *         .transformations(CircleCropTransformation())
 *         .placeholder(R.drawable.ic_no_image_grey_component)
 *         .error(R.drawable.ic_no_image_grey_component)
 *         .build()
 * )
 * ```
 *
 * The CardList function creates a card with a title and an optional description. It uses a Row composable to arrange the title, description, and an icon horizontally.
 * ```
 * Row(
 *     modifier = Modifier
 *         .padding(SpacingComponent.Md16)
 *         .fillMaxWidth()
 *         .wrapContentHeight(),
 *     horizontalArrangement = Arrangement.Start,
 *     verticalAlignment = Alignment.CenterVertically
 * ) {
 *     // Content...
 * }
 * ```
 *
 * The CardDetail function displays a card with a title and a map of key-value pairs. It iterates over the map to display each key-value pair in a Row composable.
 * ```
 * map?.forEach { (key, value) ->
 *     Row(
 *         modifier = Modifier
 *             .fillMaxWidth()
 *             .wrapContentHeight(),
 *         verticalAlignment = Alignment.CenterVertically,
 *         horizontalArrangement = Arrangement.Center
 *     ) {
 *         // Key and value text...
 *     }
 * }
 * ```
 *
 * @param modifier Modifier to be applied to the card component.
 * @param title Title text to be displayed on the card.
 * @param styleTitle Text style to be applied to the title.
 * @param description Optional description text to be displayed on the card.
 * @param styleDescription Text style to be applied to the description.
 * @param map Optional map of key-value pairs to be displayed on the card.
 * @param styleMapTitle Text style to be applied to the map keys.
 * @param styleMapValue Text style to be applied to the map values.
 * @param cardType Type of the card (List, Detail, ProductLandscape, ProductPortrait, FeedCard).
 * @param cardStyle Style of the card (Color, Outline, Shadow).
 * @param color Background color of the card.
 * @param productModel Optional product model to be displayed on the card.
 * @param onItemClicked Callback function to be invoked when the card is clicked.
 */
@Composable
fun CardComponent(
    modifier: Modifier = Modifier,
    id: String? = null,
    title: String = "",
    styleTitle: TextStyle = TitleSmall,
    description: String? = null,
    styleDescription: TextStyle = BodyMedium,
    map: Map<String, String>? = null,
    styleMapTitle: TextStyle = BodyMedium,
    styleMapValue: TextStyle = BodyMedium,
    cardType: CardType = CardType.List,
    cardStyle: CardStyle = CardStyle.Color,
    color: Color = Color.White,
    productModel: CardProductModel? = null,
    onItemClicked: () -> Unit = {}
) {
    modifier.layoutId("card_${setId(id, "")}")
    when (cardType) {
        CardType.List -> {
            CardList(
                modifier = modifier,
                title = title,
                styleTitle = styleTitle,
                description = description,
                styleDescription = styleDescription,
                cardStyle = cardStyle,
                color = color,
                onItemClicked = onItemClicked
            )
        }

        CardType.Detail -> {
            CardDetail(
                modifier = modifier,
                title = title,
                styleTitle = styleTitle,
                styleMapTitle = styleMapTitle,
                styleMapValue = styleMapValue,
                map = map,
                cardStyle = cardStyle,
                color = color
            )
        }

        CardType.ProductLandscape -> {
            CardProductLandscape(
                modifier = modifier,
                productModel = productModel!!,
                cardStyle = cardStyle,
                color = color,
                onItemClicked = onItemClicked
            )
        }

        CardType.ProductPortrait -> {
            when (cardStyle) {
                CardStyle.Color -> {
                    // Card with color
                }

                CardStyle.Outline -> {
                    // Card with outline
                }

                CardStyle.Shadow -> {
                    // Card with shadow
                }
            }
        }

        CardType.FeedCard -> {
            when (cardStyle) {
                CardStyle.Color -> {
                    // Card with color
                }

                CardStyle.Outline -> {
                    // Card with outline
                }

                CardStyle.Shadow -> {
                    // Card with shadow
                }
            }
        }
    }

}

@Composable
fun CardProductLandscape(
    modifier: Modifier,
    productModel: CardProductModel,
    cardStyle: CardStyle,
    color: Color,
    badgeProduct: String = "New",
    isBadgeVisible: Boolean = true,
    isMoreIconVisible: Boolean = true,
    onMoreClicked: () -> Unit = {},
    onItemClicked: () -> Unit
) {
    val cardColors =
        if (cardStyle == CardStyle.Color) CardDefaults.cardColors(color) else CardDefaults.cardColors(
            Color.White
        )
    val context = LocalContext.current

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(productModel.productImage)
            .transformations(CircleCropTransformation())
            .placeholder(R.drawable.ic_no_image_grey_component)
            .error(R.drawable.ic_no_image_grey_component)
            .build()
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(
                1.dp,
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                RoundedCornerShape(SpacingComponent.Sm8)
            ),
        colors = cardColors,
        onClick = { onItemClicked() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(156.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(156.dp)) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.CenterStart
                )
                if (isBadgeVisible) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(4.dp)
                            .background(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                                RoundedCornerShape(16.dp)
                            )
                    ) {
                        Text(
                            text = badgeProduct,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(SpacingComponent.Sm8)
                    .fillMaxSize()
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = productModel.productName,
                            style = TitleSmall,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(SpacingComponent.Sm2))
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = productModel.productDescription,
                            style = BodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(SpacingComponent.Sm8))
                        Row {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = productModel.productPrice.toString(),
                                style = BodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            if (productModel.isPromo) {
                                Spacer(modifier = Modifier.width(SpacingComponent.Sm10))
                                Text(
                                    text = productModel.productPricePromo.toString(),
                                    style = BodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                    if (isMoreIconVisible)

                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .align(Alignment.TopEnd)
                        ) {
                            IconButton(onClick = { onMoreClicked() }) {
                                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
                            }
                        }
                }
                Spacer(modifier = Modifier.weight(1f))
                ButtonComponent(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Button",
                    componentSize = ComponentSize.MEDIUM,
                    onClick = { onItemClicked() }
                )
            }
        }
    }
}

@Composable
fun LoadImageFromUrl(url: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true)
            .placeholder(R.drawable.ic_no_image_grey_component)  // Use a drawable resource here
            .error(R.drawable.ic_no_image_grey_component)
            .transformations(
                CircleCropTransformation()
            )
            .build(),
        contentDescription = null,
        modifier = modifier
            .height(156.dp)
            .width(156.dp),
        alignment = Alignment.CenterStart
    )
}

@Composable
fun CardList(
    modifier: Modifier,
    title: String = "Title",
    styleTitle: TextStyle = TitleSmall,
    description: String? = "Description",
    styleDescription: TextStyle = BodyMedium,
    icon: ImageVector = Icons.AutoMirrored.Filled.ArrowRight,
    cardStyle: CardStyle,
    color: Color,
    onItemClicked: () -> Unit = {}
) {
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
        Row(
            modifier = Modifier
                .padding(SpacingComponent.Md16)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = SpacingComponent.Sm8)
            ) {
                Text(
                    text = title, style = styleTitle, color = MaterialTheme.colorScheme.onSurface
                )
                if (description != null) {
                    Spacer(modifier = Modifier.height(SpacingComponent.Sm10))
                    Text(
                        text = description,
                        style = styleDescription,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            Icon(
                modifier = Modifier.weight(0.1f),
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun CardDetail(
    modifier: Modifier = Modifier,
    title: String = "Title",
    styleTitle: TextStyle = TitleSmall,
    styleMapTitle: TextStyle = BodyMedium,
    styleMapValue: TextStyle = BodyMedium,
    cardStyle: CardStyle,
    color: Color,
    map: Map<String, String>? = null,
    onItemClicked: () -> Unit = {}
) {
    val cardColor = when (cardStyle) {
        CardStyle.Color -> color
        CardStyle.Outline, CardStyle.Shadow -> Color.White
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                shape = RoundedCornerShape(SpacingComponent.Sm8)
            ),
        colors = CardDefaults.cardColors(cardColor),
        onClick = onItemClicked
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = styleTitle,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(SpacingComponent.Sm12))

            map?.forEach { (key, value) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight(),
                        text = key,
                        style = styleMapTitle,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight(),
                        text = value,
                        style = styleMapValue,
                        textAlign = TextAlign.End,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.height(SpacingComponent.Sm12))
            }
        }
    }
}


enum class CardType {
    List, Detail, ProductLandscape, ProductPortrait, FeedCard
}

enum class CardStyle {
    Color, Outline, Shadow
}