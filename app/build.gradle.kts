plugins {
    alias(appCoreLibs.plugins.androidApplication)
}

apply(from = rootProject.file("appCore/gradleConfig/core-base-build.gradle"))

android {
    namespace = "br.com.leonardo.hexagonapp"

    defaultConfig {
        applicationId = "br.com.leonardo.hexagonapp"
        versionCode = 1
        versionName = "1.0"
    }
}
