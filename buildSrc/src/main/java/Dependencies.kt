object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidKotlin = "android"
    const val kaptKotlin = "kapt"
    const val hilt = "dagger.hilt.android.plugin"
    const val androidLibrary = "com.android.library"
    const val androidLibraryKotlin = "org.jetbrains.kotlin.android"
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
    const val consumerRules = "consumer-rules.pro"
}

object Dependencies {

    private object Versions{
        // Core libs
        const val coreKtx = "1.8.0"
        const val appcompat = "1.4.2"
        const val material = "1.6.1"
        const val constraint = "2.1.4"
        const val fragmentKtx = "1.5.0"
        const val activityKtx = "1.5.0"
        // Navigation
        const val navVersion = "2.5.0"
        // Test libs
        const val junit = "4.13.2"
        const val androidJunit = "1.1.3"
        const val espresso = "3.4.0"
        // Room
        const val roomVersion = "2.4.2"
        //Hilt
        const val hilt = "2.42"
        // retrofit
        const val retrofit = "2.9.0"
        const val loggingInterceptor = "4.10.0"
        const val gsonConverter = "2.9.0"
        // paging
        const val pagingVersion = "3.1.1"
        //glide
        const val glide = "4.13.2"
        // coil
        const val coil = "2.1.0"
    }

    // modules
    const val repoModule = ":core"
    const val androidFramework = ":aframework"
    // Core libs
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
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
    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
    const val paging = "androidx.paging:paging-runtime:${Versions.pagingVersion}"
    // glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
    // coil
    const val coil = "io.coil-kt:coil:${Versions.coil}"
}