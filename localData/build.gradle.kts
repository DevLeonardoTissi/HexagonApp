plugins {
    alias(libs.plugins.android.library)

    //KSP - processor
    alias(libs.plugins.ksp)
}

android {
    namespace = "br.com.leonardo.localData"
    compileSdk = 36

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "br.com.leonardo.localData.DatabaseInstrumentationTestRunner"
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
    testImplementation (libs.kotlinx.coroutines.test)

    //Room database
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}