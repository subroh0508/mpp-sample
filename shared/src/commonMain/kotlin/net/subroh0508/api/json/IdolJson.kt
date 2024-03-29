package net.subroh0508.api.json

import kotlinx.serialization.Serializable

@Serializable
data class IdolJson(
    val s: Map<String, String>,
    val name: Map<String, String>,
    val yomi: Map<String, String>,
    val color: Map<String, String>,
    val age: Map<String, String>,
    val birthplace: Map<String, String>,
    val hobbies: Map<String, String>,
    val idollistUrl: Map<String, String>,
)
