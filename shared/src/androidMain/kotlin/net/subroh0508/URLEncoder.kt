package net.subroh0508

import java.net.URLEncoder as JavaURLEncoder

internal actual object URLEncoder {
    actual fun encode(s: String) = JavaURLEncoder.encode(s, "UTF-8") ?: s
}
