plugins {
    alias(libs.plugins.androidApplication)

    // New compose compile plugin
    alias(libs.plugins.compose.compiler)

    // Google services
    alias(libs.plugins.googleServices)

    // Firebase crashlytics
    alias(libs.plugins.crashlytics)

    // Kotlin Serialization (for navigation version)
    alias(libs.plugins.kotlinSerialization)

    // ktlint
    alias(libs.plugins.ktlint)
}

// my scripts

// detekt
apply(from = rootProject.file("config/detekt/detekt.gradle"))

android {
    namespace = "br.com.leonardo.hexagonapp"
    compileSdk = 37

    defaultConfig {
        applicationId = "br.com.leonardo.hexagonapp"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // appCore module (exposes data, domain, di, presentation transitively)
    implementation(project(":appCore"))

    // localData module
    implementation(project(":localData"))

    // koin tests
    testImplementation(libs.koin.test)
    testImplementation(libs.koin.test.junit4)

    // Kotlin coroutines tests
    testImplementation(libs.kotlinx.coroutines.test)

    testImplementation(libs.mockk)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
