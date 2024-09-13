rootProject.name = "quarkus-gradle-cdi-mcve"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    includeBuild("./gradle/build-logic")
}

include(
    "driven-adapters",
    "driving-adapters",
    "domain",
)