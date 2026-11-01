plugins {
    alias(libs.plugins.androidApplication) apply false

    //Kotlin
    alias(libs.plugins.kotlinSerialization) apply false

    //New compose compile plugin
    alias(libs.plugins.compose.compiler) apply false

    //KSP processor
    alias(libs.plugins.ksp) apply false

    //Google services
    alias (libs.plugins.googleServices) apply false

    //Firebase crashlytics
    alias(libs.plugins.crashlytics) apply false
    alias(libs.plugins.android.library) apply false

    //Detekt
    alias(libs.plugins.detekt) apply false

    //KtLint
    alias(libs.plugins.ktlint) apply false
}

//my scripts
apply(from = rootProject.file("gradleConfig/scripts/scripts-hooks.gradle"))
apply(from = rootProject.file("gradleConfig/scripts/scripts-actions.gradle"))
