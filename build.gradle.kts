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
    apply{
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.asciidoctor.convert")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.plugin.jpa")
    }

    group = "project"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-mail")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.flywaydb:flyway-core")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.springframework.session:spring-session-core")
        implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        runtimeOnly("com.h2database:h2")
        runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
        testImplementation("org.springframework.security:spring-security-test")
        testImplementation("org.testcontainers:junit-jupiter")
        testImplementation("org.testcontainers:mariadb")
    }

    extra["snippetsDir"] = file("build/generated-snippets")
    extra["testcontainersVersion"] = "1.16.2"

    dependencyManagement {
        imports {
            mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
        }
    }

    java.sourceCompatibility = JavaVersion.VERSION_11

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
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