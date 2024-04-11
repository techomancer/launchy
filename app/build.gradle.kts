plugins {
    id("com.android.application")
}

android {
    namespace = "com.mikedg.android.glass.launchy"
    compileSdk = 19
    lint {
        disable.add("ExpiredTargetSdkVersion")
        //abortOnError = false
    }

    defaultConfig {
        applicationId = "com.mikedg.android.glass.launchy"
        minSdk = 19
        targetSdk = 19
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
    buildToolsVersion = "34.0.0"
}
dependencies {
    implementation(files(android.sdkDirectory.toString() + "/add-ons/addon-google_gdk-google-19/libs/gdk.jar"))
}

