plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "net.subroh0508.mppsample"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activityCompose)
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.uiTooling)
    implementation(Libraries.Koin.android)
}
