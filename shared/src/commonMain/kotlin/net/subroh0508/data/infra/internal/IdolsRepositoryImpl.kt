package net.subroh0508.data.infra.internal

import net.subroh0508.api.ImasparqlClient
import net.subroh0508.api.json.IdolJson
import net.subroh0508.data.infra.IdolsRepository
import net.subroh0508.data.model.Idol

internal class IdolsRepositoryImpl(
    private val client: ImasparqlClient,
) : IdolsRepository {
    override suspend fun search(query: String?) = client.execute(
        buildQuery(query),
        IdolJson.serializer(),
    ).results.bindings.mapNotNull { it.toEntity() }

    private fun buildQuery(queryStr: String?) = buildString {
        append(
            """
            PREFIX schema: <http://schema.org/>
            PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
            PREFIX imas: <https://sparql.crssnky.xyz/imasrdf/URIs/imas-schema.ttl#>
            PREFIX foaf: <http://xmlns.com/foaf/0.1/>
            SELECT *
            WHERE {
              ?s a imas:Idol;
                schema:name ?name;
                imas:Title ?title;
                imas:Color ?color;
                foaf:age ?age;
                schema:birthPlace ?birthplace;
                imas:IdolListURL ?idollistUrl.
              {
                SELECT ?s (GROUP_CONCAT(?hobby; separator = ',') as ?hobbies)
                WHERE {
                  ?s imas:Hobby ?hobby.
                }
                GROUP BY ?s
              }
              FILTER (lang(?name) = 'ja')
              FILTER (str(?title) != '1st Vision')
              ${queryStr?.let {"FILTER (regex(?name, '.*$it.*', 'i') || regex(?yomi, '.*$it.*', 'i'))." } ?: ""}
              OPTIONAL { ?s imas:alternateNameKana ?tmp }
              OPTIONAL { ?s imas:nameKana ?tmp }
              OPTIONAL { ?s imas:givenNameKana ?tmp }
              BIND(?tmp AS ?yomi)
            }
            ORDER BY ?yomi
            """.trimIndentAndBr()
        )
    }

    private fun String.trimIndentAndBr() = trimIndent().replace("[\n\r]", "")

    private fun IdolJson.toEntity() = let { json ->
        val id = json.s["value"]?.split("/")?.lastOrNull() ?: return@let null
        val name = json.name["value"] ?: return@let null
        val yomi = json.yomi["value"] ?: return@let null
        val color = json.color["value"] ?: "000000"
        val age = json.age["value"] ?: return@let null
        val birthplace = json.birthplace["value"] ?: return@let null
        val hobbies = json.hobbies["value"] ?: return@let null
        val idollistUrl = json.idollistUrl["value"] ?: return@let null

        Idol(id, name, yomi, "#$color", age, birthplace, hobbies.split(","), idollistUrl)
    }
}
