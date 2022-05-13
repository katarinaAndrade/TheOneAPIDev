import dependencies.extension.implementations
import dependencies.AppDependencies.firebaseBOM
import dependencies.AppDependencies.picasso
import dependencies.AppDependenciesLibs.firebaseLibs

plugins {
    id("whitelabel-module-ui")
}

dependencies {

    implementation(projects.config.ui)
    implementation(projects.home.domain)

    implementation(picasso)
    implementation(platform(firebaseBOM))
    implementations(firebaseLibs)



}