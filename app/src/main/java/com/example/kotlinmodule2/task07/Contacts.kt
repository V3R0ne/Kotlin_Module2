package com.example.kotlinmodule2.task07

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String,
    val address: String
)

val lukashin = Contact(
    name = "Евгений",
    patronymic = "Андреевич",
    surname = "Лукашин",
    phone = "+7 495 495 95 95",
    address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
)

val kuzyakin = Contact(
    name = "Василий",
    patronymic = "Егорович",
    surname = "Кузякин",
    phone = "---",
    address = "Ивановская область, дер. Крутово, д. 4"
)

val kalugina = Contact(
    name = "Людмила",
    patronymic = "Прокофьевна",
    surname = "Калугина",
    phone = "+7 495 788 78 78",
    address = "Москва, Большая Никитская, д. 43, кв. 290"
)

@Composable
fun ContactColumn(contact: Contact, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Имя: ${contact.name}")
        Text(text = "Отчество: ${contact.patronymic}")
        Text(text = "Фамилия: ${contact.surname}")
        Text(text = "Мобильный телефон: ${contact.phone}")
        Text(text = "Адрес: ${contact.address}")
    }
}

@Composable
fun ContactCard(contact: Contact, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Имя: ${contact.name}")
        Text(text = "Отчество: ${contact.patronymic}")
        Text(text = "Фамилия: ${contact.surname}")
        Text(text = "Мобильный телефон: ${contact.phone}")
        Text(text = "Адрес: ${contact.address}", textAlign = TextAlign.Center)
    }
}

// Картинка 2: список из трёх карточек
@Composable
fun ContactList(contacts: List<Contact>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (contact in contacts) {
            ContactCard(contact = contact, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun ContactRow(contact: Contact, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ContactCard(contact = contact, modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(android.R.drawable.btn_star_big_on),
            contentDescription = "Избранное",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ContactColumnPreview() {
    ContactColumn(contact = lukashin, modifier = Modifier.padding(top = 32.dp))
}

@Preview(showSystemUi = true)
@Composable
fun ListPreview() {
    ContactList(
        contacts = listOf(lukashin, kuzyakin, kalugina),
        modifier = Modifier.padding(top = 32.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun ContactRowPreview() {
    ContactRow(contact = lukashin, modifier = Modifier.padding(top = 32.dp))
}
