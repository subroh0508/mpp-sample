package net.subroh0508.api.internal

import java.net.URLEncoder

internal actual object URLEncoder {
    actual fun encode(s: String) = URLEncoder.encode(s, "UTF-8") ?: s
}
