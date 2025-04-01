package com.book.shorten_url.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Url(
    @Id var originalUrl: String,
    val shortenUrl: String
)
