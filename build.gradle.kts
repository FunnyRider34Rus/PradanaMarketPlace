buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.45")
    }

    repositories {
        mavenCentral()
    }
}

plugins {
    id("com.android.application") version "8.1.0-alpha09" apply false
    id("com.android.library") version "8.1.0-alpha09" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}