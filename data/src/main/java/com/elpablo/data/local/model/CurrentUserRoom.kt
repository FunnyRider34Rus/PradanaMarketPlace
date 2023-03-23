package com.elpablo.data.local.model

data class CurrentUserRoom(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val password: String,
    val photo: String,
    val eMail: String
)