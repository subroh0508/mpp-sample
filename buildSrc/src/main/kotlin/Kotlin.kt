import org.gradle.api.Project

val Project.kotlinVersion get() = version("kotlin")
val Project.kotlinGradlePlugin get() = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
val Project.androidGradlePlugin get() = "com.android.tools.build:gradle:${version("android-gradle-plugin")}"
