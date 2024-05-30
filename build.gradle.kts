
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

    //KSP processor
    alias(libs.plugins.ksp) apply false

    //Google services
    alias (libs.plugins.googleServices) apply false

    //Firebase crashlytics
    alias(libs.plugins.crashlytics) apply false
}