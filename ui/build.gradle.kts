plugins {
    alias(libs.plugins.android.library)

    //compose compiler
    alias(libs.plugins.compose.compiler)

    //Kotlin Serialization (for navigation version)
    kotlin("plugin.serialization") version "2.3.10"
}

android {
    namespace = "br.com.leonardo.ui"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.ui)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    //koin for compose
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.compose.navigation3)

    //Navigation 3
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)


    //Kotlin Serialization (for navigation version)
    implementation(libs.kotlinx.serialization.json)


    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}