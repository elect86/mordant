import org.jetbrains.dokka.ReflectDsl.get

apply(plugin = "org.jetbrains.dokka")
apply(plugin = "maven")


buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.2")
    }
}

apply(plugin = "com.jfrog.bintray")

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.ajalt:colormath:1.2.0")
}

val sourcesJar = task<Jar>("sourcesJar") {
    dependsOn("classes")
    archiveClassifier.set("sources")
    from(sourceSets.main["allSource"])
}

val javadoc = tasks.getByName<Javadoc>("javadoc")

val dokkaJavadoc = task<org.jetbrains.dokka.gradle.DokkaTask>("dokkaJavadoc") {
    outputFormat = "javadoc"
    outputDirectory = javadoc.destinationDir.toString()
}

val javadocJar = task<Jar>("javadocJar") {
    dependsOn("dokkaJavadoc")
    archiveClassifier.set("javadoc")
    from(javadoc.destinationDir)
}

artifacts {
    archives(sourcesJar)
    archives(javadocJar)
}

extra.apply {

    set("pkgName", "mordant")
    set("pkgDesc", "Full-featured text styling for Kotlin command-line applications")
    set("githubRepo", "github.com/ajalt/mordant")
    set("pkgLicense", "Apache-2.0")
    set("pkgLicenseUrl", "http://www.apache.org/licenses/LICENSE-2.0.txt")
    set("devInfoId", "ajalt")
    set("devInfoName", "AJ Alt")
    set("devInfoUrl", "https://github.com/ajalt")
    set("bintrayUser", System.getenv("BINTRAY_USER"))
    set("bintrayKey", System.getenv("BINTRAY_API_KEY"))
    set("mavenUserToken", System.getenv("MAVEN_USER_TOKEN"))
    set("mavenUserPass", System.getenv("MAVEN_USER_PASS"))
    set("deployDryRun", false)
}

apply(from = "../deploy.gradle.kts")


