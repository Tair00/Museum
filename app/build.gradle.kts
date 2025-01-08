plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}
android {
    namespace = "com.example.museum"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.museum"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Kotlin dependencies
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")

    // Retrofit for API calls
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.google.android.material:material:1.12.0")
    // OkHttp for networking
    implementation("com.squareup.okhttp3:okhttp:4.9.0")

    // Gson for JSON parsing
    implementation("com.google.code.gson:gson:2.8.8")

    // Lifecycle components (for ViewModel)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

    // For Retrofit logging (optional but useful)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // AndroidX dependencies
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // Test dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}