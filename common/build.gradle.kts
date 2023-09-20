plugins {
    id("java")
    id("io.spring.dependency-management") version "1.1.3"
}

group = "com.jcanseco.dev.bank.minibank.common"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

extra["springBootVersion"] = "3.1.3"

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:${property("springBootVersion")}"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("org.apache.commons:commons-lang3:3.13.0")
}
