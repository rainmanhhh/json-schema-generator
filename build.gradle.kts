import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.4.10"
  `maven-publish`
}

group = "com.github.rainmanhhh"
version = "0.0.5"

repositories {
  mavenLocal()
  maven("https://maven.aliyun.com/repository/public")
  maven("https://jitpack.io")
  jcenter()
}

dependencies {
  implementation(kotlin("stdlib"))
  api("com.github.victools:jsonschema-generator:4.16.0")
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events = setOf(PASSED, SKIPPED, FAILED)
  }
}

publishing {
  repositories {
    mavenLocal()
  }
  publications {
    create<MavenPublication>("maven") {
      groupId = group.toString()
      artifactId = rootProject.name
      version = rootProject.version.toString()
      from(components["kotlin"])
    }
  }
}
