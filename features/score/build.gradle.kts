import dependencies.addDataModule

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.smpsantoyosef.score"
}

dependencies {
    addDataModule()
}