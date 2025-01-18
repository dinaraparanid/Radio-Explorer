plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
}

android {
    namespace = "com.paranid5.radio_explorer"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.paranid5.radio_explorer"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":core:resources"))

    implementation(project(":feature:root"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)

    implementation(libs.hilt.android)
    implementation(libs.hilt.android.graddle.plugin)
    kapt(libs.hilt.compiler)
}

kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = false
}