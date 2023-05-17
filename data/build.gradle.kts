import dependencies.addApiResponseModule
import dependencies.addCommonModule
import dependencies.addDiModule
import dependencies.addDomainModule

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.smpsantoyosef.data"
}

dependencies {
    addApiResponseModule()
    addDiModule()
    addDomainModule()
    addCommonModule()
}