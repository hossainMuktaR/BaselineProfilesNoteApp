
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.dagger.hilt.android)
    id(libs.plugins.google.devtools.ksp.get().pluginId)
    alias(libs.plugins.androidx.baselineprofile)

}

android {
    namespace = "com.example.noteapp_architecture_sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.noteapp_architecture_sample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    signingConfigs {
//        // We use a bundled debug keystore, to allow debug builds from CI to be upgradable
//        getByName("debug") {
//            storeFile = rootProject.file("debug.keystore")
//            storePassword = "android"
//            keyAlias = "androiddebugkey"
//            keyPassword = "android"
//        }
    }

    buildTypes {
//        getByName("debug") {
//            signingConfig = signingConfigs.getByName("debug")
//        }
        getByName("release") {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(platform(libs.kotlin.bom))
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.atest.ext.junit)
    androidTestImplementation(libs.atestespresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.test.ui.junit4)
    debugImplementation(libs.debug.ui.tooling)
    debugImplementation(libs.debug.ui.tooling)

//    Compose dependencies
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.navigation.compose)
    implementation(libs.material.icons.extended)
    implementation(libs.hilt.navigation.compose)

    // Dagger-Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    ksp(libs.hilt.android.compiler)

    // Room
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)

    // Kotlin Extensions and Coroutines support for Room
    implementation(libs.room.ktx)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //profile installer
    implementation(libs.androidx.profileinstaller)
    "baselineProfile"(project(mapOf("path" to ":baselineprofile")))

}