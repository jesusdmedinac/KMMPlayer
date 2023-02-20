plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "io.beek.android.beekplayer"
    compileSdk = 33
    defaultConfig {
        applicationId = "io.beek.android.beekplayer"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.3.2")
    implementation("androidx.compose.ui:ui-tooling:1.3.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.2")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.activity:activity-compose:1.6.1")

    implementation("org.orbit-mvi:orbit-compose:4.5.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("dev.icerock.moko:mvvm-flow-compose:0.15.0")

    compileOnly("io.realm.kotlin:library-base:1.5.0")
}