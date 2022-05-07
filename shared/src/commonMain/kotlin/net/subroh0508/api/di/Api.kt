package net.subroh0508.api.di

import io.ktor.client.*
import net.subroh0508.api.ImasparqlClient
import net.subroh0508.api.internal.ImasparqlApiClient
import net.subroh0508.api.internal.httpClient
import org.koin.dsl.module

object Api {
    fun Module(client: HttpClient = httpClient) = module {
        single { client }
        single<ImasparqlClient> { ImasparqlApiClient(client) }
    }
}
