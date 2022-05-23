plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

val kotlinVersion: String = "1.6.20"

dependencies {
    implementation(kotlin("gradle-plugin", kotlinVersion))
}