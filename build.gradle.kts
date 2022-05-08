buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(kotlinGradlePlugin)
        classpath(androidGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
