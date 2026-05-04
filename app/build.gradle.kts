plugins {
    alias(libs.plugins.androidApplication)


    //New compose compile plugin
    alias(libs.plugins.compose.compiler)

    //Google services
    alias(libs.plugins.googleServices)

    //Firebase crashlytics
    alias(libs.plugins.crashlytics)

    //Kotlin Serialization (for navigation version)
    kotlin("plugin.serialization") version "2.3.10"
}

android {
    namespace = "br.com.leonardo.hexagonapp"
    compileSdk = 36

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
                "proguard-rules.pro"
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

    //webClient module
    implementation(project(":webClient"))

    //localData module
    implementation(project(":localData"))

    //ui
    implementation(project(":ui"))

    //Kotlin Serialization (for navigation version)
    implementation(libs.kotlinx.serialization.json)

    //Coil for compose
    implementation(libs.coil3.coil.compose)
    implementation(libs.coil.network.okhttp)

    //Lottie animation for compose
    implementation(libs.lottie.compose)

    //Google fonts
    implementation(libs.androidx.ui.text.google.fonts)

    //koin for compose
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.compose.navigation3)

    //Firebase DOM
    implementation(platform(libs.firebase.bom))

    //Google Analytics
    implementation(libs.google.firebase.analytics)

    //Firebase crashlytics
    implementation(libs.firebase.crashlytics)

    //Material design
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)

    //Splash screen
    implementation(libs.androidx.core.splashscreen)

    //Zxing - QrCode Generator
    implementation(libs.core)

    //Material Adaptative
    implementation(libs.androidx.adaptive)
    implementation (libs.androidx.adaptive.layout)
    implementation (libs.androidx.adaptive.navigation)

    //Navigation 3
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)

    //Browser
    implementation(libs.androidx.browser)

    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    //Navigation Test





    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}