package net.subroh0508.data.infra.di

import net.subroh0508.data.infra.IdolsRepository
import net.subroh0508.data.infra.internal.IdolsRepositoryImpl
import org.koin.dsl.module

object IdolsRepositories {
    val Module get() = module {
        single<IdolsRepository> { IdolsRepositoryImpl(get()) }
    }
}
