package com.book.shorten_url.service

import com.book.shorten_url.entity.Url
import com.book.shorten_url.repository.UrlRepository
import org.springframework.stereotype.Service

@Service
class UrlService(
    private val urlRepository: UrlRepository
) {

    fun shortenUrl(url: String): String {
        val existingUrl: Url? = urlRepository.findByOriginalUrl(url)
        if (existingUrl != null) return existingUrl.shortenUrl

        // Base62 ID 생성 (10자리)
        val shortId = generateShortId()
        val shortenUrl = "https://short.ly/$shortId"

        // 엔티티 저장
        urlRepository.save(Url(originalUrl = url, shortenUrl = shortenUrl))

        return shortenUrl
    }

    fun getOriginalUrl(shortenUrl: String): String? {
        return urlRepository.findByShortenUrl(shortenUrl)?.originalUrl
    }

    private fun generateShortId(): String {
        val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..7).map { characters.random() }.joinToString("")
    }
}
