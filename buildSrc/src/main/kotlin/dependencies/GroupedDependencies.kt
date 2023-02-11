package dependencies
import core.Dependencies

internal val androidComposeBomDependencies = listOf(
    Dependencies.composeBom,
)

internal val androidComposeDependencies = listOf(
    Dependencies.coreKtx,
    Dependencies.composeGraphics,
    Dependencies.composeMaterialYou,
    Dependencies.composeMaterialTwo,
    Dependencies.composeActivity,
    Dependencies.composeUi,
    Dependencies.materialIconCore,
    Dependencies.composePreviewUi,
    Dependencies.materialIconExtended,
    Dependencies.composeConstraintLayout,
    Dependencies.composeNavigation,
    Dependencies.composePager,
    Dependencies.composePagerIndicator,
)

internal val androidxLifeCycleDependencies = listOf(
    Dependencies.viewModel,
    Dependencies.liveData,
    Dependencies.lifecycleRuntime,
    Dependencies.viewModelSaveState,
    Dependencies.lifecycleService,
)

internal val coroutinesAndroidDependencies = listOf(
    Dependencies.kotlinCoroutines,
)

internal val coilImageLoadingDependencies = listOf(
    Dependencies.coil,
)

internal val networkDependencies = listOf(
    Dependencies.retrofit,
    Dependencies.retrofitGsonConverter,
    Dependencies.gson,
    Dependencies.okhHttp3,
    Dependencies.okhHttp3Interceptor,
    Dependencies.rxJava3adapter,
)
