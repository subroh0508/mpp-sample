package net.subroh0508

import kotlinx.cinterop.ObjCProtocol
import kotlinx.cinterop.getOriginalKotlinClass
import net.subroh0508.api.di.Api
import net.subroh0508.data.infra.di.IdolsRepositories
import org.koin.core.context.GlobalContext
import org.koin.core.context.GlobalContext.startKoin

fun initKoin() = startKoin {
    modules(Api.Module + IdolsRepositories.Module)
}

fun get(objCProtocol: ObjCProtocol): Any {
    val kClazz = getOriginalKotlinClass(objCProtocol) ?: throw IllegalArgumentException()
    return GlobalContext.get().get(kClazz)
}
