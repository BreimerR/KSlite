buildscript {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
    }

    val kotlinVersion: String by project

    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}


allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()

    }
}