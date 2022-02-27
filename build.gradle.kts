import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.asciidoctor.convert") version "1.5.8"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
}

subprojects {
    extra["snippetsDir"] = file("build/generated-snippets")
    extra["testcontainersVersion"] = "1.16.2"

    repositories {
        mavenCentral()
    }

    group = "project"
    version = "0.0.1-SNAPSHOT"

    apply{
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.asciidoctor.convert")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.plugin.jpa")
    }

    java.sourceCompatibility = JavaVersion.VERSION_17

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }


    dependencyManagement {
        imports {
            mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
        }
    }


    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.test {
        outputs.dir("snippetsDir")
    }

    tasks.asciidoctor {
        inputs.dir("snippetsDir")
        attributes(
            mapOf(
                "snippets" to "./build/generated-snippets",
            )
        )
        dependsOn(tasks.test)
    }

}