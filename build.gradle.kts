plugins {
    kotlin("jvm") version "1.4.10"
}

group = "com.rainmanhhh.github"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    maven("https://maven.aliyun.com/repository/public")
    maven("https://jitpack.io")
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.victools:jsonschema-generator:4.16.0")
}
