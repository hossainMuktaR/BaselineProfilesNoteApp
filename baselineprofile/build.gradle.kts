import com.android.build.api.dsl.ManagedVirtualDevice

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidTest)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.androidx.baselineprofile)
}

android {
    namespace = "com.example.benchmark"
    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    defaultConfig {
        minSdk = 28
        targetSdk = 34

//        testInstrumentationRunnerArguments["androidx.benchmark.suppressErrors"] = "EMULATOR"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    targetProjectPath = ":app"

//    testOptions.managedDevices.devices {
//        create<ManagedVirtualDevice>("pixel7api34") {
//            device = "Pixel 7"
//            apiLevel = 34
//            systemImageSource = "aosp"
//        }
//    }
}
// This is the configuration block for the Baseline Profile plugin.
// You can specify to run the generators on a managed devices or connected devices.
baselineProfile {
//    managedDevices += "pixel7api34"
    useConnectedDevices = true
}

dependencies {
    implementation(libs.atest.ext.junit)
    implementation(libs.atestespresso.core)
    implementation(libs.uiautomator)
    implementation(libs.benchmark.macro.junit4)
}
