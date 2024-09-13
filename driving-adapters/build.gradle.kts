plugins {
    id("kotlin-conventions")
    id("quarkus-conventions")
}

dependencies {
    implementation(project(":domain"))
}

tasks.quarkusDependenciesBuild { dependsOn(tasks.jandex) }
tasks.quarkusAppPartsBuild { dependsOn(tasks.jandex) }