import dependencies.addTimberDependencies

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.smpsantoyosef.di"
}

dependencies {
    addTimberDependencies(configurationName = "api")
}