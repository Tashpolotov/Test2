pluginManagement {
    repositories {
        google()
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
}

rootProject.name = "Test"
include(":app")
include(":breafly")
include(":hotel")
include(":profile")
include(":subscriptions")
include(":ticket")
include(":core:core_utils")
