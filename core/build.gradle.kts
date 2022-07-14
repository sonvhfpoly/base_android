plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.androidLibraryKotlin)
    kotlin(BuildPlugins.kaptKotlin)
    id(BuildPlugins.hilt)
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
}

dependencies {

    // Room
    api(Dependencies.roomRuntime)
    api(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)

    // Hilt
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)

    // retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.loggingInterceptor)
    implementation(Dependencies.gsonConverter)

    // paging
    implementation(Dependencies.paging)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}