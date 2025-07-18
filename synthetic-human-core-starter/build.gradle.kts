plugins {
	java
	`java-library`
	`maven-publish`
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.BarbirMS"
version = "0.0.1-SNAPSHOT"

publishing {
	group = "com.BarbirMS"
	version = "0.0.2-SNAPSHOT"

	publications {
		create<MavenPublication>("synthetic-human-core-starter") {
			from(components["java"])
		}
	}

	repositories {
		mavenLocal()
	}
}

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter:3.5.3")
	implementation("org.springframework.boot:spring-boot-starter-aop:3.5.3")
	implementation("org.springframework.boot:spring-boot-starter-json:3.5.3")
	implementation("org.springframework.kafka:spring-kafka:3.3.7")
	implementation("org.springframework.boot:spring-boot-starter-web:3.5.3")
	implementation("org.springframework.boot:spring-boot-starter-actuator:3.5.3")
	implementation("io.micrometer:micrometer-registry-prometheus:1.15.2")
	implementation("io.micrometer:micrometer-bom:1.15.2")
	implementation("io.github.mweirauch:micrometer-jvm-extras:0.2.2");

}