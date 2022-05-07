package net.subroh0508

import java.net.URLEncoder as JavaURLEncoder

actual object URLEncoder {
    actual fun encode(s: String) = JavaURLEncoder.encode(s, "UTF-8")
}
