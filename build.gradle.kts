plugins {
    id("java")
}

group = "com.c4b"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.codeborne:selenide:7.5.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.3.0")


tasks.test {
    useJUnitPlatform()
}}