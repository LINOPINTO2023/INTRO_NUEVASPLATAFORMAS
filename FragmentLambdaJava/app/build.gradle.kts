plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.fragmentlambdajava"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fragmentlambdajava"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation("androidx.fragment:fragment:1.4.0")  // Asegúrate de tener esta línea para fragments
    implementation("androidx.core:core-ktx:1.8.0")  // Biblioteca core-ktx para Kotlin
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
