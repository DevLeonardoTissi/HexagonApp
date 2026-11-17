plugins {
    alias(appCoreLibs.plugins.androidApplication) apply false

    //Kotlin
    alias(appCoreLibs.plugins.kotlinSerialization) apply false

    //New compose compile plugin
    alias(appCoreLibs.plugins.compose.compiler) apply false

    //KSP processor
    alias(appCoreLibs.plugins.ksp) apply false

    //Google services
    alias (appCoreLibs.plugins.googleServices) apply false

    //Firebase crashlytics
    alias(appCoreLibs.plugins.crashlytics) apply false
    alias(appCoreLibs.plugins.android.library) apply false

    //Detekt
    alias(appCoreLibs.plugins.detekt) apply false

    //KtLint
    alias(appCoreLibs.plugins.ktlint) apply false
}

//my scripts
extra["targetAppModule"] = ":app"
apply(from = rootProject.file("appCore/gradleConfig/scripts/scripts-hooks.gradle"))
apply(from = rootProject.file("appCore/gradleConfig/scripts/scripts-actions.gradle"))
apply(from = rootProject.file("appCore/gradleConfig/scripts/scripts-ktlint.gradle"))
