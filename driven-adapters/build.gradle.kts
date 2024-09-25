plugins {
    id("kotlin-conventions")
    alias(libs.plugins.google.protobuf)
}

dependencies {
    implementation(project(":domain"))
    implementation(enforcedPlatform(libs.quarkus.platform))
    implementation(libs.quarkus.arc)
    implementation(libs.quarkus.kotlin.extension)
    // Required according to Quarkus:
    // https://quarkus.io/guides/kotlin#important-gradle-configuration-points
    implementation(libs.quarkus.kotlin.stdlib)

    implementation(libs.quarkus.grpc)
}
