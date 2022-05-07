package net.subroh0508.api.serializer

import kotlinx.serialization.Serializable

@Serializable
data class SparqlResponse<out T>(
    val head: Vars,
    @Serializable(with = ResultsSerializer::class)
    val results: Results<T>,
) {
    @Serializable
    data class Vars(
        val vars: List<String>,
    )

    @Serializable
    data class Results<out T>(
        val bindings: List<T>,
    )
}
