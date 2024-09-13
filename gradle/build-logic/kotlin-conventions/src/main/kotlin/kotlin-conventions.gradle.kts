import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    kotlin("jvm")
    // https://kotlinlang.org/docs/all-open-plugin.html
    kotlin("plugin.allopen")
    // Quarkus does not discover CDI beans in different Gradle sub-projects automatically.
    // This unofficial plugin removes the need for specifying a META-INF/beans.xml file manually.
    // https://quarkus.io/guides/gradle-tooling#multi-module-gradle
    id("org.kordamp.gradle.jandex")
}

// Work-around to make the Version Catalog from the "outer" Gradle project
// visible when building this project.
// https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
val libs = the<LibrariesForLibs>()

dependencies {
    implementation(libs.kotlin.logging)
}

kotlin {
    // https://jakewharton.com/gradle-toolchains-are-rarely-a-good-idea/
    // The critique in the article seems to circle around using old JDKs,
    // or mixing different JDK versions. This project does neither.
    jvmToolchain(21)
    compilerOptions {
        // Required according to Quarkus:
        // https://quarkus.io/guides/kotlin#important-gradle-configuration-points
        javaParameters.set(true)
    }
}

allOpen {
    annotation("jakarta.enterprise.context.ApplicationScoped")
}