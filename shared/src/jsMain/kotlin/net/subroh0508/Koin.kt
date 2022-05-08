package net.subroh0508

import net.subroh0508.api.di.Api
import net.subroh0508.data.infra.di.IdolsRepositories
import org.koin.core.context.GlobalContext
import org.koin.core.context.GlobalContext.startKoin
import kotlin.reflect.KClass

fun initKoin() = startKoin {
    modules(Api.Module + IdolsRepositories.Module)
}

fun <T: Any> getKoin(kClazz: KClass<T>) = GlobalContext.get().get<T>(kClazz)
