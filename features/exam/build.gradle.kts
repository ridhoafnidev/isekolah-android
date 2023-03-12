import dependencies.addDataModule

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.smpsantoyosef.feature.score"
}

dependencies {
    addDataModule()
}