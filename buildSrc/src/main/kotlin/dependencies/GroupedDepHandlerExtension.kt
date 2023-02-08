package dependencies
import core.Dependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addAndroidComposeDependencies(){
    androidComposeBomDependencies.forEach {
        add("implementation", platform(it))
    }
    androidComposeDependencies.forEach {
        add("implementation",it)
    }
}


fun DependencyHandler.addAndroLifeCycleDependencies(){
    androidxLifeCycleDependencies.forEach {
        add("implementation",it)
    }
}


fun DependencyHandler.addCoroutinesAndroidDependencies(){
    coroutinesAndroidDependencies.forEach {
        add("implementation",it)
    }
}

fun DependencyHandler.addCoilImageLoadingDependencies(){
    coilImageLoadingDependencies.forEach {
        add("implementation",it)
    }
}

fun DependencyHandler.addNetworkDependencies(configurationName:String = "implementation"){
    networkDependencies.forEach {
        add(configurationName,it)
    }
}

fun DependencyHandler.addHiltDependencies() {
    add("implementation",Dependencies.hiltAndroid)
    add("implementation",Dependencies.hiltNavCompose)
    add("kapt",Dependencies.hiltCompiler)
}

fun DependencyHandler.addTimberDependencies(configurationName:String = "implementation"){
    add(configurationName,Dependencies.timber)
}

fun DependencyHandler.addGsonDependencies(configurationName:String = "implementation"){
    add(configurationName,Dependencies.gson)
}

fun DependencyHandler.addLeakcanaryDependencies(){
    add("debugImplementation",Dependencies.leakcanary)
}

fun DependencyHandler.addDataStoreDependencies(){
    add("implementation",Dependencies.dataStore)
}

fun DependencyHandler.addSplashScreenDependencies(){
    add("implementation",Dependencies.splashScreen)
}

fun DependencyHandler.addAndroidTestsDependencies() {
    add("testImplementation",Dependencies.jUnit)
    add("androidTestImplementation",Dependencies.jUnitTestUi)
    add("androidTestImplementation",Dependencies.jUnitExt)
    add("debugImplementation",Dependencies.composeTooling)
    add("debugImplementation",Dependencies.composeTestManifest)
    add("androidTestImplementation",Dependencies.espresso)
}

val roomLibraries = listOf(
    Dependencies.roomRuntime,
    Dependencies.roomKtx
)
val roomKaptLibraries = listOf(
    Dependencies.roomCompiler
)
fun DependencyHandler.addRoomDependencies() {
    implementation(roomLibraries)
    kapt(roomKaptLibraries)
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.implementationPlatform(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", platform(dependency))
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}
