@Suppress("unused")
object Libraries {
    object Jetpack {
        private const val appCompatVersion = "1.4.1"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

        private const val activityComposeVersion = "1.4.0"
        const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
    }

    object Serialization {
        private const val version = "1.3.2"

        const val core = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
    }

    object Coroutine {
        private const val version = "1.6.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"

        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Ktor {
        private const val version = "2.0.1"

        object Client {
            const val core = "io.ktor:ktor-client-core:$version"
            const val okHttp = "io.ktor:ktor-client-okhttp:$version"
            const val darwin = "io.ktor:ktor-client-darwin:$version"
        }

        object Serialization {
            const val core = "io.ktor:ktor-serialization-kotlinx-json:$version"
        }
    }

    object Koin {
        private const val version = "3.1.6"

        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
    }
}
