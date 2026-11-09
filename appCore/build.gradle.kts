plugins {
    alias(appCoreLibs.plugins.android.library)

    // ktlint
    alias(libs.plugins.ktlint)
}

// detekt
apply(from = rootProject.file("config/detekt/detekt.gradle"))

android {
    namespace = "br.com.leonardo.appcore"
    compileSdk = 37

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
    api(project(":appCore:data"))
    api(project(":appCore:domain"))
    api(project(":appCore:di"))
    api(project(":appCore:presentation"))

    api(appCoreLibs.androidx.appcompat)
    api(appCoreLibs.androidx.core.ktx)
    api(appCoreLibs.material)
    testImplementation(appCoreLibs.junit)
    androidTestImplementation(appCoreLibs.androidx.espresso.core)
    androidTestImplementation(appCoreLibs.androidx.junit)
}
