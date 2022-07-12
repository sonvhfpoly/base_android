object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidKotlin = "android"
    const val kaptKotlin = "kapt"
    const val hilt = "dagger.hilt.android.plugin"
}

object AppConfig {
    const val appId = "com.vnextglobal.base"
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildConfig {
    const val release = "release"
    const val debug = "debug"
    const val jvmTarget = "11"
    const val defaultProguardFile = "proguard-android-optimize.txt"
    const val proguardRules = "proguard-rules.pro"
}

object Dependencies {

    private object Versions{
        // Core libs
        const val coreKtx = "1.8.0"
        const val appcompat = "1.4.2"
        const val material = "1.6.1"
        const val constraint = "2.1.4"
        // Navigation
        const val navVersion = "2.5.0"
        // Test libs
        const val junit = "4.13.2"
        const val androidJunit = "1.1.3"
        const val espresso = "3.4.0"
        // Room
        const val roomVersion = "2.4.2"
        //Hilt
        const val hilt = "2.38.1"
    }

    // Core libs
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    // Navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    // Test libs
    const val junit = "junit:junit:${Versions.junit}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    // Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
}