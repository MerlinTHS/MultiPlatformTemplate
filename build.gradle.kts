import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform") version "1.8.0"
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
}

group = "io.kava.template"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xcontext-receivers")
            }
        }
    }

    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation("io.github.merlinths:kava-core:1.0.0")
                implementation("io.github.merlinths:kava-annotations:1.0.3")
            }

            kotlin.srcDir("build/generated/ksp/jvm/jvmMain")
        }
        val jvmTest by getting {
            dependencies {
                implementation("io.github.merlinths:kava-core:1.0.0")
                implementation("io.github.merlinths:kava-annotations:1.0.3")
            }

            kotlin.srcDir("build/generated/ksp/jvm/jvmTest")
        }
    }
}

dependencies {
    add("kspJvm", "io.github.merlinths:kava-processor:1.0.1")
    add("kspJvmTest", "io.github.merlinths:kava-processor:1.0.1")
}