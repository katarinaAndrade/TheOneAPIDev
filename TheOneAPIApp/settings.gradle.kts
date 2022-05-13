enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "TheOneAPI"
include (":app")
include (
    ":config:ui",
    ":config:navigation",
    ":config:network"
)
include(
    ":home:ui",
    ":home:domain"
)