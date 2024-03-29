@file:Suppress("DEPRECATION")

plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("kotlin-android")
//    id("com.android.library")



}

android {
    namespace = "com.moutimid.sqlapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.moutamid.sqlapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        setProperty("archivesBaseName", "MyTrips-$versionName")

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

    }
    kotlinOptions {
        jvmTarget = "17"
    }

//    buildFeatures {
//        viewBinding = true
//        compose = true
////    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_18
//        targetCompatibility = JavaVersion.VERSION_18
//    }
    packagingOptions {
        exclude("META-INF/NOTICE.md")
        exclude("META-INF/NOTICE")
        exclude("META-INF/LICENSE.md")
        exclude("META-INF/LICENSE")
    }


}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    implementation("com.github.ibrahimsn98:SmoothBottomBar:1.7.9")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.fxn769:stash:1.3.2")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.sun.mail:android-mail:1.6.7")
    implementation("com.sun.mail:android-activation:1.6.7")
    implementation("com.github.barteksc:android-pdf-viewer:2.8.2")
    implementation("io.github.chochanaresh:filepicker:0.1.9")
    implementation(platform("com.google.firebase:firebase-bom:32.2.3"))
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-analytics")
//    implementation(project(":calender"))

}