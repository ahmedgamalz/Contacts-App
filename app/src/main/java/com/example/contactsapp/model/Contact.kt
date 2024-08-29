package com.example.contactsapp.model

import androidx.annotation.DrawableRes

class Contact(
    val name: String,
    val number: String,
    @DrawableRes val image: Int
)