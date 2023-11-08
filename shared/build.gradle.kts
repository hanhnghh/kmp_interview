plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.date)  // date functions in Kotlin
                implementation(libs.serialization)  // JSON serialization
                implementation(libs.ktor.core)
                implementation(libs.ktor.content)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serilization.json)
                implementation(libs.coroutines.core)
                implementation(libs.androidx.lifecycle.viewmodel)
//                api(libs.moko.mvvm)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.android)
                implementation(libs.koin.android.compose)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.ios)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
