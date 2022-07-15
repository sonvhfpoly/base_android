plugins {
    id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.androidKotlin)
    kotlin(BuildPlugins.kaptKotlin)
    id(BuildPlugins.hilt)
    id(BuildPlugins.safeargs)
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
    // local modules
    implementation(project(Dependencies.repoModule))
    implementation(project(Dependencies.androidFramework))
    // Core libs
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraint)
    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.activityKtx)
    implementation(Dependencies.swipeRefreshLayout)

    // Navigation
    implementation(Dependencies.navigationUiKtx)
    implementation(Dependencies.navigationFragment)

    // Test
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidJunit)
    androidTestImplementation(Dependencies.espresso)

    // Room
    api(Dependencies.roomRuntime)
    api(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)

    // Hilt
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)

    // retrofit
    implementation(Dependencies.retrofit)

    // paging
    implementation(Dependencies.paging)

    // glide
//    implementation(Dependencies.glide)
//    kapt(Dependencies.glideProcessor)

    // coild
    implementation(Dependencies.coil)

    implementation(Dependencies.imageSlider)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}