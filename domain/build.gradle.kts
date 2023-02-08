import dependencies.addEntityModule

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.smpsantoyosef.domain"
}

dependencies {
    addEntityModule(configurationName = "api")
}