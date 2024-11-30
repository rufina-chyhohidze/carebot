plugins {
    java
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("jvm") version "1.8.10" // Add Kotlin plugin if you are using Kotlin
    kotlin("plugin.spring") version "1.8.10" // Add Spring plugin for Kotlin support
}

group = "be.kdg.programming3"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    "developmentOnly"("org.springframework.boot:spring-boot-devtools")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.webjars:bootstrap:5.3.2")
    implementation("org.webjars.npm:bootstrap-icons:1.11.1")
    implementation("org.webjars:webjars-locator-core:0.48")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-websocket")


}

tasks.withType<Test> {
    useJUnitPlatform()
}
