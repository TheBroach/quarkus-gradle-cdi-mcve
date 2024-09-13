import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("io.quarkus")
}

// Work-around to make the Version Catalog from the "outer" Gradle project
// visible when building this project.
// https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
val libs = the<LibrariesForLibs>()

dependencies {
    implementation(enforcedPlatform(libs.quarkus.platform))
    implementation(libs.quarkus.arc)
    implementation(libs.quarkus.kotlin.extension)
    // Required according to Quarkus:
    // https://quarkus.io/guides/kotlin#important-gradle-configuration-points
    implementation(libs.quarkus.kotlin.stdlib)
}

// Required if running tests with QuarkusTest annotation.
// https://quarkus.io/guides/logging#configure-logging-for-quarkustest
tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
