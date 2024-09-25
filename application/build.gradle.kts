plugins {
    id("kotlin-conventions")
    alias(libs.plugins.quarkus.gradle)
}

dependencies {
    implementation(project(":driving-adapters"))
    implementation(project(":driven-adapters"))
    implementation(enforcedPlatform(libs.quarkus.platform))
    implementation(libs.quarkus.arc)
    implementation(libs.quarkus.kotlin.extension)
    // Required according to Quarkus:
    // https://quarkus.io/guides/kotlin#important-gradle-configuration-points
    implementation(libs.quarkus.kotlin.stdlib)
}

tasks.quarkusDependenciesBuild {
    dependsOn(tasks.jandex)
}

// Required if running tests with QuarkusTest annotation.
// https://quarkus.io/guides/logging#configure-logging-for-quarkustest
tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}

quarkus {
    quarkusBuildProperties.put("quarkus.grpc.codegen.proto-directory", "${project.projectDir}/driven-adapters/src/main/proto")
}
