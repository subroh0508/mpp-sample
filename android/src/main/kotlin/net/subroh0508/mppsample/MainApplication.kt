package net.subroh0508.mppsample

import android.app.Application
import net.subroh0508.api.di.Api
import net.subroh0508.data.infra.di.IdolsRepositories
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(Api.Module + IdolsRepositories.Module)
        }
    }
}
