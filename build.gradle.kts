import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension

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

plugins.withType<YarnPlugin> {
    the<YarnRootExtension>().apply {
        version = version("yarn")
        lockFileDirectory = projectDir
        ignoreScripts = false
    }
}

plugins.withType<NodeJsRootPlugin> {
    the<NodeJsRootExtension>().apply {
        nodeVersion = version("node")
    }
}
