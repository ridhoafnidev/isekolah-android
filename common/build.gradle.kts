import dependencies.addEntityModule
import dependencies.addSystemUiControllerDependencies

plugins {
    plugins.`android-base-library`
}
android {
    namespace = "com.smpsantoyosef.common"
}
dependencies {
    addEntityModule()
}