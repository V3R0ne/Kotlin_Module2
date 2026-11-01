package com.example.kotlinmodule2.task10

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    val totalSum = products.sumOf { it.price }

    Column(modifier = modifier) {
        for (product in products) {
            Text(text = product.name + " - " + product.price + " рублей")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")
        AddProductSection(totalSum = totalSum) {
            products = products + Product(
                id = products.size,
                name = "Товар #${products.size + 1}",
                price = Random.nextInt(0, 100)
            )
        }
        RemoveProductSection(hasProducts = products.isNotEmpty()) {
            products = products.dropLast(1)
        }
    }
}

@Composable
fun AddProductSection(
    totalSum: Int,
    onAdd: () -> Unit
) {
    val context = LocalContext.current
    val isFreeDelivery = totalSum > 500

    // Если сумма заказа больше 500, то показываем сообщение о бесплатной доставке.
    // LaunchedEffect срабатывает только когда isFreeDelivery меняется,
    // а не при каждой рекомпозиции
    LaunchedEffect(isFreeDelivery) {
        if (isFreeDelivery) {
            Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
        }
    }

    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(
    hasProducts: Boolean,
    onRemove: () -> Unit
) {
    if (hasProducts) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}
