package core

internal object Versions {
    //region compose

    const val composeConstraintLayout = "1.0.1"
    const val composeVersion = "1.3.1"
    const val composeBom = "2022.10.00"
    const val coreKtxVersion = "1.8.0"
    const val materialVersion = "1.3.1"
    const val activityComposeVersion = "1.6.1"
    const val pagerComposeVersion = "0.13.0"
    const val pagerIndicatorComposeVersion = "0.13.0"

    //endrefion
    //region retrofit

    const val retrofitVersion = "2.9.0"
    const val gsonVersion = "2.9.1"
    const val okhttp3Version = "4.10.0"

    //endregion
    //region compose navigation

    const val composeNavigationVersion = "2.5.3"

    //endregion
    //region hilt

    val hiltVersion:String = System.getProperty("hiltVersion")
    const val hiltNavigationComposeVersion = "1.0.0"

    //region ext library

    const val timberVersion = "5.0.1"

    //endregion
    //region coil

    const val coilVersion = "2.2.2"

    //endrefion

    const val lifecycleVersion = "2.5.1"
    const val coroutinesVersion = "1.3.9"

    //region canary

    const val leakcanaryVersion = "2.9.1"

    //endregion
    //region test

    const val espressoCoreVersion = "3.5.0"
    const val jUnitVersion = "4.13.2"
    const val jUnitExtVersion = "1.1.4"

    //endregion
    //region datastore preferences

    const val dataStore = "1.0.0"

    //endregion
    //region splashscreen

    const val splashScreen = "1.0.0"

    //endregion
    //region room

    const val roomRuntime = "2.4.3"
    const val roomCompiler = "2.4.3"
    const val roomKtx = "2.4.3"

    //endregion
    //region maps

    const val maps = "2.4.0"
    const val mapsServices = "18.1.0"
    const val serviceLocation = "20.0.0"

    //endregion

}