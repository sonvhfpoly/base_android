plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.androidLibraryKotlin)
    kotlin(BuildPlugins.kaptKotlin)
    id(BuildPlugins.safeargs)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        consumerProguardFiles(BuildConfig.consumerRules)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(BuildConfig.defaultProguardFile),
                BuildConfig.proguardRules
            )
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
    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.activityKtx)
    implementation(Dependencies.swipeRefreshLayout)

    // glide
//    implementation(Dependencies.glide)
//    kapt(Dependencies.glideProcessor)

    // coil
    implementation(Dependencies.coil)

    // Navigation
    implementation(Dependencies.navigationUiKtx)
    implementation(Dependencies.navigationFragment)
}