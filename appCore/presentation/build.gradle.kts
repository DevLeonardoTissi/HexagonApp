plugins {
    alias(libs.plugins.android.library)

    // compose compiler
    alias(libs.plugins.compose.compiler)

    // Kotlin Serialization (for navigation version)
    alias(libs.plugins.kotlinSerialization)

    // ktlint
    alias(libs.plugins.ktlint)
}

// detekt
apply(from = rootProject.file("config/detekt/detekt.gradle"))

android {
    namespace = "br.com.leonardo.appcore.presentation"
    compileSdk = 37

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    api(project(":appCore:di"))

    // Compose & Lifecycle
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.ui.tooling.preview)
    api(libs.androidx.lifecycle.runtime.compose)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.activity.compose)

    // Material & Adaptive
    api(libs.androidx.material3)
    api(libs.androidx.material.icons.extended)
    api(libs.androidx.adaptive)
    api(libs.androidx.adaptive.layout)
    api(libs.androidx.adaptive.navigation)

    // Navigation & Serialization
    api(libs.androidx.navigation3.ui)
    api(libs.androidx.navigation3.runtime)
    api(libs.androidx.lifecycle.viewmodel.navigation3)
    api(libs.kotlinx.serialization.json)

    // Koin for Compose & Navigation 3
    api(libs.koin.androidx.compose)
    api(libs.koin.compose.navigation3)

    // Coil & Lottie & Fonts
    api(libs.coil3.coil.compose)
    api(libs.coil.network.okhttp)
    api(libs.lottie.compose)
    api(libs.androidx.ui.text.google.fonts)

    // Core
    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.androidx.browser)
    api(libs.androidx.core.splashscreen)
    api(libs.material)
    api(libs.core)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
