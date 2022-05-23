import libetal.nativeTarget

plugins {
    kotlin("multiplatform")
}

group = "libetal.libraries.sqlite"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {

    nativeTarget {
        val nativeInteropDir = File(projectDir, "src/nativeInterop")
        val nativeInteropKotlinDir = File(nativeInteropDir, "kotlin").also {
            if (!it.exists()) it.mkdirs()
        }
        val interopFile = File(nativeInteropKotlinDir, "interop.def")
        val includes = listOf(
            "/usr/include",
            "/usr/local/include",
            "/usr/include/x86_64-linux-gnu",
            "$nativeInteropDir/sqlite3/include"
        )
        val libraryPaths = listOf(
            "/usr/lib",
            "/usr/local/lib /opt/usr/lib",
            "$nativeInteropDir/sqlite3/cmake-build-release"
        )

        val compilerIncludes = includes.joinToString(" -I")
        interopFile.outputStream().use { stream ->
            stream.writer().use { writer ->
                writer.write(
                    """|headers=sqlite3.h library.h
                       |staticLibraries = libsqlite3.a
                       |libraryPaths = ${libraryPaths.joinToString(" ")}
                       |compilerOpts.linux = -I${compilerIncludes}
                    """.trimMargin()
                )
            }
        }
        val main by compilations.getting
        val sqlite by main.cinterops.creating {
            defFile = interopFile
            packageName = "libetal.interop"
        }
    }


    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val nativeMain by getting
        val nativeTest by getting
    }
}
