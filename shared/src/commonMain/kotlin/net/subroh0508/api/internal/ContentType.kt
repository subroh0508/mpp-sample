package net.subroh0508.api.internal

import io.ktor.http.ContentType as KtorContentType

internal abstract class ContentType {
    object Application {
        val SparqlJson = KtorContentType("application", "sparql-results+json")
    }
}
