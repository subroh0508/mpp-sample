package net.subroh0508.api.di

import net.subroh0508.api.ImasparqlClient
import net.subroh0508.api.internal.ImasparqlApiClient
import net.subroh0508.api.internal.httpClient
import org.koin.dsl.module

object Api {
    val Module get()  = module {
        single { httpClient }
        single<ImasparqlClient> { ImasparqlApiClient(httpClient) }
    }
}
