import dependencies.addApiResponseModule

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.smpsantoyosef.feature.auth"
}

dependencies {
    addApiResponseModule(configurationName = "api")
}