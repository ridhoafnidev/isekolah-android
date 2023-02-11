import dependencies.addDataModule

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.smpsantoyosef.home"
}

dependencies {
    addDataModule()
}