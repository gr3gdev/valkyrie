plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
    runtimeOnly("org.postgresql:postgresql")
	compileOnly("org.projectlombok:lombok")
    developmentOnly("com.h2database:h2")
	annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("com.h2database:h2")
}

configurations.implementation {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    exclude(group = "io.undertow", module = "undertow-websockets-jsr")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register<org.springframework.boot.gradle.tasks.run.BootRun>("bootRunDev") {
    group = "application"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass = "com.github.gr3gdev.valkyrie.ValkyrieApplication"
    systemProperty("spring.profiles.active", "dev")
}
