package net.subroh0508.api.internal

internal expect object URLEncoder {
    fun encode(s: String): String
}
