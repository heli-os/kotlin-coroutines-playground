plugins {
    kotlin("jvm") version "1.6.21"
}

group = "kr.dataportal"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation(kotlin("stdlib"))
}
