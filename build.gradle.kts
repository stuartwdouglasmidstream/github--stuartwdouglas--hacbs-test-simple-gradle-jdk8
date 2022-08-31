plugins {
    `java-library`
    `maven-publish`
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withJavadocJar()
    withSourcesJar()
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.9.0")
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "org.github.stuartwdouglas.hacbs-test.gradle"
            pom {
                name.set("HACBS Test Simple Gradle JDK8")
                description.set("Test data for HACBS JVM build service (Gradle version)")
                url.set("https://github.com/stuartwdouglas/hacbs-test-simple-gradle-jdk8")
                properties.set(mapOf(
                    "maven.compiler.source" to "1.8",
                    "maven.compiler.target" to "1.8"
                ))
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("dwalluck")
                        name.set("David Walluck")
                        email.set("dwalluck@redhat.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/stuartwdouglas/hacbs-test-simple-gradle-jdk8.git")
                    developerConnection.set("scm:git:ssh://github.com/stuartwdouglas/hacbs-test-simple-gradle-jdk8.git")
                    url.set("http://github.com/stuartwdouglas/hacbs-test-simple-gradle-jdk8/")
                }
            }
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots"))
            password.set(System.getenv("NEXUS_PASSWORD"))
            username.set(System.getenv("NEXUS_USERNAME"))
        }
    }
}
