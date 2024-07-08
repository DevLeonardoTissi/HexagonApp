
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

    //New compose compile plugin
    alias(libs.plugins.compose.compiler) apply false

    //KSP processor
    alias(libs.plugins.ksp) apply false

    //Google services
    alias (libs.plugins.googleServices) apply false

    //Firebase crashlytics
    alias(libs.plugins.crashlytics) apply false
    alias(libs.plugins.android.library) apply false
}