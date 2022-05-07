package net.subroh0508.api.internal

import io.ktor.client.*
import io.ktor.client.request.get
import io.ktor.client.statement.*
import io.ktor.utils.io.charsets.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import net.subroh0508.api.ImasparqlClient
import net.subroh0508.api.serializer.SparqlResponse

internal class ImasparqlApiClient(
    private val httpClient: HttpClient,
) : ImasparqlClient {
    companion object {
        private const val ENDPOINT_MAIN = "/spql/imas/query"
    }

    private val json by lazy {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
            allowSpecialFloatingPointValues = true
            useArrayPolymorphism = true
        }
    }

    override suspend fun <T> execute(
        query: String,
        serializer: KSerializer<T>,
    ): SparqlResponse<T> {
        val response = httpClient.get(buildUrl(query))

        return json.decodeFromString(
            SparqlResponse.serializer(serializer),
            response.bodyAsText(Charset.forName("UTF-8")),
        )
    }

    private fun buildUrl(query: String) = buildString {
        append("$ENDPOINT_MAIN?output=json&query=")
        append(URLEncoder.encode(query))
    }
}
