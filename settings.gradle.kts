pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("appCoreLibs") {
            from(files("appCore/gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "HexagonApp"
include(":app")
include(":webClient")
include(":localData")
include(":ui")
include(":appCore")
include(":appCore:data")
include(":appCore:domain")
include(":appCore:di")
include(":appCore:presentation")
