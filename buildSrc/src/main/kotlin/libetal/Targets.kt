package libetal

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetWithHostTests


fun KotlinMultiplatformExtension.nativeTarget(configure: KotlinNativeTargetWithHostTests.() -> Unit = {}) =
    when (val osName = System.getProperty("os.name")) {
        "Mac OS X" -> macosX64("native", configure)
        "Linux" -> linuxX64("native", configure)
        else -> when (osName.contains("Windows".toRegex())) {
            else -> throw RuntimeException("Unsupported build target system")
        }
    }