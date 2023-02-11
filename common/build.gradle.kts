import dependencies.addEntityModule

plugins {
    plugins.`android-base-library`
}
android {
    namespace = "com.smpsantoyosef.common"
}
dependencies {
    addEntityModule()
}