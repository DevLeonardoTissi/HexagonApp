plugins {
    alias(appCoreLibs.plugins.android.library)
}

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
    implementation(project(":appCore:data"))
    implementation(project(":appCore:domain"))
    implementation(project(":appCore:di"))
    implementation(project(":appCore:presentation"))

    implementation(appCoreLibs.androidx.appcompat)
    implementation(appCoreLibs.androidx.core.ktx)
    implementation(appCoreLibs.material)
    testImplementation(appCoreLibs.junit)
    androidTestImplementation(appCoreLibs.androidx.espresso.core)
    androidTestImplementation(appCoreLibs.androidx.junit)
}
