package net.subroh0508

import platform.Foundation.NSCharacterSet
import platform.Foundation.NSString
import platform.Foundation.URLHostAllowedCharacterSet
import platform.Foundation.stringByAddingPercentEncodingWithAllowedCharacters

@Suppress("CAST_NEVER_SUCCEEDS")
internal actual object URLEncoder {
    actual fun encode(s: String) =
        (s as NSString).stringByAddingPercentEncodingWithAllowedCharacters(NSCharacterSet.URLHostAllowedCharacterSet()) ?: s
}
