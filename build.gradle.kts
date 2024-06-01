plugins {
    kotlin("multiplatform") version "2.0.0"
}

group = "com.sydory"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser {}
        binaries.executable()
    }
    sourceSets {
        jsMain.dependencies {
            // https://github.com/JetBrains/kotlin-wrappers/tree/master
            fun kotlinw(target: String): String =
                "org.jetbrains.kotlin-wrappers:kotlin-$target"

            val kotlinWrappersVersion = "1.0.0-pre.754"

            dependencies {
                implementation(platform(kotlinw("wrappers-bom:$kotlinWrappersVersion")))
                implementation(kotlinw("react"))
                implementation(kotlinw("react-dom"))
            }
        }
    }
}
