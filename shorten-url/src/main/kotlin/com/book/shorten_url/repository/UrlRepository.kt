package com.book.shorten_url.repository

import com.book.shorten_url.entity.Url
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository : JpaRepository<Url, Long> {
    fun findByOriginalUrl(originalUrl: String): Url?
    fun findByShortenUrl(shortenUrl: String): Url?
}
