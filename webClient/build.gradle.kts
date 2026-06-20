plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "br.com.leonardo.webClient"
    compileSdk = 36

    buildFeatures { buildConfig = true }

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {

        debug {
            buildConfigField("boolean", "ENABLE_HTTP_LOG", "true")
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("boolean", "ENABLE_HTTP_LOG", "false")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    //koin for compose
    implementation(libs.koin.androidx.compose)

    //koin tests
    testImplementation(libs.koin.test)
    testImplementation(libs.koin.test.junit4)

    //Kotlin coroutines tests
    testImplementation(libs.kotlinx.coroutines.test)

    testImplementation(libs.mockk)


    //Retrofit + Converter + Logging interceptor
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}