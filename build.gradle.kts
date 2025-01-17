plugins {
    kotlin("multiplatform") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
}

val ktorVersion = "1.4.1"
val coroutinesVersion = "1.4.1"
val serializationVersion = "1.0.1"

allprojects {

    plugins.apply("org.jetbrains.kotlin.multiplatform")
    plugins.apply("org.jetbrains.kotlin.plugin.serialization")

    repositories {
        mavenCentral()
        jcenter()
    }

    kotlin {

        jvm {
            compilations.all {
                kotlinOptions.jvmTarget = "1.8"
            }
            testRuns["test"].executionTask.configure {
                useJUnitPlatform()
            }
        }

        val hostOs = System.getProperty("os.name")
        val isMingwX64 = hostOs.startsWith("Windows")

        val nativeTarget = when {
            hostOs == "Mac OS X" -> macosX64("native")
            hostOs == "Linux" -> linuxX64("native")
            isMingwX64 -> mingwX64("native")
            else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
        }

        sourceSets {
            val commonMain by getting {
                dependencies {
                    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
                    implementation("io.ktor:ktor-network:$ktorVersion")
                    implementation("io.ktor:ktor-io:$ktorVersion")
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                }
            }
            val commonTest by getting {
                dependencies {
                    implementation(kotlin("test-common"))
                    implementation(kotlin("test-annotations-common"))
                }
            }
            val jvmMain by getting
            val jvmTest by getting {
                dependencies {
                    implementation(kotlin("test-junit5"))
                    implementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
                    runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
                }
            }
            val nativeMain by getting
            val nativeTest by getting
        }
    }

}
