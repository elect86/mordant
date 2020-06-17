repositories {
    mavenCentral()
}

apply(plugin = "maven")
//apply(plugin = "com.jfrog.bintray")

plugins {
    id("com.jfrog.bintray") version "1.8.2"
}

val versionTag = findProperty("VERSION_NAME")!!
val githubRepo = extra.get("githubRepo") as String
val githubUrl = "https://$githubRepo"
val scmUrl = "scm:git:git://$githubRepo.git"

//extensions.getByType()

//bintray {
//    operator fun String.invoke() = extra.get(this) as String

//    user = "bintrayUser"()
//    key = bintrayKey
//    dryRun = deployDryRun // Whether to run this as dry-run, without deploying
//    publish = true // If version should be auto published after an upload
//    configurations = ['archives'] // Use the archives Configuration.
//    pkg {
//        repo = 'maven'
//        name = pkgName
//        userOrg = user
//        licenses = [pkgLicense]
//        publicDownloadNumbers = false
//        vcsUrl = githubUrl + '.git'
//        desc = pkgDesc
//        websiteUrl = githubUrl
//        issueTrackerUrl = githubUrl + '/issues'
//        version {
//            name = versionTag
//            desc = pkgDesc
//            vcsTag = versionTag
//            released  = new Date()
//            gpg {
//                sign = true // Determines whether to GPG sign the files.
//            }
//            mavenCentralSync {
//                sync = true // Optional (true by default). Determines whether to sync the version to Maven Central.
//                user = mavenUserToken // OSS user token
//                password = mavenUserPass // OSS user password
//                close = '1' // Close staging repository and release artifacts to Maven Central. Default = 1 (true). Set to 0 = You will release the version manually.
//            }
//        }
//    }
//}

//install {
//    repositories.mavenInstaller {
//        pom.name = pkgName
//        pom.version = versionTag
//        pom.artifactId = pkgName
//        pom.project {
//            name pkgName
//            packaging 'bundle'
//            description pkgDesc
//            url githubUrl
//
//            scm {
//                url githubUrl
//                connection scmUrl
//                developerConnection scmUrl
//            }
//
//            developers {
//                developer {
//                    id = devInfoId
//                    name = devInfoName
//                    url = devInfoUrl
//                }
//            }
//
//            licenses {
//                license {
//                    name pkgLicense
//                    url pkgLicenseUrl
//                    distribution 'repo'
//                }
//            }
//        }
//    }
//}
