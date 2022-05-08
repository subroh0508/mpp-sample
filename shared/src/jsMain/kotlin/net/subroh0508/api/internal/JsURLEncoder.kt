package net.subroh0508.api.internal

private external fun encodeURIComponent(s: String): String

internal actual object URLEncoder {
    actual fun encode(s: String) = encodeURIComponent(s)
}
