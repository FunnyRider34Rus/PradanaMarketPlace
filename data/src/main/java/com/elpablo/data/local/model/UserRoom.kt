package com.elpablo.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elpablo.domain.model.User

@Entity
data class UserRoom(
    @PrimaryKey val firstName: String,
    @ColumnInfo val lastName: String,
    @ColumnInfo val password: String,
    @ColumnInfo val photo: String,
    @ColumnInfo val eMail: String
)

fun UserRoom.toUser() = User(
    firstName = firstName,
    lastName = lastName,
    password = password,
    photo = photo,
    eMail = eMail
)

fun User.toUserRoom() = UserRoom(
    firstName = firstName,
    lastName = lastName,
    password = password,
    photo = photo,
    eMail = eMail
)