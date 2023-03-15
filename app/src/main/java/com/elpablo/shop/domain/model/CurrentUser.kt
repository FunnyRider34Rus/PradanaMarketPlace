package com.elpablo.shop.domain.model

data class CurrentUser(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val password: String,
    val photo: String,
    val eMail: String
)