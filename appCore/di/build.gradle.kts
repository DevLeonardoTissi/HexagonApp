plugins {
    alias(libs.plugins.android.library)

    // ktlint
    alias(libs.plugins.ktlint)
}

// detekt
apply(from = rootProject.file("config/detekt/detekt.gradle"))

android {
    namespace = "br.com.leonardo.appcore.di"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    // koin for compose
    api(libs.koin.androidx.compose)

    api(libs.androidx.appcompat)
    api(libs.androidx.core.ktx)
    api(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
