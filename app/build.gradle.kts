plugins {
    id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.androidKotlin)
    kotlin(BuildPlugins.kaptKotlin)
    id(BuildPlugins.hilt)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.appId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    buildTypes {
        getByName(BuildConfig.release) {
            isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile(BuildConfig.defaultProguardFile), BuildConfig.proguardRules)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = BuildConfig.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Core libs
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraint)

    // Navigation
    implementation(Dependencies.navigationUiKtx)
    implementation(Dependencies.navigationFragment)

    // Test
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidJunit)
    androidTestImplementation(Dependencies.espresso)

    // Room
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)

    // Hilt
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}