import dependencies.addDataModule

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.smpsantoyosef.feature.note"
}

dependencies {
    addDataModule()
}