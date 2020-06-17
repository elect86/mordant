buildscript {

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:0.10.1")
    }
}

apply(plugin = "idea")
apply(plugin = "kotlin")

plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions.experimentalWarning.set(false)

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = findProperty("GROUP")!!
    version = findProperty("VERSION_NAME")!!

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {

        implementation(kotlin("stdlib"))

        testImplementation("junit:junit:4.13")
        listOf(/*"runner-junit5",*/ "assertions-core"/*, "runner-console", "property"*/).forEach {
            testImplementation("io.kotest:kotest-$it-jvm:4.0.5")
        }
    }

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "1.6"
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = "1.6"
        }
    }
}
