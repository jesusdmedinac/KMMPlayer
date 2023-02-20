plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("io.realm.kotlin") version "1.5.0"
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "MultiPlatformLibrary"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.orbit-mvi:orbit-core:4.5.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("io.realm.kotlin:library-base:1.5.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.orbit-mvi:orbit-test:4.5.0")
                implementation("dev.icerock.moko:mvvm-test:0.15.0")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("org.orbit-mvi:orbit-compose:4.5.0")
                implementation("dev.icerock.moko:mvvm-flow-compose:0.15.0")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("org.orbit-mvi:orbit-test:4.5.0")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
            dependencies {
                implementation("dev.icerock.moko:mvvm-core:0.15.0")
                implementation("dev.icerock.moko:mvvm-flow:0.15.0")
            }
        }
    }
}

android {
    namespace = "io.beek.android.beekplayer"
    compileSdk = 32
    defaultConfig {
        minSdk = 23
        targetSdk = 32
    }
}