import dependencies.addMapsDependencies

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.smpsantoyosef.feature.absent"
}

dependencies {
    addMapsDependencies()
}