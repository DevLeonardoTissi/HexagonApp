plugins {
    alias(libs.plugins.android.library)

    // ktlint
    alias(libs.plugins.ktlint)
}

// detekt
apply(from = rootProject.file("config/detekt/detekt.gradle"))

android {
    namespace = "br.com.leonardo.appcore.data"
    compileSdk = 37

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField("boolean", "ENABLE_HTTP_LOG", "true")
        }
        release {
            isMinifyEnabled = false
            buildConfigField("boolean", "ENABLE_HTTP_LOG", "false")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    api(project(":appCore:di"))
    api(project(":appCore:domain"))

    // Firebase
    api(platform(libs.firebase.bom))
    api(libs.google.firebase.analytics)
    api(libs.firebase.crashlytics)

    // koin for compose
    api(libs.koin.androidx.compose)

    // Retrofit + Converter + Logging interceptor
    api(libs.retrofit)
    api(libs.converter.gson)
    api(libs.logging.interceptor)

    // Coil
    api(libs.coil3.coil.compose)
    api(libs.coil.network.okhttp)

    api(libs.androidx.appcompat)
    api(libs.androidx.core.ktx)
    api(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
