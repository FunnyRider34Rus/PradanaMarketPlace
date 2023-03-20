package com.elpablo.shop.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val firstName: String,
    @ColumnInfo val lastName: String,
    @ColumnInfo val password: String,
    @ColumnInfo val photo: String,
    @ColumnInfo val eMail: String
)